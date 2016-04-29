package com.deb761.yarnestimator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;

public class SelectActivity extends AppCompatActivity {
    private static Project project;

    public static Project getProject() {
        return project;
    }

    public static void setProject(Project proj) {
        project = proj;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        GridView gridview = (GridView) findViewById(R.id.portraitSelectGrid);
        gridview.setAdapter(new SelectGridAdaptor(this, R.layout.select_portrait_layout,
                projects));

        initWeightButton();
        initInfoButton();
    }

    Project[] projects = new Project[] {
            new Mittens("Mittens", R.drawable.mittens_thumb, MittensActivity.class),
            new Gloves("Gloves", R.drawable.gloves_thumb, MittensActivity.class),
            new Socks("Socks", R.drawable.socks_thumb, MittensActivity.class),
            new Tam("Tam", R.drawable.tam_thumb, MittensActivity.class),
            new Scarf("Scarf", R.drawable.scarf_thumb, MittensActivity.class),
            new Toque("Toque", R.drawable.toque_thumb, MittensActivity.class),
            new Sweater("Sweater", R.drawable.sweater_thumb, SweaterActivity.class),
            new Vest("Vest", R.drawable.vest_thumb, SweaterActivity.class),
            new Blanket("Blanket", R.drawable.scarf_thumb, MittensActivity.class)
    };

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
