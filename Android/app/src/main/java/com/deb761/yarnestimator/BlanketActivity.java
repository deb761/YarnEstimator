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

public class BlanketActivity extends AppCompatActivity {

    private Blanket blanket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blanket);
        
        blanket = (Blanket) SelectActivity.getProject();

        initGaugeUnitSpinner();
        initUnitSpinner();
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

    private void initUnitSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.lengthUnitsSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.short_length_units_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {

                blanket.setUnits(ShortLengthUnits.fromInt(pos));
                updateResults();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
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
                    blanket.setGauge(Double.parseDouble(str));
                    blanket.calcYarnRequired();
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

        final EditText lengthText = (EditText) findViewById(R.id.editLength);
        lengthText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                String str = lengthText.getText().toString();
                if (str.length() > 0) {
                    blanket.setLength(Double.parseDouble(str));
                    blanket.calcYarnRequired();
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

        final EditText widthText = (EditText) findViewById(R.id.editWidth);
        lengthText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                String str = widthText.getText().toString();
                if (str.length() > 0) {
                    blanket.setWidth(Double.parseDouble(str));
                    blanket.calcYarnRequired();
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
                    blanket.setBallSize(Integer.parseInt(str));
                    blanket.calcBallsNeeded();
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
    // Initialize the values in all the text fields.  Also correct name view if not a blanket
    private void initValues() {
        TextView name = (TextView) findViewById(R.id.nameView);
        EditText gaugeText = (EditText) findViewById(R.id.editGauge);
        Spinner gaugeUnits = (Spinner) findViewById(R.id.gaugeUnitsSpinner);
        EditText length = (EditText) findViewById(R.id.editLength);
        EditText width = (EditText) findViewById(R.id.editWidth);
        Spinner lengthUnits = (Spinner) findViewById(R.id.lengthUnitsSpinner);
        TextView yarnNeeded = (TextView) findViewById(R.id.yarnNeededText);
        Spinner yarnUnits = (Spinner) findViewById(R.id.yarnUnitsSpinner);
        EditText ballSize = (EditText) findViewById(R.id.editBallSize);
        Spinner ballUnits = (Spinner) findViewById(R.id.ballSizeSpinner);
        TextView ballsNeeded = (TextView) findViewById(R.id.ballsNeededText);

        name.setText(blanket.getName());
        gaugeText.setText(Double.toString(blanket.getGauge()));
        gaugeUnits.setSelection(blanket.getGaugeUnits().ordinal());
        length.setText(Double.toString(blanket.getLength()));
        width.setText(Double.toString(blanket.getWidth()));
        lengthUnits.setSelection(blanket.getUnits().ordinal());
        yarnNeeded.setText(Integer.toString(blanket.getYarnNeeded()));
        yarnUnits.setSelection(blanket.getYarnNeededUnits().ordinal());
        ballSize.setText(Integer.toString(blanket.getBallSize()));
        ballUnits.setSelection(blanket.getBallSizeUnits().ordinal());
        ballsNeeded.setText(Integer.toString(blanket.getBallsNeeded()));
    }

    public void updateResults() {
        TextView yarnNeeded = (TextView) findViewById(R.id.yarnNeededText);
        TextView ballsNeeded = (TextView) findViewById(R.id.ballsNeededText);

        yarnNeeded.setText(Integer.toString(blanket.getYarnNeeded()));
        ballsNeeded.setText(Integer.toString(blanket.getBallsNeeded()));
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
