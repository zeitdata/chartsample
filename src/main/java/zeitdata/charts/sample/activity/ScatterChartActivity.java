package zeitdata.charts.sample.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import zeitdata.chart.model.NumericChartData;
import zeitdata.chart.model.NumericPoint;
import zeitdata.chart.model.NumericSeries;
import zeitdata.chart.sample.R;
import zeitdata.chart.view.ScatterChart;

import java.util.ArrayList;
import java.util.List;


@ContentView(R.layout.scatterchart)
public class ScatterChartActivity extends RoboActivity{

    @InjectView(R.id.scatterChartDynamicData)
    ScatterChart scatterChartDynamicData;



    @InjectView(R.id.scatterLayout)
    LinearLayout scatterLayout;


    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
//        scatterChart.getChartLabel();
//        scatterChart.setTmp();
//
        TextView tv = new TextView(this);
        tv.setText("WTF????");

        scatterLayout.addView(tv);

        scatterChartDynamicData.setNumericData(buildData());


//        buildProgrammedChart(scatterLayout);

    }




    private void addProgrammedChart(LinearLayout layout){
        ScatterChart programmedChart = new ScatterChart(this);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        programmedChart.setLayoutParams(lp);
        programmedChart.setBackgroundColor(Color.WHITE);
        programmedChart.setPadding(5,5,5,5);
        programmedChart.setXAxisLabel("x-axisssss");
        programmedChart.setYAxisLabel("y-axis yyyy");

        programmedChart.setChartLabel("programmed!");
        programmedChart.setNumericData(buildData());

        layout.addView(programmedChart);
    }


    private NumericChartData buildData(){
        NumericChartData data = new NumericChartData();

        List<NumericSeries> numericSeriesList = new ArrayList<NumericSeries>();

        NumericSeries series0 = new NumericSeries();
        series0.setColor(Color.RED);
        series0.setTitle("Unicorns");

        NumericPoint point01 = new NumericPoint(2006, 20);
        NumericPoint point02 = new NumericPoint(2007, 35);
        NumericPoint point03 = new NumericPoint(2008, 14);
        NumericPoint point04 = new NumericPoint(2009, 90);
        NumericPoint point05 = new NumericPoint(2010, 24);
        NumericPoint point06 = new NumericPoint(2011, 21);
        NumericPoint point07 = new NumericPoint(2012, 73);

        series0.setPoints(point01, point02, point03, point04, point05, point06, point07);

        numericSeriesList.add(series0);


        NumericSeries series1 = new NumericSeries();
        series1.setColor(Color.GRAY);
        series1.setTitle("Leprechauns");

        NumericPoint point11 = new NumericPoint(2006, 23);
        NumericPoint point12 = new NumericPoint(2007, 100);
        NumericPoint point13 = new NumericPoint(2008, 9);
        NumericPoint point14 = new NumericPoint(2009, 8);
        NumericPoint point15 = new NumericPoint(2010, 5);
        NumericPoint point16 = new NumericPoint(2011, 33);
        NumericPoint point17 = new NumericPoint(2012, 88);


        series1.setPoints(point12, point12, point13, point14, point15, point16, point17);

        numericSeriesList.add(series1);


        data.setSeries(numericSeriesList);

        return data;
    }

}
