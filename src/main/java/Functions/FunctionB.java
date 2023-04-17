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
}
