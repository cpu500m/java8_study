package stream;

public class OnlineClass {
	private Integer id;
	private String Title;
	private boolean closed;

	public OnlineClass(Integer id, String Title, boolean closed) {
		this.id = id;
		this.Title = Title;
		this.closed = closed;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setName(String Title) {
		this.Title = Title;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}
}
