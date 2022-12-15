/*
 * Student Name: Tanzim Ahmed Sagar
 * Student Number: 041056432
 * Course & Section #: 22F_CST8288_xxx
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package pkgUnitConverter;

/**
 * class to convert Kg to lbs
 * @author Tanzim Ahmed Sagar
 */
public class KGlbsConverter implements UnitConverter {
    private final double convFactor=2.2;
    /**
     * @param kiloGram value in Kg to be converted
     * @return equivalent in lbs
     */
    @Override
    public double convert(double kiloGram){
        return kiloGram * convFactor;
    }
}
