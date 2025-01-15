package test;

public class Main {

    public static void main(String[] args) {
        System.out.println("他のmain関数からタイマー機能を呼び出しています...");
        
        // ここでRepeatedTaskクラスのstartTimerメソッドを呼び出し
        RepeatedTask.startTimer();
    }
}
