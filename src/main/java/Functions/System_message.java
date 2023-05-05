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
    public boolean checkW1() {
        int total_output = (this.optimalNoir + this.optimalRose);
        float grapeSurplus = this.capGrape - (this.optimalRose * 6 + this.optimalNoir * 4);
        float labourSurplus = this.capLabor - (this.optimalRose * 5 + this.optimalNoir * 12);

        if (total_output == this.MAX_PRODUCTION_CAPACITY_WEEK*this.numWeek && ((grapeSurplus > 0) && (labourSurplus > 0))) {
            // set message to w1
            return true;
        } 
        return false;
    }

    /**
     * Check whether need to output system message w2
     * @return Boolean, true for output w2, false for not output w2
     */
    public boolean checkW2() {
        float grapeSurplus = this.capGrape - (this.optimalRose * 6 + this.optimalNoir * 4);
        if (grapeSurplus / this.capGrape >= 0.1) {
        	return true; 
        }

        return false;
    }
}
