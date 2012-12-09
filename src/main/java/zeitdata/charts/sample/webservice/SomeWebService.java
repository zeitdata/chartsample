package zeitdata.charts.sample.webservice;

import java.util.Random;


public class SomeWebService {

	
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
    
}
