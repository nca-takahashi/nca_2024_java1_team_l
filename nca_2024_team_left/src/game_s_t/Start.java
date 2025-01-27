package game_s_t;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import game_s_t.codeawase.game;
import game_s_t.logingame.い;

public class Start {

    private static boolean codeclear = false;

    public static void main(String[] args) {

        // 2番目のゲーム
        game gameInstance = new game();

        // ゲームを開始
        startGame(gameInstance);

        // フラグ回収までループ
        while (!codeclear) {
            try {
                // フラグがtrueになるまでスリープ（待機）する
                Thread.sleep(1000); // 1秒待機
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 2秒待機
        try {
            Thread.sleep(2000);  // 2秒待機
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 3番目のゲーム
        い ex = new い();
        ex.no1();

        い instance = new い();
        instance.no1();

        // 音声再生
        playAudio();
    }

    private static void startGame(game gameInstance) {
        gameInstance.stage1(new game.GameClearListener() {
            @Override
            public void onGameClear() {
                // ゲームクリア時にフラグを更新
                codeclear = true;
            }

            @Override
            public void onGameOver() {
                // ゲームオーバー時の処理
                System.out.println("ゲームオーバー!");

                // ゲームオーバー画面を表示
                JFrame frame = new JFrame("ゲームオーバー!");
                frame.setLayout(null);
                frame.setSize(800, 600);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setResizable(false);
                frame.setVisible(true);
                
                JLabel title = new JLabel("ゲームオーバー!");
                title.setFont(new Font("", Font.PLAIN, 30));
                title.setBounds(310,100,400,30);
                frame.add(title);

                // リセットボタン
                JButton resetButton = new JButton("リセット");
                resetButton.setBounds(310, 500, 200, 30);
                frame.add(resetButton);

                // ボタンのアクションリスナー
                resetButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // ボタンがクリックされた時の処理
                        codeclear = false; // フラグをリセット
                        gameInstance.resetGame();
                        startGame(gameInstance); // ゲームを再スタート
                        frame.setVisible(false); // ゲームオーバー画面を非表示にする
                    }
                });
            }
        });
    }

    // 音声再生
    private static void playAudio() {
        File soundFile = new File("C:/temp/java/i_5min.wav");

        try {
            // オーディオファイルを読み込む
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

            // オーディオフォーマットとデータラインの取得
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);

            // 再生開始
            clip.start();

            // 再生が終了するまで待機
            System.out.println("音声を再生中...");
            while (!clip.isRunning()) {
                Thread.sleep(100);
            }
            while (clip.isRunning()) {
                Thread.sleep(100);
            }

            // 再生完了後にリソースを解放
            clip.close();
            audioIn.close();
            System.out.println("再生完了");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
