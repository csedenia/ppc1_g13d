package Functions;

public class FunctionC extends FunctionB{
	//data members
	private int Bko_Rose;
	private int Bko_Noir;
	
	//data member for output
	private boolean Bko_fulfill = false;
	
	//constructor
	public FunctionC(int WeekOfYear, int Cap_Labor, int Cap_Grape, float Prc_Rose, float Prc_Noir, int Bko_Rose, int Bko_Noir){
		super(WeekOfYear, Cap_Labor, Cap_Grape, Prc_Rose, Prc_Noir);
		this.Bko_Rose = Bko_Rose;
		this.Bko_Noir = Bko_Noir;
	}
	
	//reserve Cap_Labor and Cap_Grape to backorder before calculating product mix
	public void reserve_backorder() {
		int required_labor = 0;
		int required_grape = 0;
		
		required_labor += lc_rose * Bko_Rose + lc_noir * Bko_Noir;
		required_grape += gc_rose * Bko_Rose + gc_noir * Bko_Noir;
		
		if ((required_labor > Cap_Labor)||(required_grape > Cap_Grape)) {
			return;
		} else {
			//resource sufficient to produce backorder, update Cap_Labor, Cap_Grape, Opt_Rose, Opt_Noir
			Bko_fulfill = true;
			Cap_Labor -= required_labor;
			Cap_Grape -= required_grape;
			Opt_Rose += Bko_Rose;
			Opt_Noir += Bko_Noir;
		}
		return;
	}
}