package zeitdata.charts.sample.activity;


import android.graphics.Color;
import android.os.Bundle;
import com.google.inject.Inject;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import zeitdata.charts.model.Data;
import zeitdata.charts.model.TimeData;
import zeitdata.charts.model.TimePoint;
import zeitdata.charts.model.TimeSeries;
import zeitdata.charts.sample.R;
import zeitdata.charts.sample.webservice.SomeWebService;
import zeitdata.charts.view.LineChart;


@ContentView(R.layout.linechart)
public class LineChartActivity extends RoboActivity {


    @InjectView(R.id.lineChart)
    LineChart lineChart;

    @Inject
    SomeWebService someWebService;

    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        NumericData numericPollenAsthmaData = this.buildNumericData();
        Data numericPollenAsthmaData = this.buildTimeData();

        lineChart.setData(numericPollenAsthmaData);

    }


    private TimeData buildTimeData(){
        double[][] xyAsthmaPoints = someWebService.getAsthmaDataByDay(10);
        TimeSeries.Builder asthmaSeriesBuilder = new TimeSeries.Builder();

        asthmaSeriesBuilder.withTitle("Asthma Attacks");
        //if you do not assign a Color, one will be chosen for you
        asthmaSeriesBuilder.withColor(Color.RED);


        for(int i = 0; i < xyAsthmaPoints.length; i++){

            //just to show you can pass in a java.util.Date .....
//        	asthmaSeriesBuilder.addPoint(new TimePoint.Builder(new Date((long)xyAsthmaPoints[i][0]), xyAsthmaPoints[i][1]).build());
            asthmaSeriesBuilder.addPoint(new TimePoint.Builder((long)xyAsthmaPoints[i][0], xyAsthmaPoints[i][1]).build());
        }
        TimeSeries asthmaSeries = asthmaSeriesBuilder.build();


        //2nd series - Week of Year (x) and Pollen Count (y)
        double[][] xyPollenCount = someWebService.getPollenDataByDay(15);

        TimeSeries.Builder pollenSeriesBuilder = new TimeSeries.Builder();

        pollenSeriesBuilder.withTitle("Pollen Count");
        asthmaSeriesBuilder.withColor(Color.rgb(165,42,42));  //brown

        //add data to the PollenSeriesBuilder
        for(int i = 0; i < xyPollenCount.length; i++){

            // here we pass in a 'long' which represents milliseconds since Epoch.
            pollenSeriesBuilder.addPoint(new TimePoint.Builder((long)xyPollenCount[i][0], xyPollenCount[i][1]).build());
        }

        TimeSeries pollenSeries = pollenSeriesBuilder.build();



        TimeData.Builder dataBuilder = new TimeData.Builder();

        dataBuilder.addSeries(asthmaSeries, pollenSeries);
        TimeData timeData = dataBuilder.build();

        return timeData;
    }


    /*
    private NumericData buildNumericData(){


        //1st series - Week of Year (x) and Asthma Attacks (y)
        //get Asthma Data for 15 weeks from someplace
        double[][] xyAsthmaPoints = someWebService.getAsthmaData(15);

        NumericSeries.Builder asthmaSeriesBuilder = new NumericSeries.Builder();

        asthmaSeriesBuilder.withTitle("Asthma Attacks");
        //if you do not assign a Color, one will be chosen for you
        asthmaSeriesBuilder.withColor(Color.RED);

        for(int i = 0; i < xyAsthmaPoints.length; i++){
            asthmaSeriesBuilder.addPoint(new NumericPoint.Builder(xyAsthmaPoints[i][0], xyAsthmaPoints[i][1]).build());
        }
        NumericSeries asthmaSeries = asthmaSeriesBuilder.build();



        //2nd series - Week of Year (x) and Pollen Count (y)
        double[][] xyPollenCount = someWebService.getPollenData(15);

        NumericSeries.Builder pollenSeriesBuilder = new NumericSeries.Builder();

        pollenSeriesBuilder.withTitle("Pollen Count");
        asthmaSeriesBuilder.withColor(Color.rgb(165,42,42));  //brown

        //add data to the PollenSeriesBuilder
        for(int i = 0; i < xyPollenCount.length; i++){
            pollenSeriesBuilder.addPoint(new NumericPoint.Builder(xyPollenCount[i][0], xyPollenCount[i][1]).build());
        }

        NumericSeries pollenSeries = pollenSeriesBuilder.build();

        NumericData.Builder numericDataBuilder = new NumericData.Builder();
        numericDataBuilder.addSeries(asthmaSeries, pollenSeries);
        NumericData numericData = numericDataBuilder.build();

        return numericData;
    }
    */
}
