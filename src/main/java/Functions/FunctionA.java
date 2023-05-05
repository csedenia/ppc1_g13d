/**
 * Program Code Function A
 * @author Sasatorn Lohanakakul
 */

package Functions;

public class FunctionA {
    //    constant and other parameter initialization   //
    int MAX_PRODUCTION_CAPACITY_WEEK = 5000;
    float STANDARD_MAN_POWER = 37.5f;
    float LABOUR_RATE_WEEK = 935;
    float LABOUR_RATE = LABOUR_RATE_WEEK / (STANDARD_MAN_POWER * 60); 
    
    int LABOUR_CONSUMPTION_ROSE_MIN = 5;
    int LABOUR_CONSUMPTION_NOIR_MIN = 12;
    int GRAPE_CONSUMPTION_ROSE_MIN = 6;
    int GRAPE_CONSUMPTION_NOIR_MIN = 4;

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
    private int optimalGP;
    private float gpm;

    /**
     * Constructor for FunctionA
     * @param numWeek			Number of weeks
     * @param capLabor			Labor resource planned for the production cycle (in Minute)
     * @param capGrape			Grape resource planned for the production cycle (in Kg)
     * @param priceRose			Price of Rosé
     * @param priceNoir			Price of P-Noir
     * @param fixedCost			Fixed cost 
     */
    public FunctionA(int numWeek, int capLabor, int capGrape, float priceRose, float priceNoir, int fixedCost) {
        this.numWeek = numWeek;
        this.capLabor = capLabor;
        this.capGrape = capGrape;
        this.priceRose = priceRose;
        this.priceNoir = priceNoir;
        this.fixedCost = fixedCost;

        this.optimalRose = 0;
        this.optimalNoir = 0;
        this.optimalGP = 0;
        this.gpm = 0f;
    }
    
    /**
     * Accessor of FunctionA.optimalRose
     * @return FunctionA.optimalRose
     */
    public int getOptimalRose() {
        return this.optimalRose;
    }
    
    /**
     * Accessor of FunctionA.optimalNoir
     * @return FunctionA.optimalNoir
     */
    public int getOptimalNoir() {
        return this.optimalNoir;
    }
    
    /**
     * Accessor of FunctionA.optimalGP
     * @return FunctionA.optimalGP
     */
    public int getOptimalGP() {
        return this.optimalGP;
    }
    
    /**
     * Accessor of FunctionA.getGPM
     * @return FunctionA.gpm
     */
    public float getGPM() {
        return this.gpm;
    }
    
    /**
     * Calculate the optimal Rose and PNoir which result in optimal gross profit
     */
	public void calculateGrossProfit() {
		this.optimalGP = -1 * this.fixedCost;
    	for (int numRose = 0; numRose <= this.MAX_PRODUCTION_CAPACITY_WEEK * this.numWeek; numRose++) {
	          for (int numNoir = 0; numNoir <= (this.MAX_PRODUCTION_CAPACITY_WEEK * this.numWeek - numRose); numNoir++) {
	        	  int totalLabor = (numRose * this.LABOUR_CONSUMPTION_ROSE_MIN) + (numNoir * this.LABOUR_CONSUMPTION_NOIR_MIN);
	        	  int totalGrape = (numRose * this.GRAPE_CONSUMPTION_ROSE_MIN) + (numNoir * this.GRAPE_CONSUMPTION_NOIR_MIN);
                  if (totalLabor <= this.capLabor && totalGrape <= this.capGrape) {
                      float salesRevenue = numRose * this.priceRose + numNoir * this.priceNoir;
                      float vcl = ((numRose * 5) + (numNoir * 12)) * LABOUR_RATE;
                      int maxProfit = (int)(salesRevenue - vcl) - this.fixedCost;
                      if (maxProfit >= this.optimalGP) {
                          this.optimalRose = numRose;
                          this.optimalNoir = numNoir;
                          this.optimalGP = maxProfit;
                          this.gpm = maxProfit / salesRevenue * 100;
                      }
                  }
	          }
    	}
        return;
    }
}
