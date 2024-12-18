package ウイルスバスター仮;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("ウイルスバスター");
        GamePanel gamePanel = new GamePanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // ウィンドウのサイズ
        frame.add(gamePanel);
        frame.setVisible(true);
        gamePanel.startGame();
    }
}

class GamePanel extends JPanel implements ActionListener {
    private int playerLife = 3; // プレイヤーのライフ
    private ArrayList<Virus> viruses; // ウイルスのリスト
    private Timer gameTimer; // ゲームのタイマー
    private Timer blinkTimer; // ゲームオーバー点滅用タイマー
    private boolean showGameOver = false; // ゲームオーバー表示の制御
    private int score = 0; // スコア（オプション）

    public GamePanel() {
        this.viruses = new ArrayList<>();
        this.gameTimer = new Timer(20, this); // ゲームの更新タイマー（20ミリ秒ごと）
        this.blinkTimer = new Timer(500, e -> toggleGameOver()); // 500ミリ秒ごとに点滅
        setBackground(Color.BLACK); // 背景色
    }

    public void startGame() {
        gameTimer.start(); // ゲームのタイマーを開始
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
        }

        // 画面が更新されるときに再描画
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // ライフの表示
        g.setColor(Color.WHITE);
        g.drawString("ライフ: " + playerLife, 20, 20);

        // スコアの表示（オプション）
        g.drawString("スコア: " + score, 20, 40);

        // ウイルスの描画
        for (Virus virus : viruses) {
            virus.draw(g);
        }

        // ゲームオーバーの処理
        if (playerLife <= 0 && showGameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("ゲームオーバー", getWidth() / 2 - 150, getHeight() / 2);
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
}

class Virus {
    private int x, y; // ウイルスの位置
    public static final int WIDTH = 50; // ウイルスの幅
    public static final int HEIGHT = 50; // ウイルスの高さ

    public Virus(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        x -= 2; // ウイルスを左に移動
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, WIDTH, HEIGHT); // ウイルスを描画
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
