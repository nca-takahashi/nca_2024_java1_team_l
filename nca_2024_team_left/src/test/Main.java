package test;

public class Main {

    public static void main(String[] args) {
    	
    	Ex ex = new Ex();
    	
    	ex.tutorial();
    	ex.frame1();
    	
    	System.out.println("他のmain関数から呼び出しています...");
        
        // ここでRepeatedTaskクラスのstartTimerメソッドを呼び出し
        RepeatedTask.startTimer();
        
		
    }
}

