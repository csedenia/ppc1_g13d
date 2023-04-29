package Functions;

public class FunctionA {
    //    constant and other parameter initialization   //
    int MAX_PRODUCTION_CAPACITY_WEEK = 5000;
    float STANDARD_MAN_POWER = 37.5f;
    float LABOUR_RATE_WEEK = 935;
    float LABOUR_RATE = LABOUR_RATE_WEEK / (STANDARD_MAN_POWER * 60); 
    
    float LABOUR_CONSUMPTION_ROSE_MIN = 5;
    float LABOUR_CONSUMPTION_NOIR_MIN = 12;
    float GRAPE_CONSUMPTION_ROSE_MIN = 6;
    float GRAPE_CONSUMPTION_NOIR_MIN = 4; 

    //      input parameters       //
    private int numWeek;
    private int capLabor;
    private int capGrape;
    private float priceRose;
    private float priceNoir;
    private int fixedCost;
    
    // 		parameter inside 		//
    private int capacityRose;
    private int capacityNoir;

    //      output parameters       //
    private int optimalRose;
    private int optimalNoir;
    private float optimalGP;
    private float gpm;


    //      constructor        //
    public FunctionA(int numWeek, int capLabor, int capGrape, float priceRose, float priceNoir, int fixedCost) {
        this.numWeek = numWeek;
        this.capLabor = capLabor;
        this.capGrape = capGrape;
        this.priceRose = priceRose;
        this.priceNoir = priceNoir;
        this.fixedCost = fixedCost;

        this.optimalRose = 0;
        this.optimalNoir = 0;
        this.optimalGP = 0f;
        this.gpm = 0f;
        
        findCapacity(this.capLabor, this.capGrape);
    }

    //      get functions       //
    public int getOptimalRose() {
        return this.optimalRose;
    }
    public int getOptimalNoir() {
        return this.optimalNoir;
    }
    public float getOptimalGP() {
        return this.optimalGP;
    }
    public float getGPM() {
        return this.gpm;
    }
    public int getCapacityRose() {
    	return this.capacityRose;
    }
    public int getCapacityNoir() {
    	return this.capacityNoir;
    }
    
    
    public void findCapacity(int capLabor, int capGrape) {
    	float calculatedCapacityNoir = ((float)capGrape - ((float)capLabor * this.GRAPE_CONSUMPTION_ROSE_MIN / this.LABOUR_CONSUMPTION_ROSE_MIN)) / (this.GRAPE_CONSUMPTION_NOIR_MIN-this.LABOUR_CONSUMPTION_NOIR_MIN*this.GRAPE_CONSUMPTION_ROSE_MIN/this.LABOUR_CONSUMPTION_ROSE_MIN);	
    	this.capacityNoir = (int)(calculatedCapacityNoir);
    	float calculatedCapacityRose = 1/this.LABOUR_CONSUMPTION_ROSE_MIN * ((float)capLabor - this.LABOUR_CONSUMPTION_NOIR_MIN * calculatedCapacityNoir);
    	this.capacityRose = (int)(calculatedCapacityRose);
    }

	public void calculateGrossProfit() {
    	findCapacity(this.capLabor, this.capGrape);
    	for (int numRose = 0; numRose <= this.capacityRose; numRose++) {
	          for (int numNoir = 0; numNoir <= (this.capacityNoir); numNoir++) {
	              float salesRevenue = numRose * this.priceRose + numNoir * this.priceNoir;
	              float vcl = ((numRose * 5) + (numNoir * 12)) * LABOUR_RATE;
	              int maxProfit = (int)(salesRevenue - vcl) - this.fixedCost;
	              if (maxProfit > this.optimalGP) {
	            	  this.optimalRose = numRose;
	                  this.optimalNoir = numNoir;
	                  this.optimalGP = maxProfit;
	                  this.gpm = maxProfit / salesRevenue * 100;
	              }
	          }
    	}
        return;
    }

    public void checkAbnormalSituation() {
        calculateGrossProfit();
        int annualCapacity = this.MAX_PRODUCTION_CAPACITY_WEEK * this.numWeek;

        //      Situation A check      //
        if (annualCapacity < this.optimalRose + this.optimalNoir) {
            System.out.println("w1: Insufficient production capacity to produce the optimal mix, please reduce or adjust the capacity of labor & grape volume!");
        }

        //      Situation B check      //
        float grapeSurplus = this.capGrape - (this.optimalRose * 6 + this.optimalNoir * 4);
        if (grapeSurplus / this.capGrape >= 0.1) {
            float labourSurplus = this.capLabor - (this.optimalRose * 5 + this.optimalNoir * 12);
            System.out.println(labourSurplus);
            if (labourSurplus < 0) {
                System.out.println("w2: Insufficient labor supplied to utilize the grape resource (less than 90%)!");
            }
        }
    }
}
