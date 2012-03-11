package action;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import dto.ComicTag;
import dto.SqlConfigOfIBatis;

public class DeleteTagAction {
	private int deleteTagNumber;
	private int comicId;

	public void setDeleteTagNumber(int deleteTagNumber){
		this.deleteTagNumber = deleteTagNumber;
	}

	public void setComicId(int comicId){
		this.comicId = comicId;
	}

	public int getComicId(){
		return this.comicId;
	}

	// デフォルトのActionメソッド
	public String execute() throws Exception {
		SqlMapClient sqlMap = SqlConfigOfIBatis.getSqlMapInstance();

		try{
			ComicTag comicTag = (ComicTag)sqlMap.queryForObject("getComicTag",comicId);

			List<String> tagList = comicTag.convertTag();
			tagList.remove(this.deleteTagNumber);
			comicTag.setTags(tagList);

			sqlMap.update("updateComicTag",comicTag);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return "success";
	}
}
