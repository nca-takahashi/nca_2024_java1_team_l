package game_s_t.virusbuster;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Main {
}



class GamePanel extends JPanel implements ActionListener {
    private int playerLife = 3; // プレイヤーのライフ
    private ArrayList<Virus> viruses; // ウイルスのリスト
    private Timer gameTimer; // ゲームのタイマー
    private Timer blinkTimer; // ゲームオーバー点滅用タイマー
    private Timer countdownTimer; // 30秒タイマー
    private boolean showGameOver = false; // ゲームオーバー表示の制御
    private boolean showClear = false; // クリア表示の制御
    private int score = 0; // スコア（オプション）
    private int timeLeft = 30; // 残り時間（秒）
    private boolean gamePaused = false; // ゲームが一時停止しているかどうかを管理

    public GamePanel() {
        this.viruses = new ArrayList<>();
        this.gameTimer = new Timer(20, this); // ゲームの更新タイマー（20ミリ秒ごと）
        this.blinkTimer = new Timer(500, e -> toggleGameOver()); // 500ミリ秒ごとに点滅
        this.countdownTimer = new Timer(1000, e -> updateTime()); // 1秒ごとに残り時間を更新
        setBackground(Color.BLACK); // 背景色

        // マウスクリック
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

    public void startGame() {
        gameTimer.start(); // ゲームのタイマーを開始
        countdownTimer.start(); // 30秒カウントダウンを開始
        gamePaused = false; // ゲームが開始されたら一時停止フラグをリセット
        showClear = false; // ゲーム開始時にはクリア表示をリセット
        showGameOver = false; // ゲームオーバー表示をリセット
        timeLeft = 30; // タイマーを初期化
        playerLife = 3; // ライフを初期化
        viruses.clear(); // ウイルスリストを初期化
    }

    private void updateTime() {
        if (timeLeft > 0 && playerLife > 0) {
            timeLeft--; // 残り時間を減らす
        } else if (timeLeft == 0) {
            // 残り時間が0になった時点でクリアチェックを行う
            checkGameOver();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // ゲームオーバーまたはクリア時には何もしない
        if (showGameOver || showClear || gamePaused) {
            return;
        }

        // 新しいウイルスを一定間隔で生成
        if (Math.random() < 0.07) { // 7%の確率でウイルスを生成
            // ウイルスが重ならないように位置をランダムで選ぶ
            int yPosition = (int) (Math.random() * (getHeight() - Virus.HEIGHT));
            if (!isVirusPositionOccupied(yPosition)) { // 重ならない場合のみ追加
                viruses.add(new Virus(getWidth(), yPosition)); // ウイルスの位置をランダムに生成
            }
        }

        // ウイルスを移動させ、画面外に出たウイルスを削除
        for (int i = 0; i < viruses.size(); i++) {
            Virus virus = viruses.get(i);
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

    private void checkGameOver() {
        // 30秒経過後、ライフが0ならゲームオーバー、それ以外はクリア
        if (timeLeft == 0) {
            if (playerLife <= 0) {
                showGameOver = true; // ゲームオーバー表示を有効にする
                countdownTimer.stop(); // カウントダウンタイマーを停止
                gameTimer.stop(); // ゲームのタイマーも停止
                gamePaused = true; // ゲーム停止状態にする
            } else {
                showClear = true; // クリア表示を有効にする
                countdownTimer.stop(); // カウントダウンタイマーを停止
                gameTimer.stop(); // ゲームのタイマーも停止
                gamePaused = true; // ゲーム停止状態にする
            }
            repaint(); // 画面の再描画を強制
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // ライフの表示
        g.setColor(Color.WHITE);
        g.drawString("ライフ: " + playerLife, 20, 20);

        // スコアの表示（オプション）
        g.drawString("スコア: " + score, 20, 40);

        // 残り時間の表示
        g.drawString("残り時間: " + timeLeft + "秒", getWidth() - 120, 20);

        // ウイルスの描画
        for (Virus virus : viruses) {
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

    // ゲームオーバー表示の切り替え
    private void toggleGameOver() {
        showGameOver = !showGameOver;
        repaint(); // 再描画
    }

    // ウイルスの位置が他のウイルスと重なっているか確認
    private boolean isVirusPositionOccupied(int yPosition) {
        for (Virus virus : viruses) {
            if (Math.abs(virus.getY() - yPosition) < Virus.HEIGHT) { // 高さが重なっている場合
                return true; // 重なっている
            }
        }
        return false; // 重なっていない
    }

    // マウスクリックでウイルスを削除
    private void removeVirusAt(int mouseX, int mouseY) {
        for (int i = 0; i < viruses.size(); i++) {
            Virus virus = viruses.get(i);
            // クリック位置がウイルスの範囲内にあればそのウイルスを削除
            if (mouseX >= virus.getX() && mouseX <= virus.getX() + Virus.WIDTH &&
                mouseY >= virus.getY() && mouseY <= virus.getY() + Virus.HEIGHT) {
                viruses.remove(i);
                score += 10; // ウイルスを倒したらスコア加算
                break; // 1つのウイルスを削除したらループを終了
            }
        }
    }
}

class Virus {
    private int x, y; // ウイルスの位置
    private Image virusImage; // 画像を保存するフィールド

    public static final int WIDTH = 50; // ウイルスの幅
    public static final int HEIGHT = 50; // ウイルスの高さ

    // コンストラクタ: 位置と画像を設定
    public Virus(int x, int y) {
        this.x = x;
        this.y = y;

        // ImageLoaderを使用して画像を読み込む
        this.virusImage = ImageLoader.loadImage("Ibukin.png");
    }

    // ウイルスを左に移動させるメソッド
    public void move() {
        x -= 2; // ウイルスを左に移動
    }

    // ウイルスを描画するメソッド
    public void draw(Graphics g) {
        g.drawImage(virusImage, x, y, WIDTH, HEIGHT, null); // 画像を描画
    }

    // X座標を取得するメソッド
    public int getX() {
        return x;
    }

    // Y座標を取得するメソッド
    public int getY() {
        return y;
    }
}

