package dto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComicTag {
	private int comicId;
	private String tags;


	public int getComicId() {
		return comicId;
	}
	public void setComicId(int comicId) {
		this.comicId = comicId;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}

	public void setTags(List<String> tags){
		this.tags = "";
		for(int i = 0;i < tags.size();i++){
			this.addTags(tags.get(i));
		}
	}

	/**
	 * タグを追加する
	 * @param addTag 追加したいタグを指定する。もし空の場合は追加されない
	 */
	public void addTags(String addTag){
		if(addTag.length() != 0){
			this.tags += addTag + ":";
		}
		else{
		}
	}

	/**
	 * メンバ変数のtagsを":"で区切って、listクラスに格納して返す
	 * @return 変換したListを返す
	 */
	public List<String> convertTag(){
		List<String> returnTagList = new ArrayList<String>();

		String[] tag = this.mySplit(tags, ":");
		for(int i = 0;i < tag.length;i++){
			returnTagList.add(tag[i]);
		}

		return returnTagList;
	}

	private String[] mySplit(String target,String search){
		if(target.length() == 0){
			return new String[0];
		}
		else{
			return target.split(search);
		}
	}

	/**
	 * 指定されたキーワードを元にＤＢを検索して、結果を返します
	 * @param searchWord 検索したいワード
	 * @return 検索結果。エラーの場合null
	 */
	@SuppressWarnings("unchecked")
	public static List<ComicTag> searchDataByWord(String searchWord){
		try {
			return SqlConfigOfIBatis.getSqlMapInstance().queryForList("searchComicTag");
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
	}
}
