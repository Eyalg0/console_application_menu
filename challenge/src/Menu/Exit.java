package Menu;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import challenge.interfaces.IMenu;

public class Exit implements IMenu {
	
	@Override
	public Integer startTask(Scanner scanner, Map<Integer, Future<?>> results, ExecutorService executor, Integer id) {
		System.out.println("bye");
		scanner.close();
		return -1;
	}

	@Override
	public String getMainMenuName() {
		return "Exit";
	}

}
