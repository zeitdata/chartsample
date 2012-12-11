package zeitdata.charts.sample.webservice;

import java.util.Calendar;
import java.util.Random;

import android.util.Log;


public class SomeWebService {

	
	public SomeWebService() {
		Log.d("com.acme", "SomeWebService constructor called");
	}
	
	
    public double[][] getData(int numberOfDataPoints){

        double[][] xyPoints = new double[numberOfDataPoints][2];


        for(int i = 0; i<xyPoints.length; i++){
            xyPoints[i][0] = i+1;
            xyPoints[i][1] = (new Random().nextInt((i+1)*10) + 1) *(i+1);
        }
        return xyPoints;
    }

    
    
    public double[][] getAsthmaData(int numberOfDataPoints){
    	return getData(numberOfDataPoints);
    }
    
    
    public double[][] getPollenData(int numberOfDataPoints){
    	return getData(numberOfDataPoints);
    }

    
    
    public double[][] getAsthmaDataByDay(int numberOfDataPoints){
    	return this.getTimeData(numberOfDataPoints);
    	
    }
    
    
    public double[][] getPollenDataByDay(int numberOfDataPoints){
    	return this.getTimeData(numberOfDataPoints);
    }
    
    
    public double[][] getTimeData(int numberOfDataPoints){

        double[][] xyPoints = new double[numberOfDataPoints][2];

        Calendar now = Calendar.getInstance();
        
        for(int i = 0; i<xyPoints.length; i++){
        	now.add(Calendar.DAY_OF_YEAR, 1);
            xyPoints[i][0] = now.getTimeInMillis();
            xyPoints[i][1] = (new Random().nextInt((i+1)*10) + 1) *(i+1);
        }
        return xyPoints;
    }
    
}
