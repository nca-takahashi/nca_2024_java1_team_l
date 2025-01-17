package test;

import java.awt.BorderLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RepeatedTask {

    // タイマーの処理をメソッドとして定義
    public static void startTimer() {
        // Timerオブジェクトの作成
        Timer timer = new Timer();

        // TimerTaskクラスで実行したい処理を定義
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("実行されました");
                
                String[] Data = {"AA","BB","CC","DD","EE","FF","GG","HH","II","AA","BB","CC","DD","EE","FF","GG","HH","II"};
         	   
         	   //BorderLayoutの中にBoxLayout
         	   JFrame frame = new JFrame("表示画面");
         	   frame.setLayout(new BorderLayout());
         	   JPanel panel = new JPanel();
         	   panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
         	   JLabel test1 = new JLabel();
         	   JLabel test2 = new JLabel();
         	   JLabel test3 = new JLabel();
         	   
         	   //繰り返し
         	   int i = 0;
               while (true) {
            	   
            	   i = i+1;
            	   test1.setText(Data[0+i] + " " + Data [1+i] + " " + Data[2+i]);
            	   test2.setText(Data[3+i] + " " + Data [4+i] + " " + Data[5+i]);
            	   test3.setText(Data[6+i] + " " + Data [7+i] + " " + Data[8+i]);
           			
               }
            }
        };

        // 2秒後に開始して、その後2秒毎に実行する設定
        timer.scheduleAtFixedRate(task, 2000, 2000);
    }
}

