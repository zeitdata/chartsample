package zeitdata.charts.sample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import zeitdata.charts.sample.R;

@ContentView(R.layout.charttypes)
public class ChartTypesActivity extends RoboActivity {

    @InjectView(R.id.lineChartButton)
    private ImageButton lineChartButton;

    @InjectView(R.id.scatterChartButton)
    private ImageButton scatterChartButton;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lineChartButton.setOnClickListener(new LineChartButtonListener());
        scatterChartButton.setOnClickListener(new ScatterChartButtonListener());
    }


    private class LineChartButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ChartTypesActivity.this, LineChartActivity.class);
            startActivity(intent);
        }
    }

    private class ScatterChartButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ChartTypesActivity.this, ScatterChartActivity.class);
            startActivity(intent);
        }
    }

}