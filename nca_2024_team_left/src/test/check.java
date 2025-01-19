package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class check {
	
	public static boolean checkClick = false;
	
    public static void main(String[] args) {
        // フレームを作成
        JFrame frame = new JFrame("Absolute Layout Example");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        JButton button = new JButton();
        button.setBounds(330,100,150,50);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        frame.add(button);
        
        System.out.println("checkClickは" + checkClick);
        
        button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	// クリックイベントが発生した時に実行される処理
        	checkClick = true;
        	System.out.println("checkClickは" + checkClick);
        	}
        });
        
        JLabel up = new JLabel("この上");
        up.setBounds(330,130,150,50);
        frame.add(up);
        
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
