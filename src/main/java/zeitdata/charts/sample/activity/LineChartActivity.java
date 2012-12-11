package zeitdata.charts.sample.activity;


import com.google.inject.Inject;
import android.graphics.Color;
import android.os.Bundle;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import zeitdata.charts.model.NumericData;
import zeitdata.charts.model.NumericPoint;
import zeitdata.charts.model.NumericSeries;
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

        NumericData numericPollenAsthmaData = this.buildNumericData();

        lineChart.setData(numericPollenAsthmaData);

    }

    

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
}
