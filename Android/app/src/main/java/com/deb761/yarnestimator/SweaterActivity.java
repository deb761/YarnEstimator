package com.deb761.yarnestimator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class SweaterActivity extends AppCompatActivity {

    private Sweater sweater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweater);

        sweater = (Sweater) SelectActivity.getProject();

        initGaugeUnitSpinner();
        initChestUnitSpinner();
        initYarnUnitSpinner();
        initBallUnitSpinner();

        initTextChangedEvents();
        initValues();

        initWeightButton();
        initHomeButton();
        initInfoButton();
    }
    private void initGaugeUnitSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.gaugeUnitsSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gauge_units_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new GaugeUnitsSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {

                super.onItemSelected(adapterView, view, pos, id);
                updateResults();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initChestUnitSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.chestUnitsSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.short_length_units_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new ChestUnitsSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {

                super.onItemSelected(adapterView, view, pos, id);
                updateResults();
            }
        });
    }

    private void initYarnUnitSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.yarnUnitsSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.long_length_units_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new YarnUnitsSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {

                super.onItemSelected(adapterView, view, pos, id);
                updateResults();
            }
        });
    }

    private void initBallUnitSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.ballSizeSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.long_length_units_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new BallUnitsSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {

                super.onItemSelected(adapterView, view, pos, id);
                updateResults();
            }
        });
    }

    private void initTextChangedEvents() {
        final EditText gaugeText = (EditText) findViewById(R.id.editGauge);
        gaugeText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                String str = gaugeText.getText().toString();
                if (str.length() > 0) {
                    sweater.setGauge(Double.parseDouble(str));
                    sweater.calcYarnRequired();
                    updateResults();
                }
            }

            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                //  Auto-generated method stub

            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                //  Auto-generated method stub
            }
        });

        final EditText chestSizeText = (EditText) findViewById(R.id.editChest);
        chestSizeText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                String sizeStr = chestSizeText.getText().toString();
                if (sizeStr.length() > 0) {
                    sweater.setChestSize(Double.parseDouble(sizeStr));
                    sweater.calcYarnRequired();
                    updateResults();
                }
            }

            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                //  Auto-generated method stub

            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                //  Auto-generated method stub
            }
        });

        final EditText ballSizeText = (EditText) findViewById(R.id.editBallSize);
        ballSizeText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                String str = ballSizeText.getText().toString();
                if (str.length() > 0) {
                    sweater.setBallSize(Integer.parseInt(str));
                    sweater.calcBallsNeeded();
                    updateResults();
                }
            }

            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                //  Auto-generated method stub

            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                //  Auto-generated method stub
            }
        });
    }

    private void initValues() {
        EditText gaugeText = (EditText) findViewById(R.id.editGauge);
        Spinner gaugeUnits = (Spinner) findViewById(R.id.gaugeUnitsSpinner);
        EditText chestSize = (EditText) findViewById(R.id.editChest);
        Spinner chestUnits = (Spinner) findViewById(R.id.chestUnitsSpinner);
        TextView yarnNeeded = (TextView) findViewById(R.id.yarnNeededText);
        Spinner yarnUnits = (Spinner) findViewById(R.id.yarnUnitsSpinner);
        EditText ballSize = (EditText) findViewById(R.id.editBallSize);
        Spinner ballUnits = (Spinner) findViewById(R.id.ballSizeSpinner);
        TextView ballsNeeded = (TextView) findViewById(R.id.ballsNeededText);

        gaugeText.setText(Double.toString(sweater.getGauge()));
        gaugeUnits.setSelection(sweater.getGaugeUnits().ordinal());
        chestSize.setText(Double.toString(sweater.getChestSize()));
        chestUnits.setSelection(sweater.getChestUnits().ordinal());
        yarnNeeded.setText(Integer.toString(sweater.getYarnNeeded()));
        yarnUnits.setSelection(sweater.getYarnNeededUnits().ordinal());
        ballSize.setText(Integer.toString(sweater.getBallSize()));
        ballUnits.setSelection(sweater.getBallSizeUnits().ordinal());
        ballsNeeded.setText(Integer.toString(sweater.getBallsNeeded()));
    }

    public void updateResults() {
        TextView yarnNeeded = (TextView) findViewById(R.id.yarnNeededText);
        TextView ballsNeeded = (TextView) findViewById(R.id.ballsNeededText);

        yarnNeeded.setText(Integer.toString(sweater.getYarnNeeded()));
        ballsNeeded.setText(Integer.toString(sweater.getBallsNeeded()));
    }

    private void initHomeButton() {
        ImageButton displayButton = (ImageButton) findViewById(R.id.homeButton);
        displayButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(getApplicationContext(), SelectActivity.class);
                startActivity(intent);

            }

        });
    }

    private void initWeightButton() {
        ImageButton displayButton = (ImageButton) findViewById(R.id.weightButton);
        displayButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(getApplicationContext(), WeightsActivity.class);
                startActivity(intent);

            }

        });
    }

    private void initInfoButton() {
        ImageButton displayButton = (ImageButton) findViewById(R.id.aboutButton);
        displayButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);

            }

        });
    }
}
