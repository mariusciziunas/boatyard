package edu.ciziunas.boatyard.tasks;

import java.util.ArrayList;
import java.util.List;

import edu.ciziunas.boatyard.conditions.Condition;
import edu.ciziunas.boatyard.entities.City;
import edu.ciziunas.boatyard.entities.Path;
import edu.ciziunas.boatyard.entities.Route;
import edu.ciziunas.boatyard.entities.Suburb;
import edu.ciziunas.boatyard.entities.Task;

/**
 * This task computes the number of routes from source to target, regarding to
 * the given condition
 * 
 * @author mciziunas
 *
 */
public class NumberOfRoutesTask extends Task {

	private Suburb sourceSuburb;
	private List<Path> resultPath = new ArrayList<>();

	public NumberOfRoutesTask(Condition condition) {
		setCondition(condition);
		sourceSuburb = new Suburb(condition.getSource());
	}

	@Override
	public void compute(City city) {
		count(city.getSuburb(sourceSuburb), new Path(sourceSuburb));
		if (!resultPath.isEmpty()) {
			setResult(String.valueOf(resultPath.size()));
		} else {
			setResult(String.valueOf(resultPath.size()));
		}
	}

	public void count(Suburb currentSuburb, Path path) {
		for (Route route : currentSuburb.getRoutes()) {
			Path currentPath = new Path(path);
			Suburb targetSuburb = route.getTarget();
			currentPath.addDistance(route.getDistance());
			currentPath.addSuburb(targetSuburb);
			if (getCondition().isConditionValid(currentPath)) {
				if (getCondition().isElementValid(currentPath)) {
					resultPath.add(currentPath);
				}
				count(targetSuburb, currentPath);
			}
		}
	}

}
