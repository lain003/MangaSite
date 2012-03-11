package action;

import java.util.ArrayList;
import java.util.List;

import data.ComicData;
import data.ConstantConfig;
import dto.ComicMasterAndComicTag;

public class ComicListAction {
	private List<ComicData> comicDataList = new ArrayList<ComicData>();
	private int page = 0;
	private String searchWord = "";

	public void setSearchWord(String searchWord){
		this.searchWord = ControllerUtil.encodingViewData(searchWord);
	}

	public String getSearchWord(){
		return this.searchWord;
	}

	public List<ComicData> getComicDataList() {
		return comicDataList;
	}

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return this.page;
	}

	// デフォルトのActionメソッド
	public String execute() throws Exception {
		List<ComicMasterAndComicTag> comicMasterAndTagList = ComicMasterAndComicTag.searchDataByWord(searchWord, page * ConstantConfig.DisplayedComicNumber, ConstantConfig.DisplayedComicNumber);
		for(int i = 0;i < comicMasterAndTagList.size();i++){
			ComicMasterAndComicTag comicMasterAdnTag = comicMasterAndTagList.get(i);
			ComicData addComicData = new ComicData(comicMasterAdnTag.getComicId(), comicMasterAdnTag.getTitle(), comicMasterAdnTag.convertTag());
			comicDataList.add(addComicData);
		}

		return "success";
	}
}
