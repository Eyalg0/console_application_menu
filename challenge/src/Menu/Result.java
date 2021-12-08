package Menu;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import challenge.interfaces.IMenu;

public class Result implements IMenu {
	
	@Override
	public Integer startTask(Scanner scanner, Map<Integer, Future<?>> results, ExecutorService executor, Integer id) {
		System.out.println("Please enter number of task to get result");
		int taskId = scanner.nextInt();
		Future<?> future = results.get(taskId);
		if (future.isDone()) {
			try {
				System.out.println("result is " + future.get());
			} catch (InterruptedException | ExecutionException e) {
				System.out.println("can't get result");
			}
		} else {
			System.out.println("processing");
		}
		return id;
	}

	@Override
	public String getMainMenuName() {
		return "Show Task Result";
	}

}
