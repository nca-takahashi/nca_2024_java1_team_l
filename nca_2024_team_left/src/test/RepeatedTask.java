package test;

import java.util.Timer;
import java.util.TimerTask;

public class RepeatedTask {

    // タイマーの処理をメソッドとして定義
    public static void startTimer() {
        // Timerオブジェクトの作成
        Timer timer = new Timer();

        // TimerTaskクラスで実行したい処理を定義
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("このメッセージは秒ごとに実行されます!");
            }
        };

        // 1秒後に開始して、その後毎秒実行する設定
        timer.scheduleAtFixedRate(task, 2000, 2000);
    }
}
