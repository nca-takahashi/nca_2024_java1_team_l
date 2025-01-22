package r;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Main {
	public static void main(String[] args) {
		
		
		// TODO 自動生成されたメソッド・スタブ
		JFrame frame = new JFrame("");
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setSize(800, 600);
		  
		  frame.setLayout(null);
		  frame.setVisible(true);
		
		  
		JLabel label = new JLabel("Virus Buster");
		
		label.setBounds(130, 100, 600, 100);
		label.setFont(new java.awt.Font("Arial",java.awt.Font.PLAIN,100));
		Color p = new Color(128,0,171);
	    label.setForeground(p);
		frame.add(label);
		
		JButton btn = new JButton("START");
		btn.setFont(new java.awt.Font("Arial",java.awt.Font.PLAIN,50));
		btn.setBounds(280,350,250,80);
		btn.setForeground(Color.BLUE);
	    btn.setBackground(Color.WHITE);

		frame.add(btn);
		
		
		frame.getContentPane().setBackground(Color.BLACK);
		
		 btn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // ボタンが押されたときにMP4ファイルを開く
	                try {
	                    File videoFile = new File("//172.20.34.11/students/_JAVA高橋/java.mp4");
	                    if (videoFile.exists()) {
	                    	
	                        // デフォルトのアプリケーションでファイルを開く
	                        Desktop.getDesktop().open(videoFile);
	                        frame.setVisible(false);
	                        
	                    } else {
	                        JOptionPane.showMessageDialog(frame, "指定された動画ファイルが見つかりません。");
	                    }
	                } catch (IOException ex) {
	                    ex.printStackTrace();
	                    JOptionPane.showMessageDialog(frame, "ファイルを開けませんでした。エラー: " + ex.getMessage());
	                    
	                    
	                        
	                }
					
				}
	        });
	 	}

	public  void main1(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Timer timer = new Timer(false);
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				Ex test = new Ex();
				test.test();
				
				
			}
		};
		timer.schedule(task, 1000);
	}

}
		


