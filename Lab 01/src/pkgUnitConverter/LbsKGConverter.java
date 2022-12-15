/*
 * Student Name: Tanzim Ahmed Sagar
 * Student Number: 041056432
 * Course & Section #: 22F_CST8288_xxx
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package pkgUnitConverter;

/**
 * class to convert lbs to Kg
 * @author Tanzim Ahmed Sagar
 */
public class LbsKGConverter implements UnitConverter {
    private final double convFactor=2.2;
    /**
     * @param lbs value in lbs to be converted
     * @return equivalent in Kg
     */
    @Override
    public double convert(double lbs){
        return lbs / convFactor;
    }
}
