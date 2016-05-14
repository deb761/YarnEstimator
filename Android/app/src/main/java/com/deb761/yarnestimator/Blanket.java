package com.deb761.yarnestimator;

/**
 * Created by deb on 4/27/16.
 */
public class Blanket extends Project {

    private double length;
    private double width;
    private ShortLengthUnits units;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public ShortLengthUnits getUnits() {
        return units;
    }

    public void setUnits(ShortLengthUnits units) {
        this.units = units;
    }

    public Blanket(String name, int thumbImageID, Class<?> aClass) {
        super(name, thumbImageID, aClass);

        length = 60;
        width = 90;
        units = ShortLengthUnits.CM;
    }

    // Calculations borrowed from http://www.thedietdiary.com/knittingfiend/tools/EstimatingYardageRectangles.html
    // copyright Lucia Liljegren 2005.
    @Override
    public void calcYarnRequired() {
        double siLength = length;
        double siWidth = width;

        // First, put values into SI units
        if (units == ShortLengthUnits.Inches) {
            siLength = length * inches2cm;
            siWidth = width * inches2cm;
        }

        calcYarnRequired(siLength, siWidth);
    }
}
