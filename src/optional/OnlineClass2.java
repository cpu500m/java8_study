package optional;

import java.util.Optional;

public class OnlineClass2 {
	private Integer id;
	private String title;
	private boolean closed;
	private Progress progress;

	public OnlineClass2(Integer id, String title, boolean closed) {
		this.id = id;
		this.title = title;
		this.closed = closed;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public Optional<Progress> getProgress() {
		return Optional.empty();
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}
}
