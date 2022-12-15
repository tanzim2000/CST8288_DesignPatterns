/*
 * Student Name: Tanzim Ahmed Sagar
 * Student Number: 041056432
 * Course & Section #: 22F_CST8288_xxx
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package pkgUnitConverter;
/**
 * class to convert Fahrenheit to Celsius
 * @author kriger
 */
public class FCconverter implements UnitConverter{
	private final double convFactor=1.8;
	private final double convOrigin=32.0;
	
	/**
	 * @param fahrenheit value in Fahrenheit to be converted
	 * @return equivalent in Celsius
	 */
        @Override
	public double convert(double fahrenheit) {
		return (fahrenheit - convOrigin)/convFactor;
	}
}
