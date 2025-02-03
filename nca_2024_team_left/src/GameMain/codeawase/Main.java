package GameMain.codeawase;

public class Main {
	
	private static boolean codeclear = false;

    public static void main(String[] args) {
    	
    	game game = new game();
    	
 //   	game.tutorial();
    	game.stage1(new game.GameClearListener() {
            @Override
            public void onGameClear() {
                // ゲームクリア時にフラグを更新
                codeclear = true;
            }

            @Override
            public void onGameOver() {
                // ゲームオーバー時の処理（必要に応じて）
                System.out.println("ゲームオーバー!");
            }
        });
    }
}

