package game_codeate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class musiczip {
    public static void main(String[] args) {
        try {
            // ZIPファイルを開く
            File zipFile = new File("point.zip");
            ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
            ZipEntry entry = null;
            
            // ZIP内のエントリを確認
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".wav")) { // 例として.wavファイルを探す
                    File tempFile = File.createTempFile("audio", ".wav");  // 一時的なファイルを作成
                    tempFile.deleteOnExit();  // プログラム終了時に削除される

                    FileOutputStream fos = new FileOutputStream(tempFile);
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                    fos.close();
                    zis.closeEntry();

                    // 音声の再生
                    playAudio(tempFile);
                    break; // 最初の音声ファイルを処理後終了
                }
            }
            zis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 音声の再生
    private static void playAudio(File audioFile) {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            // 音楽が再生されるのを待つ
            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}