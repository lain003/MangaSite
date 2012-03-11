package action;

import java.io.UnsupportedEncodingException;

/**
 * MVCで言うところのCにおいて、何度か利用される処理をまとめるためのメソッド
 * @author akitani
 *
 */
public class ControllerUtil {

	/**
	 * Viewから送られてき日本語の文字列を、Modelで使えるようにUTF-8でエンコードします。
	 * @param viewString エンコードしたい文字列を渡します。
	 * @return エンコードした文字列を返します。
	 */
	public static String encodingViewData(String viewString){
		byte[] byteData;
		try {
			byteData = viewString.getBytes("ISO_8859_1");
			return new String(byteData, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
	}

}
