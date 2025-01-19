package test;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Ex {
	public void tutorial() {
		JFrame frame = new JFrame("説明");
		frame.setLayout(new BorderLayout());
		frame.add(new JLabel("テスト"), BorderLayout.CENTER);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static boolean checkClick = false;
	public void frame1() {
		String[] Data = {
				"AA","BB","CC","DD","EE","FF","GG","HH","II","JJ","KK","LL","MM","NN","OO","PP","QQ","RR","SS","TT","UU","VV","WW","XX",
				"AA","BB","CC","DD","EE","FF","GG","HH","II","JJ","KK","LL","MM","NN","OO","PP","QQ","RR","SS","TT","UU","VV","WW","XX"};		
		JLabel[] labels = new JLabel[24];
		
		//問題用の乱数
		Random rand = new Random();
		int randInt = rand.nextInt(23);
		int randArea = rand.nextInt(23);
		
		//一応表示
		System.out.println("randInt：" + randInt + "　randArea：" + randArea);
		
		
		
		JFrame frame = new JFrame("ゲーム");
		frame.setLayout(null);
		frame.setSize(800, 600);


		
		//タイトル
		JLabel title = new JLabel("[" + Data[randInt] + " " + Data[randInt+1] + " " + Data[randInt+2] + " " + Data[randInt+3] + "]");
		title.setBounds(330,100,200,30);
		title.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(title);
		
		
		//透明ボタン
		JButton button = new JButton();
		button.setBounds(1000,1000,60,40);
//		button.setOpaque(false);
//		button.setContentAreaFilled(false);
//		button.setBorderPainted(false);
		frame.add(button);
		
		
		//ラベルの作成(24個)
		 for (int i = 0; i < 24; i++) {
	            
	        	if (i < 8) {
	        		labels[i] = new JLabel(Data[i]);
	                labels[i].setBounds(100+i*80,150,300,60);
	                labels[i].setFont(new Font("Arial", Font.BOLD, 30));
	                frame.add(labels[i]);
	                
	        	}else if (i < 16) {
	        		labels[i] = new JLabel(Data[i]);
	                labels[i].setBounds(100+(i-8)*80,250,300,60);
	                labels[i].setFont(new Font("Arial", Font.BOLD, 30));
	                frame.add(labels[i]);
	                
	        	}else {
	        		labels[i] = new JLabel(Data[i]);
	                labels[i].setBounds(100+(i-16)*80,350,300,60);
	                labels[i].setFont(new Font("Arial", Font.BOLD, 30));
	                frame.add(labels[i]);
	        	}
	        }
		 
		 
		 button.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                checkClick = true;
	                System.out.println("ボタンがクリックされました！");
	            }
	        });
		 
	     //ラベルの文字を移動
		 Timer timer = new Timer(2000, new ActionListener() {
			 int areaIndex = randArea;  // ラベルのテキスト変更に使うインデックス
			 int randIndex = randInt;
			 
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 
				 
				 //ラベルのテキスト更新
				 for (int i = 0; i < 24; i++) {
					 labels[i].setText(Data[i + areaIndex]);
				 }
				 
				 
				 if (randIndex <9 && randIndex >=4) {
					 button.setBounds(420-(randIndex-4)*80,360,60,40);

				 }else if (areaIndex < 13 && areaIndex >= 8) {
					 button.setBounds(100-areaIndex*80,260,60,40);
					 
				 }else if (areaIndex < 21 && areaIndex >= 16) {
					 button.setBounds(100-areaIndex*80,360,60,40);
					 
				 }else {
					 button.setBounds(1000,1000,60,40);
				 }
				 
				 
				 System.out.println("areaIndexは" + areaIndex);
				 System.out.println("randIndexは" + randIndex);
				 areaIndex = (areaIndex + 1) % 24;  // インデックスが24を超えたらリセット
				 randIndex = (randIndex + 1) % 24;
				 
				 //クリックフラグが立っていたら処理を終了
				 if (checkClick) {
					 System.out.println("クリックされたので終了します");
					 ((Timer) e.getSource()).stop();  // タイマーを停止
					 }
				 }
	        });

	        // タイマーを開始
	        timer.start();
	        
		 
		 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}