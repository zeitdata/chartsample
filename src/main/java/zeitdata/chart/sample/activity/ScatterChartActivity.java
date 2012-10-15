package zeitdata.chart.sample.activity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
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

    @InjectView(R.id.scatterLayout)
    LinearLayout scatterLayout;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scatterChart.getChartLabel();
//        scatterChart.setTmp();
//
//        ScatterChart programmedChart = new ScatterChart(this);
//        programmedChart.setBackgroundColor(Color.WHITE);
//        programmedChart.setPadding(5,5,5,5);
//        programmedChart.setXAxisLabel("x-axisssss");
//        programmedChart.setYAxisLabel("y-axis yyyy");
//        programmedChart.setChartLabel("programmed!");
////        programmedChart.setData();
//
//        scatterLayout.addView(programmedChart);


        TextView tv = new TextView(this);
        tv.setText("WTF????");

        scatterLayout.addView(tv);


    }

}
