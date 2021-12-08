package Menu;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import challenge.interfaces.IMenu;
import challenge.task.Sum;

public class SumMenu implements IMenu {

	@Override
	public Integer startTask(Scanner scanner, Map<Integer, Future<?>> results, ExecutorService executor, Integer id) {
		// first number
        System.out.println("Please enter first number");
        float num1 = scanner.nextFloat();

        // second number
        System.out.println("Please enter second number");
        float num2 = scanner.nextFloat();
        Sum sum = new Sum(num1, num2);
        Future<Float> result = executor.submit(sum);
        results.put(id, result);
    	System.out.println("Task id is " + id++);
    	return id;
	}

	@Override
	public String getMainMenuName() {
		return "Execute Sum Task";
	}

}
