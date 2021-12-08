package Menu;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import challenge.interfaces.IMenu;
import challenge.task.Process;

public class ProcessMenu implements IMenu {

	@Override
	public Integer startTask(Scanner scanner, Map<Integer, Future<?>> results, ExecutorService executor, Integer id) {
  
        // get secondes
        System.out.println("Please enter number of seconds to sleep");
        int secondes = scanner.nextInt();
        Process process = new Process(secondes);
        Future<String> result = executor.submit(process);
        results.put(id, result);
    	System.out.println("Task id is " + id++);
    	return id;
	}

	@Override
	public String getMainMenuName() {
		return "Execute Process Task";
	}


}
