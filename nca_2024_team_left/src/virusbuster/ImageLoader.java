package virusbuster;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	// 画像ファイルのパスを受け取り、Imageオブジェクトを返すメソッド
	public static Image loadImage(String Ibukin) {
		try {
			// プロジェクトのbinフォルダ内の画像を読み込む
			//return ImageIO.read(new File("bin\\ウイルスバスター仮\\" + Ibukin));
			return ImageIO.read(new File("C:/temp/java/" + Ibukin));
		} catch (IOException e) {
			e.printStackTrace();
			return null; // 画像が読み込めない場合はnullを返す
		}
	}
}
