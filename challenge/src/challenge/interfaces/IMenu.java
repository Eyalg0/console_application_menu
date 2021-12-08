package challenge.interfaces;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public interface IMenu {
	public Integer startTask(Scanner scanner, Map<Integer, Future<?>> results, ExecutorService executor, Integer id);
	public String getMainMenuName();
}
