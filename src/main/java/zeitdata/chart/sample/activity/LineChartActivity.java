package zeitdata.chart.sample.activity;

import android.os.Bundle;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import zeitdata.chart.R;
import zeitdata.chart.view.LineChart;


@ContentView(R.layout.linechart)
public class LineChartActivity extends RoboActivity {



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LineChart lineChart = new LineChart(this);



    }

}
