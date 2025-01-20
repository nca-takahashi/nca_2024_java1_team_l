package 数字当て;

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
        
        // 音楽ファイルのパス
        String filePath = "D:\\track02 (online-audio-converter.com).wav";
        
        // 音楽を再生
        playMusic(filePath);
        
        
        ex.no1();
        
        い instance = new い();
        instance.no1();
    }
    private static void playMusic(String filePath) {
        // 音楽を別スレッドで再生する
        new Thread(() -> {
            try {
                // 音楽ファイルを指定
                File soundFile = new File(filePath);
                
                // ファイルの存在チェック
                if (!soundFile.exists()) {
                    System.out.println("指定されたファイルが見つかりません。");
                    return;
                }

                // AudioInputStreamを取得
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                
                // Clipオブジェクトを取得
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                
                // 音楽を再生
                clip.start();
                
                // 音楽が終了するまで待機
                while (clip.isRunning()) {
                    Thread.sleep(100);  // 100msごとに待機
                }
                
                // 音楽再生後、リソースを解放
                clip.close();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
                e.printStackTrace();
                System.out.println("音楽の再生中にエラーが発生しました: " + e.getMessage());
            }
        }).start();
    }
}
