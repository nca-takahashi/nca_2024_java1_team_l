package 数字当て;

import java.awt.Desktop;
import java.awt.Font;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class い {
	public void no1() {
		JFrame frame = new JFrame("Hack");
		frame.setSize(600,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		JLabel label = new JLabel("ID:");
		label.setBounds(80,130,380,40);
		label.setFont(new Font("Arial",Font.PLAIN, 24));
		JTextField textField = new JTextField();
		textField.setBounds(180,130,280,40);
		textField.setFont(new Font("Arial", Font.PLAIN, 20));
		JButton button = new JButton("ヒント");
		button.setBounds(80,240,200,60);
	
		JButton button2 = new JButton("次へ");
		button2.setBounds(80,330,420,60);
	
		JButton button3 = new JButton("読み込み");
		button3.setBounds(300,240,200,60);
		
		
		button.addActionListener(e -> {
			try {
				URI uri = new URI("file:///D:/photoshop/web.html");
				Desktop.getDesktop().browse(uri);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		});
		
		button3.addActionListener(e ->{
			if(textField.getText().equals("***")){
				JFrame frame3 = new JFrame("正解");
				JLabel label3 = new JLabel("正解！読み込み完了");
				label3.setBounds(100,100,200,40);
				frame3.setLayout(null);
				frame3.add(label3);
				frame3.setSize(300,200);
				frame3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame3.setVisible(true);
			}else {
				JFrame frame3 = new JFrame("不正解");
				JLabel label3 = new JLabel("不正解！");
				label3.setBounds(100,100,200,40);
				frame3.setLayout(null);
				frame3.add(label3);
				frame3.setSize(300,200);
				frame3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame3.setVisible(true);
			}
		});
		
		button2.addActionListener(e ->{
			JFrame frame2 = new JFrame("Hack2");
			frame2.setLayout(null);
			JLabel label2 = new JLabel("パスワード:");
			label2.setBounds(20,30,80,20);
			JTextField textField2 = new JTextField();
			textField2.setBounds(100,30,150,20);
			JButton button4 = new JButton("ヒント");
			button4.setBounds(60,90,80,30);
			JButton button5 = new JButton("ログイン");
			button5.setBounds(150,90,80,30);
			
			frame2.add(label2);
			frame2.add(textField2);
			frame2.add(button3);
			frame2.add(button4);
			frame2.setSize(600, 500);
			frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frame2.setVisible(true);
		});
		
		
		
		
	
		frame.add(label);
		frame.add(textField);
		frame.add(button);
		frame.add(button2);
		frame.add(button3);
		frame.setVisible(true);
	}
	
	
	
	 
}

