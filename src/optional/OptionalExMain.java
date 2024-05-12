package optional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OptionalExMain {
	public static void main(String[] args) {
		List<OnlineClass2> classes = new ArrayList<>();
		classes.add(new OnlineClass2(1, "spring boot", true));
		classes.add(new OnlineClass2(2, "spring data jpa", true));
		classes.add(new OnlineClass2(3, "spring mvc", false));
		classes.add(new OnlineClass2(4, "spring core", false));
		classes.add(new OnlineClass2(5, "rest api development", false));

		OnlineClass2 springBoot = new OnlineClass2(1, "spring boot", false);
		Duration studyDuration = springBoot.getProgress().orElseThrow().getStudyDuration();
		System.out.println("studyDuration = " + studyDuration);
	}
}
