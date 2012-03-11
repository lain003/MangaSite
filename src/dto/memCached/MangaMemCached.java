package dto.memCached;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import data.ComicData;
import data.ConstantConfig;
import dto.ComicMasterAndComicTag;

/**
 * MemCachedClientRapperを元に、MangaSiteとより依存性の高いメソッドを提供するクラス。
 * @author akitani
 *
 */
public class MangaMemCached {
	/**
	 * 新着コミックのデータをキャッシュに保存するときに使うKey<br>
	 * 複数保存する場合はこれに数字を付与して保存する(例:hoge0,hoge1,・・・)。
	 */
	protected static final String NewArrivalComicDataKey = "NewArrivalComicData";

	private MangaMemCached(){
	}

	/**
	 * キャッシュから新着コミックのリストを取得する。<br>
	 * キャッシュになかった場合は新たに登録して、値を返す
	 * @return 新着コミックのデータをリストにして返す。
	 */
	public static List<ComicData> getNewArrivalComicId(){
		List<ComicData> comicDataList = new ArrayList<ComicData>();

		for(int i = 0;i < ConstantConfig.DisplayedComicNumber;i++){
			ComicData comicData = (ComicData) MemCachedClientRapper.get(NewArrivalComicDataKey + i);
			if(comicData == null){//もしキャッシュからデータが取得できなかったら
				return setNewArrivalComicId();
			}
			comicDataList.add(comicData);
		}
		return comicDataList;
	}

	/**
	 * キャッシュに新着コミックのデータを登録する
	 * @return 登録したデータのリストを返す。エラーが発生した場合はnullを返す
	 */
	protected static List<ComicData> setNewArrivalComicId(){
		List<ComicMasterAndComicTag> comicMasterAndTagList = ComicMasterAndComicTag.searchDataByWord("", 0, ConstantConfig.DisplayedComicNumber);

		List<ComicData> comicDataList = new ArrayList<ComicData>();

		for(int i = 0;i < comicMasterAndTagList.size();i++){
			ComicMasterAndComicTag dto = comicMasterAndTagList.get(i);
			ComicData comicData = new ComicData(dto.getComicId(),dto.getTitle(),dto.convertTag());
			comicDataList.add(comicData);


			long time = ConstantConfig.MemCachedLimitDateNewArrival;
			Date date = new Date(time);
			String key = NewArrivalComicDataKey + i;
			MemCachedClientRapper.set(key, comicData,date);
		}
		return comicDataList;
	}
}
