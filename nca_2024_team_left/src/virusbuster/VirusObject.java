package virusbuster;

import java.awt.Graphics;
import java.awt.Image;

public class VirusObject {

	private int x, y; // ウイルスの位置
	private Image virusImage; // 画像を保存するフィールド

	public static final int WIDTH = 50; // ウイルスの幅
	public static final int HEIGHT = 50; // ウイルスの高さ

	// コンストラクタ: 位置と画像を設定
	public VirusObject(int x, int y) {

		this.x = x;
		this.y = y;

		// ImageLoaderを使用して画像を読み込む
		this.virusImage = ImageLoader.loadImage("Ibukin.png");
	}

	// ウイルスを左に移動させるメソッド
	public void move() {
		x -= 2; // ウイルスを左に移動
	}

	// ウイルスを描画するメソッド
	public void draw(Graphics g) {
		g.drawImage(virusImage, x, y, WIDTH, HEIGHT, null); // 画像を描画
	}

	// X座標を取得するメソッド
	public int getX() {
		return x;
	}

	// Y座標を取得するメソッド
	public int getY() {
		return y;
	}
}
