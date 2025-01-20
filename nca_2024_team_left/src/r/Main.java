package r;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


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
		
		
		
		
		
		}

	

	}

