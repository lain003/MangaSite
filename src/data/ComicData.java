package data;

import java.io.Serializable;
import java.util.List;

public class ComicData implements Serializable{
	private static final long serialVersionUID = 5088333113679217318L;

	protected Integer comicId ;
	protected String title="NoName";
	protected List<String> tags;

	public Integer getComicId() {
		return comicId;
	}
	public String getTitle() {
		return title;
	}
	public List<String> getTags() {
		return tags;
	}

	/**
	 * 渡された引数を元に、メンバ変数をセットする
	 * @param comicId
	 * @param title
	 * @param tags
	 */
	public ComicData(Integer comicId,String title,List<String> tags){
		this.comicId = comicId;
		this.title = title;
		this.tags = tags;
	}
}
