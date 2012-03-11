package action;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import dto.ComicTag;
import dto.SqlConfigOfIBatis;

public class RegistrationTagAction {
	private String addTag;
	private int comicId;

	public void setAddTag(String addTag) {
		this.addTag = ControllerUtil.encodingViewData(addTag);
	}

	public void setComicId(int comicId) {
		this.comicId = comicId;
	}

	public int getComicId(){
		return comicId;
	}

	public String execute() throws Exception {
		SqlMapClient sqlMap = SqlConfigOfIBatis.getSqlMapInstance();

		try{
			ComicTag comicTag = (ComicTag)sqlMap.queryForObject("getComicTag",comicId);
			comicTag.addTags(this.addTag);
			sqlMap.update("updateComicTag",comicTag);
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return "success";
	}
}
