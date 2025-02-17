package ウイルスバスター仮;

		import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import r.Main;
		public class GAMESTART {

		    public static void main(String[] args) {
		        // JFrame（ウィンドウ）を作成
		    	Main main =new Main();
		        JFrame frame = new JFrame("ゲーム開始");
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setSize(800, 600); // ウィンドウのサイズ
		        frame.setLocationRelativeTo(null); // 画面中央にウィンドウを表示
		        frame.setResizable(false);//ウィンドウのサイズ変更不可

		        // パネルを作成
		        JPanel panel = new JPanel();
		        panel.setLayout(new FlowLayout(FlowLayout.CENTER,400,50));
		        //panel.setBackground(Color.LIGHT_GRAY);

		        // タイトルラベルを作成
		        JLabel titleLabel = new JLabel("ウイルスバスター");
		        titleLabel.setLayout(new FlowLayout(FlowLayout.CENTER,400,400));
		        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // フォントを設定
		        panel.add(titleLabel);

		        // ゲーム開始ボタンを作成
		        JButton startButton = new JButton("GAME START");
		        startButton.setFont(new Font("Arial", Font.PLAIN, 18));
		        startButton.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                // ゲーム開始時の処理
		                JOptionPane.showMessageDialog(frame, "ゲームが始まりました！", "ゲーム開始", JOptionPane.INFORMATION_MESSAGE);
		                // ゲームのメインウィンドウを表示する処理をここに追加できます。
		            }
		        });
		        
		        //ヘルプのボタンを作成
		        JButton a = new JButton("ヘルプ");
		        a.setLayout(new FlowLayout(FlowLayout.CENTER,400,300));

		        // パネルの下にボタンを配置
		        panel.add(startButton);
		        panel.add(a);

		        // フレームにパネルを追加
		        frame.add(panel);
		       
		    }

			public static JFrame JFrame(JFrame frame) {
				// TODO 自動生成されたメソッド・スタブ
				 frame.setVisible(true); // ウィンドウを表示
				return null;
			}
		}
		
			

		    		
			
			
		
	

