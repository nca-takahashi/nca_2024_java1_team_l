package r;

import java.awt.Desktop;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ex {
	public void no1() {
		JFrame frame = new JFrame("Hack");
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		JLabel label = new JLabel("ID:");
		label.setBounds(20,30,80,20);
		JTextField textField = new JTextField();
		textField.setBounds(100,30,150,20);
		JButton button = new JButton("ヒント");
		button.setBounds(60,90,80,30);
		JButton button2 = new JButton("次へ");
		button2.setBounds(150,90,80,30);
		
		button.addActionListener(e -> {
			try {
				URI uri = new URI("file:///D:/photoshop/web.html");
				Desktop.getDesktop().browse(uri);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		});
		
		button.addActionListener(e ->{
			JFrame frame2 = new JFrame("Hack2");
			frame2.setLayout(null);
			JLabel label2 = new JLabel("パスワード:");
			label2.setBounds(20,30,80,20);
			JTextField textField2 = new JTextField();
			textField2.setBounds(100,30,150,20);
			JButton button3 = new JButton("ヒント");
			button.setBounds(60,90,80,30);
			JButton button4 = new JButton("ログイン");
			button.setBounds(150,90,80,30);
			frame2.add(button3);
			frame2.add(button4);
			frame2.add(label2);
			frame2.setSize(300, 200);
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frame2.setVisible(true);
		});
		
		
		
		
	
		frame.add(label);
		frame.add(textField);
		frame.add(button);
		frame.add(button2);
		frame.setVisible(true);
	}
	
	
	
	 
}

