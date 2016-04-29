package com.deb761.yarnestimator;

/**
 * Created by deb on 4/25/16.
 */

enum GaugeUnits { StsPerInch, StsPer4inch, StsPer10cm;
    private static GaugeUnits[] values = null;
    public static GaugeUnits fromInt(int i) {
        if (GaugeUnits.values == null) {
            GaugeUnits.values = GaugeUnits.values();
        }
        return GaugeUnits.values[i];
    }
}
enum ShortLengthUnits { Inches, CM;
    private static ShortLengthUnits[] values = null;
    public static ShortLengthUnits fromInt(int i) {
        if (ShortLengthUnits.values == null) {
            ShortLengthUnits.values = ShortLengthUnits.values();
        }
        return ShortLengthUnits.values[i];
    }
}
enum LongLengthUnits { Yards, Meters;
    private static LongLengthUnits[] values = null;
    public static LongLengthUnits fromInt(int i) {
        if (LongLengthUnits.values == null) {
            LongLengthUnits.values = LongLengthUnits.values();
        }
        return LongLengthUnits.values[i];
    }
}

public abstract class Project {
    private String name;
    private double gauge;
    private GaugeUnits gaugeUnits;
    private int thumbImageID;
    private  Class<?> aClass;
    protected int yarnNeeded;
    private LongLengthUnits yarnNeededUnits;
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

    public Class<?> getaClass() {
        return aClass;
    }

    public void setaClass(Class<?> aClass) {
        this.aClass = aClass;
    }

    public int getYarnNeeded() {
        return yarnNeeded;
    }

    public LongLengthUnits getYarnNeededUnits() {
        return yarnNeededUnits;
    }

    public void setYarnNeededUnits(LongLengthUnits yarnNeededUnits) {
        this.yarnNeededUnits = yarnNeededUnits;
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

    public Project () {
        gauge = 20;
        gaugeUnits = GaugeUnits.StsPer10cm;
        yarnNeeded = 0;
        yarnNeededUnits = LongLengthUnits.Meters;
        ballSize = 150;
        ballSizeUnits = LongLengthUnits.Meters;
        ballsNeeded = 0;
    }
    public Project(String name, int thumbImageID, Class<?> aClass)
    {
        this();
        this.name = name;
        this.thumbImageID = thumbImageID;
        this.aClass = aClass;
    }

    public abstract void calcYarnRequired();

    protected void calcBallsNeeded()
    {
        ballsNeeded = (int) Math.ceil((double) yarnNeeded / (double) ballSize);
    }
}
