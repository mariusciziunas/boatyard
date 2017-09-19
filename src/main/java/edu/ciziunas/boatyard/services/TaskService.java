package edu.ciziunas.boatyard.services;

import java.util.ArrayList;
import java.util.List;

import edu.ciziunas.boatyard.conditions.MaxDistanceCondition;
import edu.ciziunas.boatyard.tasks.ShortestRouteTask;
import edu.ciziunas.boatyard.conditions.ExactlyStopsCountCondition;
import edu.ciziunas.boatyard.conditions.MaxStopsCondition;
import edu.ciziunas.boatyard.entities.City;
import edu.ciziunas.boatyard.entities.Task;
import edu.ciziunas.boatyard.tasks.DistanceOfRouteTask;
import edu.ciziunas.boatyard.tasks.NumberOfRoutesTask;

/**
 * Service class for building and executing tasks
 * 
 * @author mciziunas
 *
 */
public class TaskService {

	private static List<Task> tasks  = new ArrayList<Task>();
	
	/**
	 * Method for creating, preparing tasks and conditions
	 */
	public static void buildTasks() {
		addTask(new DistanceOfRouteTask("A", "B", "C"));
		addTask(new DistanceOfRouteTask("A", "D"));
		addTask(new DistanceOfRouteTask("A", "D", "C"));
		addTask(new DistanceOfRouteTask("A", "E", "B", "C", "D"));
		addTask(new DistanceOfRouteTask("A", "E", "D"));
		addTask(new NumberOfRoutesTask(new MaxStopsCondition(3, "C", "C")));
		addTask(new NumberOfRoutesTask(new ExactlyStopsCountCondition(4, "A", "C")));
		addTask(new ShortestRouteTask("A", "C"));
		addTask(new ShortestRouteTask("B", "B"));
		addTask(new NumberOfRoutesTask(new MaxDistanceCondition(30, "C", "C")));
	};
	
	/**
	 * Compute tasks and set the results. Compute method in every task is invoked.
	 * @param city is data object for input 
	 */
	public static void computeTasks(City city) {
		if (!tasks.isEmpty()) {
			for (Task task : tasks) {
				task.compute(city);
			}
		}
	}

	/**
	 * Iterates through the tasks and prints the result
	 */
	public static void printResults() {
		if (!tasks.isEmpty()) {
			int i = 0;
			for (Task task : tasks) {
				System.out.println(++i + ": " + task.getResult());
			}
		}
	}
	
	private static void addTask(Task task) {
		tasks.add(task);
	}
}
