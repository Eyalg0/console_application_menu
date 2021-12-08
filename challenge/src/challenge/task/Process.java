package challenge.task;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Process implements Callable<String> {
	private int secondes;
	
	public Process(int secondes) {
		super();
		this.secondes = secondes;
	}

	@Override
	public String call() throws Exception {
		TimeUnit.SECONDS.sleep(secondes);
		return "done";
	}

}
