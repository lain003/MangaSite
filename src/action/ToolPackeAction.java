package action;

public class ToolPackeAction {
	private int comicId;

	public void setComicId(int comicId) {
		this.comicId = comicId;
	}

	public int getComicId(){
		return comicId;
	}

	// デフォルトのActionメソッド
	public String execute() throws Exception {
		return "success";
	}
}
