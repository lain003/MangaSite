package dto;

import java.sql.SQLException;
import java.util.List;

public class ComicMaster {
	private int comicId;
	private String title;

	public int getComicId() {
		return comicId;
	}
	public void setComicId(int comicId) {
		this.comicId = comicId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 指定されたキーワードを元にＤＢを検索して、結果を返します
	 * @param searchWord 検索したいワード
	 * @return 検索結果。エラーの場合null
	 */
	@SuppressWarnings("unchecked")
	public static List<ComicMaster> searchDataByWord(String searchWord){
		try {
			return SqlConfigOfIBatis.getSqlMapInstance().queryForList("searchComicMaster");
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
	}
}
