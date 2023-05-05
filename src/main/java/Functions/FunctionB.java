package Functions;

public class FunctionB {
	//constants
	protected static final int lc_rose = 5;		//labor consumption for 1 litre of rose
	protected static final int lc_noir = 12;	//labor consumption for 1 litre of p-noir
	protected static final int gc_rose = 6;		//grape consumption for 1 litre of rose
	protected static final int gc_noir = 4;		//grape consumption for 1 litre of p-noir
	protected static final int pc = 5000; 		//production capacity of manufacturing capacity
	
	//data members
	protected int WeekOfYear;
	protected int Cap_Labor;
	protected int Cap_Grape;
	protected float Prc_Rose;
	protected float Prc_Noir;
	
	//data members for output
	protected int Opt_Rose = 0;					//number of litres to be produced for rose
	protected int Opt_Noir = 0;					//number of litres to be produced for p-noir
	protected int Opt_Revenue = 0;				
	private int Sur_Labor = 0;					//resource surplus of labor
	private int Sur_Grape = 0;					//resource surplus of grape
	
	//constructor
	public FunctionB(int WeekOfYear, int Cap_Labor, int Cap_Grape, float Prc_Rose, float Prc_Noir){
		this.WeekOfYear = WeekOfYear;
		this.Cap_Labor = Cap_Labor;
		this.Cap_Grape = Cap_Grape;
		this.Prc_Rose = Prc_Rose;
		this.Prc_Noir = Prc_Noir;
	}
	
	public void update() {
		int max_revenue = 0;
		int max_Rose = 0;
		int max_Noir = 0;
		for (int i = 0; i <= pc; i++) {
			float revenue = 0; //temp revenue for each round
			for (int j = 0; j <= pc-i; j++) {
				int roseProduction = i;
				int noirProduction = j;
				int totalLabor = (roseProduction * lc_rose) + (noirProduction * lc_noir);
				int totalGrape = (roseProduction * gc_rose) + (noirProduction * gc_noir);
				if (totalLabor <= this.Cap_Labor && totalGrape <= this.Cap_Grape) { // pattern checking
					revenue = (roseProduction * this.Prc_Rose) + (noirProduction * this.Prc_Noir);
					if (revenue > max_revenue) {// if yes, update all output data
						max_revenue = (int)revenue;
						max_Rose = i;
						max_Noir = j;
						Sur_Labor = this.Cap_Labor - (i*lc_rose + j*lc_noir);
						Sur_Grape = this.Cap_Grape - (i*gc_rose + j*gc_noir);
						if(Sur_Labor <= lc_rose && Sur_Labor <= lc_noir) {//checking can it make one more any type of wine
							Sur_Labor = 0;
						}
						if(Sur_Grape <= gc_rose && Sur_Grape <= gc_noir) {//checking can it make one more any type of wine
							Sur_Grape = 0;
						}
					}
				}
			}
		}
		Opt_Revenue += max_revenue;
		Opt_Rose += max_Rose;
		Opt_Noir += max_Noir;
	}
	
	//accessors
	public int getOpt_Revenue() {
		return Opt_Revenue;
	}
	
	public int getOpt_Rose() {
		return Opt_Rose;
	}
	
	public int getOpt_Noir() {
		return Opt_Noir;
	}
	
	public int getSur_Labor() {
		return Sur_Labor;
	}
	
	public int getSur_Grape() {
		return Sur_Grape;
	}
	
	//functions for identifying abnormal situation
	public boolean pc_valid() {
		//check if actual pc > pc
		if ((Opt_Rose + Opt_Noir) > pc) {
			return false;
		}
		
		return true;
	}
	
	public boolean grape_consumption_valid() {
		//check if grape consumption > 90%
		if (((gc_rose * Opt_Rose) + (gc_noir * Opt_Noir)) < (Cap_Grape * 0.9)) {
			return false;
		}
					
		return true;
	}
	
	public boolean Sur_Labor_valid() {
		//check if Sur_Labor is positive
		if (Sur_Labor < 0) {
			return false;
		}
		
		return true;
	}
	
	public boolean Sur_Grape_valid() {
		//check if Sur_Labor is positive
		if (Sur_Grape < 0) {
			return false;
		}
		
		return true;
	}
}
