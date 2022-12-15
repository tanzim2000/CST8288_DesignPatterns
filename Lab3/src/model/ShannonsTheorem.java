package model;

/**
 * class that implements "model" for an MVC application that calculates Shannon's Theorem
 * @author kriger
 */
public class ShannonsTheorem {
	private double bandWidth;
	private double signalToNoiseRatio;
	/**
         * multi-argument constructor
	 * @param bandWidth the bandwidth in Hertz
	 * @param signalToNoiseRatio SNR in dB
	 */
	public ShannonsTheorem(double bandWidth, double signalToNoiseRatio) {
		this.bandWidth = bandWidth;
		this.signalToNoiseRatio = signalToNoiseRatio;
	}
	/**
	 * no-arg constructor sets fields to zero
	 */
	public ShannonsTheorem() {
		this(0.0, 0.0);
	}
	/**
	 * @return the bandWidth
	 */
	public double getBandWidth() {
		return bandWidth;
	}
	/**
	 * @param bandWidth the bandWidth to set
	 */
	public void setBandWidth(double bandWidth) {
		this.bandWidth = bandWidth;
	}
	/**
	 * @return the signalToNoiseRatio
	 */
	public double getSignalToNoiseRatio() {
		return signalToNoiseRatio;
	}
	/**
	 * @param signalToNoiseRatio the signalToNoiseRatio to set
	 */
	public void setSignalToNoiseRatio(double signalToNoiseRatio) {
		this.signalToNoiseRatio = signalToNoiseRatio;
	}
	
	private double log2(double x) {
		return Math.log(x)/Math.log(2);
	}
	
    /**
     *
     * @param BW the bandwidth
     * @param SNR the signal-to-noise-ratio
     * @return maximum data ratio
     */
    public double maxDataRate(double BW, double SNR) {
		double SN = Math.pow(10, SNR/10);
		return BW*log2(1+SN);
	}
	
    /**
     *
     * @return maximum data Rate
     */
    public double maxDataRate() {
		return maxDataRate(bandWidth, signalToNoiseRatio);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

    /**
     *
     * @return string for output
     */

	@Override
	public String toString() {
		return "ShannonsTheory [bandWidth=" + bandWidth + ", signalToNoiseRatio=" + signalToNoiseRatio + "]";
	}
	
	
	
}
