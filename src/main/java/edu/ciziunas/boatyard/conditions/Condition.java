package edu.ciziunas.boatyard.conditions;

import edu.ciziunas.boatyard.entities.Path;

/**
 * This interface imposes validation of each class implements it
 * 
 * @author mciziunas
 *
 */
public interface Condition {
	
	public boolean isElementValid(Path path);
	
	public boolean isConditionValid(Path path);
	
	public String getSource();
	
	public String getDestination();

}
