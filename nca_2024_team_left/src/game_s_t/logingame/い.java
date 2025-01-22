package game_s_t.logingame;
 

import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		JButton button = new JButton("資料");
		button.setBounds(80,240,200,60);
		JButton button2 = new JButton("次へ");
		button2.setBounds(80,330,420,60);
	
		JButton button3 = new JButton("読み込み");
		button3.setBounds(300,240,200,60);
		
		
		button.addActionListener(e -> {
			try {
				  File pdfFile = new File("//172.20.34.11/students/_JAVA高橋/TeamLへ　ここに必要なファイルを入れておいて/java調査書類 1つ目.pdf");
				  if (pdfFile.exists()) {
                      
                      Desktop desktop = Desktop.getDesktop();
                      desktop.open(pdfFile);
                  } else {
                     
                      JOptionPane.showMessageDialog(frame, "PDFファイルが見つかりません。");
                  }
              } catch (IOException ex) {
                  ex.printStackTrace();
                  JOptionPane.showMessageDialog(frame, "PDFファイルを開けませんでした。");
              }
          
      });
		
		button3.addActionListener(e ->{
			if(textField.getText().equals("1978310")){
				JFrame frame3 = new JFrame("正解");
				JLabel label3 = new JLabel("読み込み成功");
				label3.setBounds(95,50,230,60);
				frame3.setLayout(null);
				frame3.add(label3);
				frame3.setSize(300,200);
				frame3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame3.setVisible(true);
			}else {
				JFrame frame3 = new JFrame("不正解");
				JLabel label3 = new JLabel("読み込み失敗");
				label3.setBounds(95,50,230,60);
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
			label2.setBounds(80,130,380,40);
			JTextField textField2 = new JTextField();
			textField2.setBounds(180,130,280,40);
			textField2.setFont(new Font("Arial", Font.PLAIN, 20));
			JButton button4 = new JButton("資料");
			button4.setBounds(80,240,200,60);
			JButton button5 = new JButton("読み込み");
			button5.setBounds(300,240,200,60);
			JButton button6 = new JButton("ログイン");
			button6.setBounds(80,330,420,60);
			
			button4.addActionListener(e1 -> {
				try {
					 File htmlFile = new File("//172.20.34.11/students/_JAVA高橋/HTML/webサイト.html");
					
					if (htmlFile.exists()) {
					    Desktop.getDesktop().browse(htmlFile.toURI());
					} else {
					    System.out.println("指定されたファイルは存在しません: " + htmlFile.getPath());
					}

				}catch(Exception ex) {
					ex.printStackTrace();
				}
			});
			
			 button5.addActionListener(event -> {
                 String enteredPassword = textField2.getText();
                 if (enteredPassword.equals("2009QuickTask")) {
                     // 正解の場合
                	 try {
                		    
                		    File videoFile = new File("//172.20.34.11/students/_JAVA高橋/TeamLへ　ここに必要なファイルを入れておいて/java ending.mp4");
                		    
                		    
                		    if (videoFile.exists()) {
                		        
                		        Desktop desktop = Desktop.getDesktop();
                		        desktop.open(videoFile);
                		    } else {
                		        
                		        JOptionPane.showMessageDialog(null, "動画ファイルが見つかりません。\n指定されたパスを確認してください。");
                		    }
                		} catch (IOException e1) {
          
                		    e1.printStackTrace();
                		    JOptionPane.showMessageDialog(null, "動画を開けませんでした。\n詳細: " + e1.getMessage());
                		}

                 } else {
                     // 不正解の場合
                     JFrame incorrectFrame = new JFrame("不正解");
                     JLabel incorrectLabel = new JLabel("読み込み失敗");
                     incorrectLabel.setBounds(95,50,230,60);
                     incorrectFrame.setLayout(null);
                     incorrectFrame.add(incorrectLabel);
                     incorrectFrame.setSize(300, 200);
                     incorrectFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                     incorrectFrame.setVisible(true);
                 }
             });
			frame2.add(label2);
			frame2.add(textField2);
			frame2.add(button4);
			frame2.add(button5);
			frame2.add(button6);
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

