package virusbuster;

// 色を扱うためのクラスをインポート
import java.awt.Color;
// フォントを扱うためのクラスをインポート
import java.awt.Font;
// グラフィックスを扱うためのクラスをインポート
import java.awt.Graphics;
// アクションイベントを扱うためのクラスをインポート
import java.awt.event.ActionEvent;
// アクションリスナーを扱うためのクラスをインポート
import java.awt.event.ActionListener;
// マウスアダプターを扱うためのクラスをインポート
import java.awt.event.MouseAdapter;
// マウスイベントを扱うためのクラスをインポート
import java.awt.event.MouseEvent;
// 配列リストを扱うためのクラスをインポート
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
// パネルを扱うためのクラスをインポート
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
// タイマーを扱うためのクラスをインポート
import javax.swing.Timer;

import game_s_t.Start;

/**
 * ゲームのメインパネルを表すクラス。
 * ゲームのロジックと描画を管理します。
 */
public class GamePanel extends JPanel implements ActionListener {

    // プレイヤーのライフを管理
    private int playerLife = 3; 
    // ウイルスのリストを保持
    private ArrayList<VirusObject> viruses; 
    // ゲームの更新タイマー
    private Timer gameTimer; 
    // ゲームオーバー点滅用タイマー
    private Timer blinkTimer; 
    // 30秒カウントダウンタイマー
    private Timer countdownTimer; 
    // ゲームオーバー表示の制御
    private boolean showGameOver = false; 
    // クリア表示の制御
    private boolean showClear = false; 
    // スコアを管理（オプション）
    private int score = 0; 
    // 残り時間（秒）を管理
    private int timeLeft = 30; 
    // ゲームが一時停止しているかどうかを管理
    private boolean gamePaused = false; 
    private int blinkCount = 0;
    /**
     * GamePanelのコンストラクタ。
     * ゲームの初期設定を行います。
     */
    public GamePanel() {
        // ウイルスのリストを初期化
        this.viruses = new ArrayList<>();
        // ゲームの更新タイマーを20ミリ秒ごとに設定
        this.gameTimer = new Timer(20, this); 
     // 点滅回数を制御するカウント変数を追加
       

        // ゲームオーバー点滅タイマーを500ミリ秒ごとに設定
        this.blinkTimer = new Timer(500, e -> {
            toggleGameOver(); // 点滅の切り替え
            blinkCount++; // 点滅回数を増加

            // 一定回数（例: 6回）点滅したら停止
            if (blinkCount >= 6) {
            	 blinkTimer.stop(); // 点滅タイマーを停止s
            	 showGameOverWindow();
                blinkCount = 0; // カウントをリセット
            }

            repaint(); // 再描画を強制
        });
        // 1秒ごとに残り時間を更新するタイマーを設定
        this.countdownTimer = new Timer(1000, e -> updateTime()); 

        // 背景色を黒に設定
        setBackground(Color.BLACK); 

        // マウスクリックイベントを追加
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // ゲームが一時停止していない場合のみウイルスを削除
                if (!showGameOver && !showClear && !gamePaused) {
                    removeVirusAt(e.getX(), e.getY());
                }
            }
        });
    }

    /**
     * ゲームを開始するメソッド。
     * タイマーを開始し、ゲームの状態を初期化します。
     */
    public void startGame() {
        // ゲームのタイマーを開始
        gameTimer.start(); 
        // 30秒カウントダウンを開始
        countdownTimer.start(); 
        // ゲームが開始されたら一時停止フラグをリセット
        gamePaused = false; 
        // ゲーム開始時にはクリア表示をリセット
        showClear = false; 
        // ゲームオーバー表示をリセット
        showGameOver = false; 
        // タイマーを初期化
        timeLeft = 30; 
        // ライフを初期化
        playerLife = 3; 
        // ウイルスリストを初期化
        viruses.clear(); 
    }

    /**
     * アクションイベントが発生したときに呼び出されるメソッド。
     * ゲームの状態を更新します。
     * 
     * @param e アクションイベント
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // ゲームオーバーまたはクリア時には何もしない
        if (showGameOver || showClear || gamePaused) {
            return;
        }

        // 新しいウイルスを一定間隔で生成
        if (Math.random() < 0.07) { // 7%の確率でウイルスを生成
            // ウイルスが重ならないように位置をランダムで選ぶ
            int yPosition = (int) (Math.random() * (getHeight() - VirusObject.HEIGHT));
            if (!isVirusPositionOccupied(yPosition)) { // 重ならない場合のみ追加
                viruses.add(new VirusObject(getWidth(), yPosition)); // ウイルスの位置をランダムに生成
            }
        }

        // ウイルスを移動させ、画面外に出たウイルスを削除
        for (int i = 0; i < viruses.size(); i++) {
            VirusObject virus = viruses.get(i);
            virus.move();
            if (virus.getX() < 0) { // 画面左端に達したらライフを減らす
                playerLife--;
                viruses.remove(i); // そのウイルスは削除
                i--; // インデックスを調整
            }
        }

        // ゲームオーバー処理
        if (playerLife <= 0 && !blinkTimer.isRunning()) {
            blinkTimer.start(); // ゲームオーバー点滅タイマーを開始
            checkGameOver(); // ゲームオーバー判定
        }

        // 画面が更新されるときに再描画
        repaint();
    }

    /**
     * パネルの描画を行うメソッド。
     * ゲームの状態に応じて描画内容を更新します。
     * 
     * @param g グラフィックスオブジェクト
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // ライフの表示
        g.setColor(Color.WHITE);
        g.drawString("ライフ: " + playerLife, 20, 20);

        // スコアの表示（オプション）
        g.drawString("スコア: " + score, 20, 40);

        // 残り時間の表示
        g.drawString("残り時間: " + timeLeft + "秒", getWidth() - 120, 20);

        // ウイルスの描画
        for (VirusObject virus : viruses) {
            virus.draw(g);
        }

        // ゲームオーバーの処理
        if (playerLife <= 0 && showGameOver) {
            g.setColor(Color.RED);
            // 日本語フォントを明示的に指定
            g.setFont(new Font("MS ゴシック", Font.BOLD, 50)); // MS ゴシックに変更
            g.drawString("ゲームオーバー", getWidth() / 2 - 150, getHeight() / 2);
        }

        // クリアの処理
        if (showClear) {
            g.setColor(Color.GREEN);
            g.setFont(new Font("MS ゴシック", Font.BOLD, 50)); // MS ゴシックに変更
            g.drawString("クリア!", getWidth() / 2 - 100, getHeight() / 2);
        }
    }

    /**
     * 残り時間を更新するメソッド。
     * 残り時間が0になった場合、ゲームオーバーをチェックします。
     */
    private void updateTime() {
        if (timeLeft > 0 && playerLife > 0) {
            timeLeft--; // 残り時間を減らす
        } else if (timeLeft == 0) {
            // 残り時間が0になった時点でクリアチェックを行う
            checkGameOver();
        }
    }

    /**
     * ゲームオーバーをチェックするメソッド。
     * ライフが0の場合はゲームオーバー、それ以外はクリアとします。
     */
    private void checkGameOver() {
        // 30秒経過後、ライフが0ならゲームオーバー、それ以外はクリア
        if (timeLeft == 0 || playerLife <= 0) {
 
                showGameOver = true; // ゲームオーバー表示を有効にす
               
                countdownTimer.stop(); // カウントダウンタイマーを停止
                gameTimer.stop(); // ゲームのタイマーも停止
                gamePaused = true; // ゲーム停止状態にする
            } else {
                showClear = true; 
                showClearWindow();  // クリア表示を有効にする
                countdownTimer.stop(); // カウントダウンタイマーを停止
                gameTimer.stop(); // ゲームのタイマーも停止
                gamePaused = true; // ゲーム停止状態にする
            }
            repaint(); // 画面の再描画を強制
        }

    
    
	private void showGameOverWindow() {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	
                // ゲームオーバーウィンドウの作成
                JFrame frame = new JFrame("ゲームオーバー");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // ウィンドウを閉じたら終了
                frame.setSize(800, 600);  // ウィンドウのサイズ
                frame.setLocationRelativeTo(null);  // 画面中央に表示

                // レイアウトをnullに設定
                frame.setLayout(null);

                // ラベルを作成し、テキストを設定
                JLabel label = new JLabel("ゲームオーバー");
                label.setBounds(200, 100, 400, 100);
                label.setFont(new Font("MS ゴシック", Font.BOLD, 50)); // フォント設定
                label.setForeground(Color.GREEN);  // 文字色を緑に設定

                // ラベルをフレームに追加
                frame.add(label);

                // ボタンを作成して設定
                JButton btn = new JButton("RESTART");
                btn.setFont(new Font("Arial", Font.PLAIN, 50));
                btn.setBounds(180, 350, 400, 80);
                btn.setForeground(Color.BLUE);
                btn.setBackground(Color.WHITE);
                
                // ボタンのアクションリスナーを追加
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	
                        startGame();  // 新しいゲームを開始
                        frame.dispose();  // ゲームオーバーウィンドウを閉じる
                    }
                });

                // ボタンをフレームに追加
                frame.add(btn);

                // フレームの背景色を設定
                frame.getContentPane().setBackground(Color.BLACK);

                // ウィンドウを表示
                frame.setVisible(true);
            }
        });
    }


	private void showClearWindow() {
		
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	 
                // ゲームクリアウィンドウの作成
                JFrame frame = new JFrame("ゲームクリア");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // ウィンドウを閉じたら終了
                frame.setSize(800, 600);  // ウィンドウのサイズ
                frame.setLocationRelativeTo(null);  // 画面中央に表示

                // レイアウトをnullに設定
                frame.setLayout(null);

                // ラベルを作成し、テキストを設定
                JLabel label = new JLabel("ゲームクリア!");
                label.setBounds(200, 100, 400, 100);
                label.setFont(new Font("MS ゴシック", Font.BOLD, 50)); // フォント設定
                label.setForeground(Color.GREEN);  // 文字色を緑に設定

                // ラベルをフレームに追加
                frame.add(label);
                

                // ボタンを作成して設定
                JButton btn = new JButton("START");
                btn.setFont(new Font("Arial", Font.PLAIN, 50));
                btn.setBounds(280, 350, 250, 80);
                btn.setForeground(Color.BLUE);
                btn.setBackground(Color.WHITE);

                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        // ゲーム開始処理（新しいゲームを開始）
                        // まず、現在のゲームウィンドウを閉じる
                        frame.dispose(); 
                        // ゲームクリアウィンドウを閉じる

                        // 次のゲームに移動
                        
                        Start.main(new String[]{}); // `Start`クラスの`main`メソッドを呼び出す
                    }
                });

                // ボタンをフレームに追加
                frame.add(btn);

                // フレームの背景色を設定
                frame.getContentPane().setBackground(Color.BLACK);

                // ウィンドウを表示
                frame.setVisible(true);
            }
        });
    }
	
	
    /**
     * ゲームオーバー表示を切り替えるメソッド。
     * 表示をトグルし、再描画を行います。
     */
	private void toggleGameOver() {
	    showGameOver = !showGameOver;
	   repaint();
	}

    /**
     * ウイルスの位置が他のウイルスと重なっているか確認するメソッド。
     * 
     * @param yPosition チェックするY座標
     * @return 重なっている場合はtrue、そうでない場合はfalse
     */
    private boolean isVirusPositionOccupied(int yPosition) {
        for (VirusObject virus : viruses) {
            if (Math.abs(virus.getY() - yPosition) < VirusObject.HEIGHT) { // 高さが重なっている場合
                return true; // 重なっている
            }
        }
        return false; // 重なっていない
    }

    /**
     * マウスクリックでウイルスを削除するメソッド。
     * 
     * @param mouseX クリックされたX座標
     * @param mouseY クリックされたY座標
     */
    private void removeVirusAt(int mouseX, int mouseY) {
        for (int i = 0; i < viruses.size(); i++) {
            VirusObject virus = viruses.get(i);
            // クリック位置がウイルスの範囲内にあればそのウイルスを削除
            if (mouseX >= virus.getX() && mouseX <= virus.getX() + VirusObject.WIDTH &&
                    mouseY >= virus.getY() && mouseY <= virus.getY() + VirusObject.HEIGHT) {
                viruses.remove(i);
                score += 10; // ウイルスを倒したらスコア加算
                break; // 1つのウイルスを削除したらループを終了
            }
        }
    } 
    
 
    
}
