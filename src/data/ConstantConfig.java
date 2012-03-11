package data;

/**
 * アプリの規定値を設定するためのクラス（例：漫画を一度に何枚表示するか等)
 * @author akitani
 *
 */
public final class ConstantConfig {
	private ConstantConfig(){
	}

	/**
	 * new-arrivaers.jspに一度に表示する漫画の数
	 */
	public final static Integer DisplayedComicNumber = 2;

	/**
	 * memCacshedに新着コミックのデータを保存する期間（ミリ秒単位で指定)
	 */
	public final static Long MemCachedLimitDateNewArrival = new Long(1000 * 60 * 60);
}
