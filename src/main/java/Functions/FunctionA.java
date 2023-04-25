package Functions;

public class FunctionA {
    //    constant and other parameter initialization   //
    int MAX_PRODUCTION_CAPACITY_WEEK = 5000;
    float STANDARD_MAN_POWER = 37.5f;
    float LABOUR_RATE_WEEK = 935;
    float LABOUR_RATE = LABOUR_RATE_WEEK / (STANDARD_MAN_POWER * 60); 

    //      input parameters       //
    private int numWeek;
    private int capLabor;
    private int capGrape;
    private float priceRose;
    private float priceNoir;
    private int fixedCost;


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

    public void calculateGrossProfit() {
    	double maxProfitExcludeFixed = 0;
        for (int numRose = 0; numRose <= this.MAX_PRODUCTION_CAPACITY_WEEK; numRose++) {
            for (int numNoir = 0; numNoir <= (this.MAX_PRODUCTION_CAPACITY_WEEK - numRose); numNoir++) {
                double salesRevenue = numRose * this.priceRose + numNoir * this.priceNoir;
                double vcl = ((numRose * 5) + (numNoir * 12)) * LABOUR_RATE;
                double profitExcludeFixed = salesRevenue - vcl;
                if (profitExcludeFixed > maxProfitExcludeFixed) {
                    this.optimalRose = numRose;
                    this.optimalNoir = numNoir;
                    maxProfitExcludeFixed = profitExcludeFixed;
                    this.gpm = ((float)maxProfitExcludeFixed - this.fixedCost) / (float)salesRevenue * 100;
                }
            }
        }
        
        this.optimalGP = (int)(maxProfitExcludeFixed * this.numWeek - this.fixedCost);
        this.optimalRose = this.optimalRose * this.numWeek;
        this.optimalNoir = this.optimalNoir * this.numWeek;

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
