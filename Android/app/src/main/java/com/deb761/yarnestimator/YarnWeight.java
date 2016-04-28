package com.deb761.yarnestimator;

/**
 * Created by deb on 4/27/16.
 */
public class YarnWeight {
    private String name;
    // suggested needle sizes in US and international units
    private String needles;
    // Stitches per 4" or 10cm
    private String gauge;
    // Windings per inch
    private String wpi;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNeedles() {
        return needles;
    }

    public void setNeedles(String needles) {
        this.needles = needles;
    }

    public String getGauge() {
        return gauge;
    }

    public void setGauge(String gauge) {
        this.gauge = gauge;
    }

    public String getWpi() {
        return wpi;
    }

    public void setWpi(String wpi) {
        this.wpi = wpi;
    }

    public YarnWeight(String name, String needles, String gauge, String wpi) {
        this.name = name;
        this.needles = needles;
        this.gauge = gauge;
        this.wpi = wpi;
    }
}
