package Game_Start;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Game_Start.codeawase.game;
import Game_Start.logingame.い;

public class Start {
	
	private static boolean codeclear = false;
	
	public static void main(String[] args) {
		
		
		//2番目のゲーム
		game game = new game();
		
//		game.tutorial();
		game.stage1();
		
		
		
		
		
		//フラグ回収までループ
		while (!codeclear) {
            try {
                // フラグがtrueになるまでスリープ（待機）する
                System.out.println("フラグがfalseなので待機中...");
                Thread.sleep(1000); // 1秒待機
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
		
		
		
		
		
		
		//２秒まつ
		 try {
	            Thread.sleep(2000);  // 2秒待機
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	    }
		
		
		 
		 
		 
		 
		 
		 
		
		//3番目のゲーム
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
