package com.deb761.yarnestimator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

public class WeightsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weights);

        WeightListAdaptor adapter = new WeightListAdaptor(this,
                R.layout.weight_layout, yarnWeights);

        ListView listView = (ListView)findViewById(R.id.weightsListView);
        listView.setAdapter(adapter);

        getSupportActionBar().setTitle("Standard Yarn Weights");
        initHomeButton();
        initInfoButton();
    }

    YarnWeight[] yarnWeights = new YarnWeight[] {
            new YarnWeight("Fingering", "0-2 US, 2-3mm", "24-32 stitches/4", "14"),
            new YarnWeight("Sport", "3-6 US, 3-4mm", "24-26 stitches/4", "12"),
            new YarnWeight("DK", "3-6 US, 3-4mm", "22 stitches/4", "11"),
            new YarnWeight("Worsted", "7-8 US, 4.5-5mm", "20 stitches/4", "9"),
            new YarnWeight("Aran", "8-10 US, 5-6mm", "18 stitches/4", "8"),
            new YarnWeight("Bulky", "10-13 US, 6-9mm", "14-15 stitches/4", "7"),
            new YarnWeight("Super Bulky", "13+ US, 9+mm", "8-12 stitches/4", "5-6")
    };

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
