package test.fwd.service;

public class FwdVO {

	private int board_id;
	
	private String title;

	private String contents;
	
	private String created_at;

	public int getId() {
		return board_id;
	}

	public void setId(int board_id) {
		this.board_id = board_id;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContents() {
		return contents;
	}
	
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public String getCreated_at() {
		return created_at;
	}
	
	public void setCreate_at(String created_at) {
		this.created_at = created_at;
	}

}
