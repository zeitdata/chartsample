package zeitdata.charts.sample.activity;

import android.os.Bundle;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import zeitdata.charts.sample.R;
import zeitdata.charts.view.LineChart;


@ContentView(R.layout.linechart)
public class LineChartActivity extends RoboActivity {


    @InjectView(R.id.lineChart)
    LineChart lineChart;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

}
