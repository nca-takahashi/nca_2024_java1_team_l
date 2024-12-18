package ウイルスバスター仮;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
    // 画像ファイルのパスを受け取り、Imageオブジェクトを返すメソッド
    public static Image loadImage(String filePath) {
        try {
            // バックスラッシュをエスケープして、またはスラッシュを使用する
            return ImageIO.read(new File("C:\\Users\\cre\\git\nca_2024_java1_team_l\nca_2024_team_left\\bin\\ウイルスバスター仮\\Uirusukun.png")); // 画像を読み込み、返す
        } catch (IOException e) {
            e.printStackTrace();
            return null; // 画像が読み込めない場合はnullを返す
        }
    }
}
