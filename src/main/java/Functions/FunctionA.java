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

    //      constructor        //
    public FunctionA(int numWeek, int capLabor, int capGrape, float priceRose, float priceNoir, int fixedCost) {
        this.numWeek = numWeek;
        this.capLabor = capLabor;
        this.capGrape = capGrape;
        this.priceRose = priceRose;
        this.priceNoir = priceNoir;
        this.fixedCost = fixedCost;

        //      variables that need to be calculated       //

    }

    public int[] calculateGrossProfit() {
        int maxGrossProfitWeek = 0;
        int optimalRose = 0;
        int optimalNoir = 0;
        for (int numRose = 0; numRose < this.MAX_PRODUCTION_CAPACITY_WEEK; numRose++) {
            for (int numNoir = 0; numNoir < (this.MAX_PRODUCTION_CAPACITY_WEEK - numRose); numNoir++) {
                float salesRevenue = numRose * this.priceRose + numNoir * this.priceNoir;
                float vcl = ((numRose * 5) + (numNoir * 12)) * LABOUR_RATE;
                int grossProfit = (int)(salesRevenue - vcl) - this.fixedCost;
                if (grossProfit > maxGrossProfitWeek) {
                    maxGrossProfitWeek = grossProfit;
                    optimalRose = numRose;
                    optimalNoir = numNoir;
                }
            }
        }

        float optimalSaleRevenueWeek = optimalRose * this.priceRose + optimalNoir * this.priceNoir;
        float gpm = maxGrossProfitWeek / optimalSaleRevenueWeek * 100;

        int[] optimal_arr = {optimalRose, optimalNoir, maxGrossProfitWeek * this.numWeek};
        return optimal_arr;
    }

    public void checkAbnormalSituation() {
        int[] optimal_arr = calculateGrossProfit();
        int optimalRose = optimal_arr[0];
        int optimalNoir = optimal_arr[1];
        int annualCapacity = this.MAX_PRODUCTION_CAPACITY_WEEK * this.numWeek;

        //      Situation A check      //
        if (annualCapacity < optimal_arr[1] + optimal_arr[2]) {
            System.out.println("w1: Insufficient production capacity to produce the" +
                    "optimal mix, please reduce or adjust the capacity of labor & grape volume!");
        }

        //      Situation B check      //
        float consumptionGrapePercentage = (optimalRose + optimalNoir) / annualCapacity;
        boolean isLessThan = (consumptionGrapePercentage < 0.9);
        if (isLessThan) {
            System.out.println("w2: Insufficient labor supplied to utilize the" +
                    "grape resource (less than 90%)!");
        }
    }
}
