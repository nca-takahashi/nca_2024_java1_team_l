package game_s_t;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import game_s_t.codeawase.game;
import game_s_t.logingame.い;

public class Start {
	
	private static boolean codeclear = false;
	
/*	
	public static Image loadImage(String Ibukin) {
        try {
            // プロジェクトのbinフォルダ内の画像を読み込む
            return ImageIO.read(new File("bin\\ウイルスバスター仮\\" + Ibukin));
        } catch (IOException e) {
            e.printStackTrace();
            return null; // 画像が読み込めない場合はnullを返す
        }
    }
*/	
	public static void main(String[] args) {
		
		
		
		//１番目のゲーム
		
/*		
		JFrame frame = new JFrame("ウイルスバスター");
        GamePanel gamePanel = new GamePanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // ウィンドウのサイズ
        frame.add(gamePanel);
        frame.setVisible(true);
        gamePanel.startGame();
		
*/		
		
		
		
		//2番目のゲーム
		game game = new game();
		
		
		 game.stage1(new game.GameClearListener() {
	            @Override
	            public void onGameClear() {
	                // ゲームクリア時にフラグを更新
	                codeclear = true;
	            }

	            @Override
	            public void onGameOver() {
	                // ゲームオーバー時の処理（必要に応じて）
	                System.out.println("ゲームオーバー!");
	            }
	        });
		 
	            
//		game.tutorial();
//		game.stage1();
		
		
		
		
		//フラグ回収までループ
		while (!codeclear) {
            try {
                // フラグがtrueになるまでスリープ（待機）する
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
