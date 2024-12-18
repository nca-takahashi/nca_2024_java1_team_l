package ウイルスバスター仮;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ImageLoader {
    // 画像ファイルのパスを受け取り、Imageオブジェクトを返すメソッド
    public static Image loadImage(String Uirusukun) {
        try {
            // プロジェクトのbinフォルダ内の画像を読み込む
            return ImageIO.read(new File("bin\\ウイルスバスター仮\\" + Uirusukun));
        } catch (IOException e) {
            e.printStackTrace();
            return null; // 画像が読み込めない場合はnullを返す
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ウイルスバスター");
        GamePanel gamePanel = new GamePanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // ウィンドウのサイズ
        frame.add(gamePanel);
        frame.setVisible(true);
        gamePanel.startGame();
    }
}