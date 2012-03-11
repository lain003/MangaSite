package action;

import java.util.ArrayList;
import java.util.List;

import data.ComicData;
import dto.memCached.MangaMemCached;

public class NewArrivalsAction{
	private List<ComicData> comicDataList = new ArrayList<ComicData>();

	public List<ComicData> getComicDataList() {
		return comicDataList;
	}


	// デフォルトのActionメソッド
	public String execute() throws Exception {
		comicDataList = MangaMemCached.getNewArrivalComicId();

		return "success";
	}
}
