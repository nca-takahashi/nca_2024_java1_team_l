package 感染を防ごう;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Ex ex = new Ex();
		
		ex.tutorial();
		
		ex.frame1();

	}
}

/*public class RepeatedTaskExample {
    public static void main(String[] args) {
        // ScheduledExecutorServiceのインスタンスを作成
        var scheduler = Executors.newScheduledThreadPool(1);

        // 定期的に実行するタスクを定義
        Runnable task = () -> {
            System.out.println("タスク実行: " + System.currentTimeMillis());
        };

        // 1秒ごとにタスクを繰り返し実行
        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);

        // 任意で終了条件を設定（例えば、5秒後に停止）
        scheduler.schedule(() -> {
            System.out.println("タスクを停止します。");
            scheduler.shutdown();
        }, 5, TimeUnit.SECONDS);
    }
}
*/
