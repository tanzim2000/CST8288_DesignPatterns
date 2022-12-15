/*
 * Student Name: Tanzim Ahmed Sagar
 * Student Number: 041056432
 * Course & Section #: 22F_CST8288_xxx
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package pkgUnitConverterTest;

import pkgUnitConverter.*;
/**
 * simple class to test 2 classes for converting Fahrenheit to Celsius and the reverse
 * @author kriger
 */
public class UnitConverterTest {

    /**
     * @param args command line arguments
     */
    public static void main(String[] args) {
		ConverterContext Converter = new ConverterContext();
                
                Converter.setMethod(new FCconverter());
		System.out.printf("%5.2f in Fahrenheit is %5.2f Celsius\n", 70.0, Converter.convertResult(70.0));
		
		Converter.setMethod(new CFconverter());
		System.out.printf("%5.2f in Celsius is %5.2f Fahrenheit\n", 20.0, Converter.convertResult(20.0));
		
                Converter.setMethod(new KGlbsConverter());
                System.out.printf("%5.2f in Kg is %5.2f lbs\n", 150.0, Converter.convertResult(150));
                
                Converter.setMethod(new LbsKGConverter());
                System.out.printf("%5.2f in lbs is %5.2f Kg\n", 260.0, Converter.convertResult(260));
	}

}
