package 感染を防ごう;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex {
	public void tutorial() {
		JFrame frame = new JFrame("説明");
		frame.setLayout(new BorderLayout());
		
		frame.add(new JLabel("テスト"), BorderLayout.CENTER);
		
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	

	public void frame1() {
		
		String[] Data = {"AA","BB","CC","DD","EE","FF","GG","HH","JJ"};
		
		
		JFrame frame = new JFrame("全体画面");
		frame.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel test1 = new JLabel();
		JLabel test2 = new JLabel();
		JLabel test3 = new JLabel();
		
		
		test1.setText(Data[0] + " " +Data [1] + " " + Data[2]);
		test2.setText(Data[3] + " " +Data [4] + " " + Data[5]);
		test3.setText(Data[6] + " " +Data [7] + " " + Data[8]);
		
		
		panel.add(test1);
		panel.add(test2);
		panel.add(test3);
		
		frame.add(panel,BorderLayout.CENTER);
		
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setVisible(true);
	}
}
