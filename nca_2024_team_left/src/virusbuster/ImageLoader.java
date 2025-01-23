package virusbuster;

import java.awt.Image; // 画像を扱うためのクラスをインポート
import java.io.File; // ファイルを扱うためのクラスをインポート
import java.io.IOException; // 入出力例外を扱うためのクラスをインポート

import javax.imageio.ImageIO; // 画像の読み書きを行うためのクラスをインポート

/**
 * 画像を読み込むためのユーティリティクラス。
 * 指定されたパスから画像を読み込み、Imageオブジェクトとして返します。
 */
public class ImageLoader {

    /**
     * 画像ファイルのパスを受け取り、Imageオブジェクトを返すメソッド。
     * 
     * @param Ibukin 読み込む画像ファイルの名前
     * @return 読み込まれたImageオブジェクト、または読み込みに失敗した場合はnull
     */
    public static Image loadImage(String Ibukin) {
        try {
            // 指定されたパスの画像ファイルを読み込む
			//return ImageIO.read(new File("bin\\ウイルスバスター仮\\" + Ibukin));
            return ImageIO.read(new File("C:/temp/java/" + Ibukin));
        } catch (IOException e) {
            // 画像の読み込み中に例外が発生した場合、スタックトレースを出力
            e.printStackTrace();
            // 画像が読み込めない場合はnullを返す
            return null;
        }
    }
}
