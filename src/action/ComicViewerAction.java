package action;


public class ComicViewerAction {
	private int comicId;

	public int getComicId() {
		return comicId;
	}

	public void setComicId(int comicId) {
		this.comicId = comicId;
	}

	public String execute() throws Exception {
		return "success";
	}
}
