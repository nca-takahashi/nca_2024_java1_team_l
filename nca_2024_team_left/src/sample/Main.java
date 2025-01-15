package sample;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JPanel {
    private Image image; // 画像オブジェクト
    private int x = 0; // 画像の初期位置
    private final int SPEED = 10; // 移動速度

    private int timeRemaining = 30; // 残り時間（秒）

    public Main() {
        try {
            // 画像を読み込む
            image = ImageIO.read(new File("C:/Users/cre1/git/nca_2024_java1_team_l/nca_2024_team_left/src/ウイルスバスター仮/Ibukin.png"));
        } catch (IOException e) {
            e.printStackTrace(); // 画像が読み込めない場合にエラーメッセージを表示
        }

        // タイマーを設定して、定期的に画面を更新
        Timer timer = new Timer(1000, new ActionListener() { // 1秒ごとに実行
            @Override
            public void actionPerformed(ActionEvent e) {
                // 画像を右に移動
                x += SPEED;

                // 画面の右端に達したら左端に戻る
                if (x > getWidth()) {
                    x = -image.getWidth(null);
                }

                // 残り時間をカウントダウン
                if (timeRemaining > 0) {
                    timeRemaining--;
                } else {
                    ((Timer) e.getSource()).stop(); // 0秒になったらタイマーを停止
                }

                // 再描画を要求
                repaint();
            }
        });
        timer.start(); // タイマーを開始
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // 背景を白で塗りつぶす
        setBackground(Color.WHITE);
        
        // 画像を描画
        g.drawImage(image, x, getHeight() / 2 - image.getHeight(null) / 2, this);
        
        // 経過時間（カウントダウン）の表示
        g.setColor(Color.BLACK); // 黒色で描画
        g.setFont(new Font("Serif", Font.BOLD, 30)); // フォント設定
        g.drawString("Time: " + timeRemaining + "s", 20, 30); // 残り時間を表示
    }

    public static void main(String[] args) {
        // フレームを作成
        JFrame frame = new JFrame("Moving Image with Countdown Timer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // ウィンドウのサイズ
        frame.add(new Main()); // MovingImageパネルをフレームに追加
        frame.setVisible(true); // フレームを表示
    }
}
