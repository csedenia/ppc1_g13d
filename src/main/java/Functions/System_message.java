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

    public System_message(int optimalRose, int optimalNoir, int numWeek, int capGrape, int capLabor) {
        this.optimalRose = optimalRose;
        this.optimalNoir = optimalNoir;
        this.numWeek = numWeek;
        this.capGrape = capGrape;
        this.capLabor = capLabor;
    }

    public boolean checkW1() {
        int annualCapacity = this.MAX_PRODUCTION_CAPACITY_WEEK * this.numWeek;
        float grapeSurplus = this.capGrape - (this.optimalRose * 6 + this.optimalNoir * 4);
        float labourSurplus = this.capLabor - (this.optimalRose * 5 + this.optimalNoir * 12);

        if (annualCapacity == 5000*this.numWeek && ((grapeSurplus > 0) || (labourSurplus > 0))) {
            // set message to w1
            return true;
        }
        return false;
    }
    public boolean checkW2() {
        float grapeSurplus = this.capGrape - (this.optimalRose * 6 + this.optimalNoir * 4);
        if (grapeSurplus / this.capGrape >= 0.1) {
            float labourSurplus = this.capLabor - (this.optimalRose * 5 + this.optimalNoir * 12);
            System.out.println(labourSurplus);
            if (labourSurplus < 0) {
                return true;
            }
        }

        return false;
    }
}
