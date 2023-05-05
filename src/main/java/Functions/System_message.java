/**
 * Program Code System_message
 * @author Sasatorn Lohanakakul
 */
package Functions;

public class System_message {
    //      constant parameter      //
    int MAX_PRODUCTION_CAPACITY_WEEK = 5000;

    //      input parameter     //
    int optimalRose;
    int optimalNoir;
    int numWeek;
    int capGrape;
    int capLabor;

    /**
     * Constructor for System_message
     * @param optimalRose 		Optimal number of Rose
     * @param optimalNoir		Optimal number of PNoir 
     * @param numWeek			Number of weeks
     * @param capGrape			Grape resource planned for the production cycle (in Kg)
     * @param capLabor			Labor resource planned for the production cycle (in Minute)
     */
    public System_message(int optimalRose, int optimalNoir, int numWeek, int capGrape, int capLabor) {
        this.optimalRose = optimalRose;
        this.optimalNoir = optimalNoir;
        this.numWeek = numWeek;
        this.capGrape = capGrape;
        this.capLabor = capLabor;
    }
    
    /**
     * Check whether need to output system message w1
     * @return Boolean, true for output w1, false for not output w1
     */
    public int checkW1() {
        int annualCapacity = this.MAX_PRODUCTION_CAPACITY_WEEK * this.numWeek;

        if (annualCapacity < this.optimalRose + this.optimalNoir) {
            // set message to w1
            return 1;
        }
        return 0;
    }
    
    /**
     * Check whether need to output system message w2
     * @return Boolean, true for output w2, false for not output w2
     */
    public int checkW2() {
        int annualCapacity = this.MAX_PRODUCTION_CAPACITY_WEEK * this.numWeek;

        float grapeSurplus = this.capGrape - (this.optimalRose * 6 + this.optimalNoir * 4);
        if (grapeSurplus / this.capGrape >= 0.1) {
            float labourSurplus = this.capLabor - (this.optimalRose * 5 + this.optimalNoir * 12);
            System.out.println(labourSurplus);
            if (labourSurplus < 0) {
                // set message to w2
                return 2;
            }
        }

        return 0;
    }
}
