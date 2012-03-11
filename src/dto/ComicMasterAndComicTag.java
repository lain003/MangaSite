package dto;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class ComicMasterAndComicTag {
	private ComicTag comicTag = new ComicTag();
	private ComicMaster comicMaster = new ComicMaster();

	public Integer getComicId() {
		return comicMaster.getComicId();
	}
	public void setComicId(Integer comicId) {
		this.comicMaster.setComicId(comicId);
		this.comicTag.setComicId(comicId);
	}
	public String getTitle() {
		return comicMaster.getTitle();
	}
	public void setTitle(String title) {
		this.comicMaster.setTitle(title);
	}
	public String getTags() {
		return this.comicTag.getTags();
	}
	public void setTags(String tags) {
		this.comicTag.setTags(tags);
	}

	public List<String> convertTag(){
		return comicTag.convertTag();
	}


	/**
	 * DBから指定されたワードをtitleかtagに含むデータを検索し、返します。
	 * @param searchWord 検索したいキーワードを指定します。
	 * @param startIndex 検索結果の中から、何番目からのデータを表示するかを指定します。(例；5件のデーががあって、startIndexに3が指定されていた場合は3件目のデータから返します。)
	 * @param showDataNum 一度に返すデータの数を指定します。
	 * @return 検索にヒットしたデータを返します。エラーがあった場合はnullを返します。
	 */
	@SuppressWarnings("unchecked")
	public static List<ComicMasterAndComicTag> searchDataByWord(String searchWord,int startIndex,int showDataNum){
		try {
			HashMap<String,Object> params = new HashMap<String,Object>();
			params.put("searchWord", "%" + searchWord + "%");
			params.put("startIndex", startIndex);
			params.put("showDataNum", showDataNum);
			return SqlConfigOfIBatis.getSqlMapInstance().queryForList("searchComicMasterAndComicTag", params);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
