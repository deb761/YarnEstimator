package com.deb761.yarnestimator;

/**
 * Created by deb on 4/25/16.
 */

public enum GaugeUnits { StsPerInch, StsPer4inch, StsPer10cm }
public enum ShortLengthUnits { Inches, CM }
public enum LongLengthUnits { Yards, Meters }

public abstract class Project {
    private String name;
    private double gauge;
    private GaugeUnits gaugeUnits;
    private int thumbImageID;
    private int imageID;
    protected int yarnRequired;
    private int ballSize;
    private LongLengthUnits ballSizeUnits;
    protected int ballsNeeded;


    public String getName() {
        return name;
    }

    public double getGauge() {
        return gauge;
    }

    public void setGauge(double gauge) {
        this.gauge = gauge;
    }

    public GaugeUnits getGaugeUnits() {
        return gaugeUnits;
    }

    public void setGaugeUnits(GaugeUnits gaugeUnits) {
        this.gaugeUnits = gaugeUnits;
    }

    public int getThumbImageID() {
        return thumbImageID;
    }

    public int getImageID() {
        return imageID;
    }

    public int getYarnRequired() {
        return yarnRequired;
    }

    public int getBallSize() {
        return ballSize;
    }

    public void setBallSize(int ballSize) {
        this.ballSize = ballSize;
    }

    public LongLengthUnits getBallSizeUnits() {
        return ballSizeUnits;
    }

    public void setBallSizeUnits(LongLengthUnits ballSizeUnits) {
        this.ballSizeUnits = ballSizeUnits;
    }

    public int getBallsNeeded() {
        return ballsNeeded;
    }

    protected double inches2cm = 2.54;
    protected double yards2meters = 0.9144;

    public Project(String name, int thumbImageID, int imageID)
    {
        this.name = name;
        this.thumbImageID = thumbImageID;
        this.imageID = imageID;
    }

    public abstract void calcYarnRequired();

    protected void calcBallsNeeded()
    {
        ballsNeeded = (int) Math.ceil((double) yarnRequired / (double) ballSize);
    }
}
