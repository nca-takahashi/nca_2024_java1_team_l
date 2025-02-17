package virusbuster;

import java.awt.Graphics; // グラフィックスを扱うためのクラスをインポート
import java.awt.Image; // 画像を扱うためのクラスをインポート

/**
 * ウイルスオブジェクトを表すクラス。
 * ウイルスの位置、画像、移動、描画に関する機能を提供します。
 */
public class VirusObject {

	// ウイルスのX座標とY座標を保持するフィールド
	private int x, y; 
	// ウイルスの画像を保持するフィールド
	private Image virusImage; 

	// ウイルスの幅を定義する定数
	public static final int WIDTH = 50; 
	// ウイルスの高さを定義する定数
	public static final int HEIGHT = 50; 

	/**
	 * コンストラクタ。
	 * 指定された位置にウイルスを配置し、画像を読み込みます。
	 * 
	 * @param x ウイルスのX座標
	 * @param y ウイルスのY座標
	 */
	public VirusObject(int x, int y) {
		// ウイルスのX座標を設定
		this.x = x;
		// ウイルスのY座標を設定
		this.y = y;
		// ImageLoaderを使用してウイルスの画像を読み込む
		this.virusImage = ImageLoader.loadImage("Ibukin.png");
	}

	/**
	 * ウイルスを左に移動させるメソッド。
	 * X座標を減少させることで移動を実現します。
	 */
	public void move() {
		// ウイルスを左に移動させるためにX座標を2減少
		x -= 2; 
	}

	/**
	 * ウイルスを描画するメソッド。
	 * 指定されたグラフィックスコンテキストにウイルスの画像を描画します。
	 * 
	 * @param g 描画に使用するGraphicsオブジェクト
	 */
	public void draw(Graphics g) {
		// ウイルスの画像を指定された位置とサイズで描画
		g.drawImage(virusImage, x, y, WIDTH, HEIGHT, null); 
	}

	/**
	 * ウイルスのX座標を取得するメソッド。
	 * 
	 * @return 現在のX座標
	 */
	public int getX() {
		// 現在のX座標を返す
		return x;
	}

	/**
	 * ウイルスのY座標を取得するメソッド。
	 * 
	 * @return 現在のY座標
	 */
	public int getY() {
		// 現在のY座標を返す
		return y;
	}
}
