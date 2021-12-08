package challenge.task;

import java.util.concurrent.Callable;

public class Sum implements Callable<Float> {
	private float num1, num2;
	
	public Sum(float num1, float num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}



	@Override
	public Float call() throws Exception {
		return num1 + num2;
	}

}
