package zeitdata.chart.sample.activity;

import android.os.Bundle;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import zeitdata.chart.sample.R;
import zeitdata.chart.view.ScatterChart;

/**
 * Created with IntelliJ IDEA.
 * User: scott
 * Date: 10/15/12
 * Time: 11:55 AM
 * To change this template use File | Settings | File Templates.
 */
@ContentView(R.layout.scatterchart)
public class ScatterChartActivity extends RoboActivity{

    @InjectView(R.id.scatterChart)
    ScatterChart scatterChart;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scatterChart.getChartLabel();
        scatterChart.setTmp();

    }

}
