/*
 * Student Name: Tanzim Ahmed Sagar
 * Student Number: 041056432
 * Course & Section #: 22F_CST8288_xxx
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package pkgUnitConverter;

/**
 * Context Class for Converter
 * @author Tanzim Ahmed Sagar
 */
public class ConverterContext {
    private UnitConverter convertionMethod;
    /**
     * @param convertionMethod  The method of conversion
     */
    public void setMethod(UnitConverter convertionMethod) {
        this.convertionMethod = convertionMethod;
    }
    /**
     * @param valueToConvert The number that need to be converted
     * @return result of conversion
     */
    public double convertResult (double valueToConvert) {
        return convertionMethod.convert(valueToConvert);
    }
}
