package com.deb761.yarnestimator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SweaterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweater);

        initWeightButton();
        initHomeButton();
        initInfoButton();
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
