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
	

	
/*	
    public static void main(String[] args) {
        // ScheduledExecutorService を作成（1スレッドのプール）
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        // 定期的に実行するタスク
        Runnable task = () -> {
            System.out.println("定期的なタスクが実行されました: " + System.currentTimeMillis());
        };

        // 初回実行を0秒後、次回は2秒ごとに実行
        scheduler.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
    }
*/
	
	public void frame1() {
		String[] Data = {"AA","BB","CC","DD","EE","FF","GG","HH","JJ","AA","BB","CC","DD","EE","FF","GG"};
		
		JFrame frame = new JFrame("全体画面");
		frame.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel test1 = new JLabel();
		JLabel test2 = new JLabel();
		JLabel test3 = new JLabel();
		
		test1.setText(Data[0] + " " + Data [1] + " " + Data[2]);
		test2.setText(Data[3] + " " + Data [4] + " " + Data[5]);
		test3.setText(Data[6] + " " + Data [7] + " " + Data[8]);
		
		
		for(int i = 0; i<1; i++) {
			test1.setText(Data[0+i] + " " + Data [1+i] + " " + Data[2+i]);
			test2.setText(Data[3+i] + " " + Data [4+i] + " " + Data[5+i]);
			test3.setText(Data[6+i] + " " + Data [7+i] + " " + Data[8+i]);
		}
		
		panel.add(test1);
		panel.add(test2);
		panel.add(test3);
		
		frame.add(panel,BorderLayout.CENTER);
		
		frame.setSize(300, 200);
		frame.setVisible(true);
	}
	

}
