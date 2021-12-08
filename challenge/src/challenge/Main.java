package challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import Menu.Exit;
import Menu.ProcessMenu;
import Menu.Result;
import Menu.SumMenu;
import challenge.interfaces.IMenu;

public class Main {
	
	//results
    private static Map<Integer, Future<?>> results;
    //tasks
//    private static Map<Integer, ITask<?>> tasks;
    private static Map<Integer, IMenu> menuItems;
    
    private static ExecutorService executor;
    private static Integer id;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//Get ExecutorService from Executors utility class, thread pool size is 10
		executor = Executors.newFixedThreadPool(10);
		id = 1;
		//results
		results = new HashMap<Integer, Future<?>>();
		//create menu items
		menuItems = new HashMap<Integer, IMenu>();
		menuItems.put(1, new SumMenu());
		menuItems.put(2, new ProcessMenu());
		menuItems.put(3, new Result());
		menuItems.put(4, new Exit());
        
        Scanner scanner = new Scanner(System.in);
        showMenu(scanner);
        
        scanner.close();
	}
	
	public static void showMenu(Scanner scanner) throws InterruptedException, ExecutionException {
		while (id > 0) {
			System.out.println("Pick task:");
			for (Entry<Integer, IMenu> item : menuItems.entrySet()) {
				System.out.println(item.getKey() + ". " + item.getValue().getMainMenuName());
			}
	        
	        int taskId = scanner.nextInt();
	        IMenu task = menuItems.get(taskId);
	        id = task.startTask(scanner, results, executor, id);
		}
        
	}
	

}
