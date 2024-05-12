package optional;

import java.time.Duration;

public class Progress {
	private Duration studyDuration;
	private boolean finished;

	public void setStudyDuration(Duration studyDuration) {
		this.studyDuration = studyDuration;
	}

	public Duration getStudyDuration() {
		return studyDuration;
	}
}
