package zeitdata.chart.sample.activity;

import android.os.Bundle;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import zeitdata.chart.sample.R;


@ContentView(R.layout.linechart)
public class LineChartActivity extends RoboActivity {


    @InjectView(R.id.scatterChart)


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

}
