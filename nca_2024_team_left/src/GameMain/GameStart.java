package GameMain;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import game_s_t.Start;
/**
 * ゲームを開始するためのクラス。
 * ウィンドウを表示し、スタートボタンを押すと動画を再生し、その後ゲームを開始します。
 */
public class GameStart {

	/**
	 * メインメソッド。プログラムのエントリーポイント。
	 * ウィンドウを作成し、スタートボタンを設定します。
	 * 
	 * @param args コマンドライン引数
	 */
	private static boolean showClear = false;
	
	public static void main(String[] args) {

		// 新しいJFrameを作成
		JFrame frame = new JFrame("");
		// ウィンドウを閉じたときにプログラムを終了するように設定
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ウィンドウのサイズを設定
		frame.setSize(800, 600);
		// ウィンドウを画面の中央に表示
		frame.setLocationRelativeTo(null);

		// レイアウトをnullに設定
		frame.setLayout(null);
		// ウィンドウを表示
		frame.setVisible(true);

		// ラベルを作成し、テキストを設定
		JLabel label = new JLabel("Virus Buster");

		// ラベルの位置とサイズを設定
		label.setBounds(130, 100, 600, 100);
		// ラベルのフォントを設定
		label.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 100));
		// カスタムカラーを作成
		Color p = new Color(128, 0, 171);
		// ラベルの文字色を設定
		label.setForeground(p);
		// ラベルをフレームに追加
		frame.add(label);

		// ボタンを作成し、テキストを設定
		JButton btn = new JButton("START");
		// ボタンのフォントを設定
		btn.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 50));
		// ボタンの位置とサイズを設定
		btn.setBounds(280, 350, 250, 80);
		// ボタンの文字色を設定
		btn.setForeground(Color.BLUE);
		// ボタンの背景色を設定
		btn.setBackground(Color.WHITE);

		// ボタンをフレームに追加
		frame.add(btn);

		// フレームの背景色を設定
		frame.getContentPane().setBackground(Color.BLACK);

		// ボタンにアクションリスナーを追加
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ボタンが押されたときにMP4ファイルを開く
				try {
					// 動画ファイルのパスを指定
					// File videoFile = new File("//172.20.34.11/students/_JAVA高橋/HTML/java.mp4");
					File videoFile = new File("C:/temp/java/java.mp4");
					// ファイルが存在するか確認
					if (videoFile.exists()) {
						// デフォルトのアプリケーションでファイルを開く
						Desktop.getDesktop().open(videoFile);
						// 現在のフレームを非表示にする
						frame.setVisible(false);
						try {
							// 一時停止（実際には1ミリ秒）
							Thread.sleep(1000);
							// 新しいJFrameを作成
							JFrame frame = new JFrame("ウイルスバスター");
							// ウィンドウのサイズを設定
							frame.setSize(800, 600);
							// ウィンドウを画面の中央に表示
							frame.setLocationRelativeTo(null);
							// ゲームパネルを作成
							GamePanel gamePanel = new GamePanel();
							// ウィンドウを閉じたときにプログラムを終了するように設定
							frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							// ゲームパネルをフレームに追加
							frame.add(gamePanel);
							// ウィンドウを表示
							frame.setVisible(true);
							// ゲームを開始
							gamePanel.startGame();
							
						} catch (InterruptedException e1) {
							// 例外が発生した場合のスタックトレースを出力
							e1.printStackTrace();
						}
					} else {
						// ファイルが見つからない場合のメッセージを表示
						JOptionPane.showMessageDialog(frame, "指定された動画ファイルが見つかりません。");
					}
				} catch (IOException ex) {
					// 例外が発生した場合のスタックトレースを出力
					ex.printStackTrace();
					// ファイルを開けない場合のエラーメッセージを表示
					JOptionPane.showMessageDialog(frame, "ファイルを開けませんでした。エラー: " + ex.getMessage());
				}
			}
		});
		
		System.out.println("virusbuster2は" + showClear);
		
		while (!showClear) {
            try {
                // フラグがtrueになるまでスリープ（待機）する
                Thread.sleep(1000); // 1秒待機
                System.out.println("一秒");
                System.out.println("virusbuster秒は" + showClear);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
		
		try {
            Thread.sleep(1000);  // 2秒待機
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		System.out.println("virusbuster4は" + showClear);
		frame.setVisible(false);
		Start.main(new String[]{}); // `Start`クラスの`main`メソッドを呼び出す
	}
}
