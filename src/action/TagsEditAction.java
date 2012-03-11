package action;

import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import dto.ComicTag;
import dto.SqlConfigOfIBatis;

public class TagsEditAction {
	private List<String> tags;
	private int comicId;

	public List<String> getTags() {
		return tags;
	}

	public void setComicId(int comicId) {
		this.comicId = comicId;
	}

	public int getComicId(){
		return comicId;
	}

	// デフォルトのActionメソッド
	public String execute() throws Exception {
		SqlMapClient sqlMap = SqlConfigOfIBatis.getSqlMapInstance();
		ComicTag comicTag = (ComicTag)sqlMap.queryForObject("getComicTag",comicId);
		this.tags = comicTag.convertTag();

		return "success";
	}
}
