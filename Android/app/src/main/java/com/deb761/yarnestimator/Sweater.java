package com.deb761.yarnestimator;

/**
 * Created by deb on 4/25/16.
 */
public class Sweater extends Project {

    // Finished size around the chest
    private double chestSize = 40.0;
    // Units for chest size
    private ShortLengthUnits chestUnits = ShortLengthUnits.Inches;

    public double getChestSize() {
        return chestSize;
    }

    public void setChestSize(double chestSize) {
        this.chestSize = chestSize;
    }

    public ShortLengthUnits getChestUnits() {
        return chestUnits;
    }

    public void setChestUnits(ShortLengthUnits chestUnits) {
        this.chestUnits = chestUnits;
    }

    public Sweater(String name, int thumbImageID, Class<?> aClass) {
        super(name, thumbImageID, aClass);
    }
    protected class SizeData {
        // Finished size around the chest
        public double chest;
        // Meters needed with 32 sts per 10cm
        public double sts32;
        // Meters needed with 18 sts per 10cm
        public double sts18;
        public SizeData(double chest, double sts32, double sts18)
        {
            this.chest = chest;
            this.sts32 = sts32;
            this.sts18 = sts18;
        }
    }

    protected SizeData smallMiss = new SizeData(81, 1500, 950);
    protected SizeData largeMiss = new SizeData(101, 1700, 1200);

    @Override
    public void calcYarnRequired()
    {
        double gauge = getGauge();
        double chest = chestSize;
        // First, put values into SI units
        if (getGaugeUnits() == GaugeUnits.StsPerInch) {
            gauge *= 4;
        }
        if (chestUnits == ShortLengthUnits.Inches) {
            chest *= inches2cm;
        }
        int ballSize = getBallSize();
        if (getBallSizeUnits() == LongLengthUnits.Yards) {
            ballSize *= yards2meters;
        }
        // See where the selected gauge falls between our two gauges
        double gratio = (gauge - 18) / (gauge - 32);
        // See how many meters are needed for this gauge for our two sizes
        double smallMeters = gratio * (smallMiss.sts32 - smallMiss.sts18) + smallMiss.sts18;
        double bigMeters = gratio * (largeMiss.sts32 - largeMiss.sts18) + largeMiss.sts18;

        // Now, see where the selected size is with respect to the smallMiss and largeMiss sizes
        double sRatio = (chest - smallMiss.chest) / (largeMiss.chest - smallMiss.chest);
        // Finally, use the size ratio to get the meters of yarn needed
        double meters = sRatio * (bigMeters - smallMeters) + smallMeters;

        // Now convert the yarn required into the desired units
        if (getBallSizeUnits() != LongLengthUnits.Meters) {
            yarnNeeded = (int)Math.ceil(meters / yards2meters);
        }
        else {
            yarnNeeded = (int)Math.ceil(meters);
        }

        ballsNeeded = (int)Math.ceil(meters / ballSize);

    }
}
