/*
 * Student Name: Tanzim Ahmed Sagar
 * Student Number: 041056432
 * Course & Section #: 22F_CST8288_xxx
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package pkgUnitConverter;
/**
 * class to convert Celsius to Fahrenheit
 * @author kriger
 */
public class CFconverter implements UnitConverter{
	private final double convFactor=1.8;
	private final double convOrigin=32.0;
	/**
	 * @param celsius value in Celsius to be converted
	 * @return equivalent in Fahrenheit
	 */
        @Override
	public double convert(double celsius) {
		return celsius*convFactor + convOrigin;
	}
}
