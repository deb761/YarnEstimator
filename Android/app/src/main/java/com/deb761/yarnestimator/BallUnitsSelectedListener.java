package com.deb761.yarnestimator;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

/**
 * Created by deb on 4/28/16.
 */
public class BallUnitsSelectedListener implements OnItemSelectedListener {

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Project project = SelectActivity.getProject();
        project.setBallSizeUnits(LongLengthUnits.fromInt(pos));
        project.calcBallsNeeded();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
