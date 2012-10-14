package zeitdata.chart.sample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import zeitdata.chart.R;

@ContentView(R.layout.charttypes)
public class ChartTypesActivity extends RoboActivity {

    @InjectView(R.id.lineChartButton)
    private ImageButton lineChartButton;

    @InjectView(R.id.scatterChartButton)
    private ImageButton scatterChartButton;

    @InjectView(R.id.barChartButton)
    private ImageButton barChartButton;

    @InjectView(R.id.pieChartButton)
    private ImageButton pieChartButton;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lineChartButton.setOnClickListener(new LineChartButtonListener());

    }


    private class LineChartButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ChartTypesActivity.this, LineChartActivity.class);
            startActivity(intent);
        }
    }



}