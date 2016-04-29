package com.deb761.yarnestimator;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

/**
 * Created by deb on 4/28/16.
 */
public class GaugeUnitsSelectedListener implements OnItemSelectedListener {

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Project project = SelectActivity.getProject();
        project.setGaugeUnits(GaugeUnits.fromInt(pos));
        project.calcYarnRequired();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
