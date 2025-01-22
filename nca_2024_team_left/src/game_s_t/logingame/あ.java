package game_s_t.logingame;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class あ {
    public static void main(String[] args) {
        
        い ex = new い();
        
        
        ex.no1();
        
        い instance = new い();
        instance.no1();
    
    File soundFile = new File("C:\\Users\\cre1\\git\\nca_2024_java1_team_l\\nca_2024_team_left\\src\\数字当て\\i_5min.wav");


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
