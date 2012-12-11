package zeitdata.charts.sample.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TimingLogger;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import zeitdata.charts.model.NumericData;
import zeitdata.charts.model.NumericPoint;
import zeitdata.charts.model.NumericSeries;
import zeitdata.charts.sample.R;
import zeitdata.charts.view.ScatterChart;

import java.util.Random;


@ContentView(R.layout.scatterchart)
public class ScatterChartActivity extends RoboActivity{

    @InjectView(R.id.scatterChartDynamicData)
    ScatterChart scatterChartDynamicData;



    @InjectView(R.id.scatterLayout)
    LinearLayout scatterLayout;


    public void onCreate(Bundle savedInstanceState) {

        TimingLogger timingLogger = new TimingLogger("ScatterChartActivity", "\n\n onCreate \n\n");


        super.onCreate(savedInstanceState);
//        scatterChart.getChartLabel();
//        scatterChart.setTmp();
//
        scatterChartDynamicData.setData(buildRandomData(15));

        timingLogger.dumpToLog();
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
        programmedChart.setData(buildStaticData());

        layout.addView(programmedChart);
    }


//    private NumericData buildData(){
//        NumericData data = new NumericData();

//        List<NumericSeries> numericSeriesList = new ArrayList<NumericSeries>();
//
//        NumericSeries series0 = new NumericSeries();
//        series0.setColor(Color.RED);
//        series0.setTitle("Unicorns");
//
//        NumericPoint point01 = new NumericPoint(2006, 20);
//        NumericPoint point02 = new NumericPoint(2007, 35);
//        NumericPoint point03 = new NumericPoint(2008, 14);
//        NumericPoint point04 = new NumericPoint(2009, 90);
//        NumericPoint point05 = new NumericPoint(2010, 24);
//        NumericPoint point06 = new NumericPoint(2011, 21);
//        NumericPoint point07 = new NumericPoint(2012, 73);
//
//        series0.setPoints(point01, point02, point03, point04, point05, point06, point07);
//
//        numericSeriesList.add(series0);
//
//
//        NumericSeries series1 = new NumericSeries();
//        series1.setColor(Color.GRAY);
//        series1.setTitle("Leprechauns");
//
//        NumericPoint point11 = new NumericPoint(2006, 23);
//        NumericPoint point12 = new NumericPoint(2007, 100);
//        NumericPoint point13 = new NumericPoint(2008, 9);
//        NumericPoint point14 = new NumericPoint(2009, 8);
//        NumericPoint point15 = new NumericPoint(2010, 5);
//        NumericPoint point16 = new NumericPoint(2011, 33);
//        NumericPoint point17 = new NumericPoint(2012, 88);
//
//
//        series1.setPoints(point12, point12, point13, point14, point15, point16, point17);
//
//        numericSeriesList.add(series1);
//
//
//        data.setSeries(numericSeriesList);

//        return data;
//    }

    private NumericData buildStaticData(){
        NumericData.Builder dataBuilder = new NumericData.Builder();
        NumericSeries.Builder seriesBuilder = new NumericSeries.Builder();

        seriesBuilder.withTitle("Unicorns");
        seriesBuilder.withColor(Color.RED);

        NumericPoint point01 = new NumericPoint.Builder(2006, 20).build();
        NumericPoint point02 = new NumericPoint.Builder(2007, 35).build();
        NumericPoint point03 = new NumericPoint.Builder(2008, 14).build();
        NumericPoint point04 = new NumericPoint.Builder(2009, 90).build();
        NumericPoint point05 = new NumericPoint.Builder(2010, 24).build();
        NumericPoint point06 = new NumericPoint.Builder(2011, 21).build();
        NumericPoint point07 = new NumericPoint.Builder(2012, 73).build();

        seriesBuilder.addPoints(point01, point02, point03, point04, point05, point06, point07);

        dataBuilder.addSeries(seriesBuilder.build());


        seriesBuilder = new NumericSeries.Builder();
        seriesBuilder.withColor(Color.GRAY);
        seriesBuilder.withTitle("Leprechauns");

        NumericPoint point11 = new NumericPoint.Builder(2006, 23).build();
        NumericPoint point12 = new NumericPoint.Builder(2007, 100).build();
        NumericPoint point13 = new NumericPoint.Builder(2008, 9).build();
        NumericPoint point14 = new NumericPoint.Builder(2009, 8).build();
        NumericPoint point15 = new NumericPoint.Builder(2010, 5).build();
        NumericPoint point16 = new NumericPoint.Builder(2011, 33).build();
        NumericPoint point17 = new NumericPoint.Builder(2012, 88).build();

        seriesBuilder.addPoints(point11, point12, point12, point13, point14, point15, point16, point17);


        dataBuilder.addSeries(seriesBuilder.build());

        return dataBuilder.build();
    }


    private static double[][] buildRandomDataCos(int numberOfDataPoints){

        double[][] xyPoints = new double[numberOfDataPoints][2];


        for(int i = 0; i<xyPoints.length; i++){
//            xyPoints[i][0] = Math.round(Math.random() * 100);
            xyPoints[i][0] = i+1;
//            xyPoints[i][1]= Math.cos(xyPoints[i][0]);
            xyPoints[i][1] = (new Random().nextInt((i+1)*10) + 1) *(i+1);
        }
        return xyPoints;
    }


    private static NumericData buildRandomData(int numberOfDataPoints){
        double[][] xyPoints = buildRandomDataCos(numberOfDataPoints);

        NumericSeries.Builder seriesBuilder = new NumericSeries.Builder();

        seriesBuilder.withTitle("Unicorns");
        seriesBuilder.withColor(Color.RED);

        for(int i = 0; i < xyPoints.length; i++){
            seriesBuilder.addPoint(new NumericPoint.Builder(xyPoints[i][0], xyPoints[i][1]).build());
        }

        return new NumericData.Builder().addSeries(seriesBuilder.build()).build();

    }

    public static void main(String[] args){
        double[][] result = ScatterChartActivity.buildRandomDataCos(10);
        System.out.println("Result is : " + result);

        NumericData data = buildRandomData(7);
        System.out.println("NumericData is " + data);

    }
}
