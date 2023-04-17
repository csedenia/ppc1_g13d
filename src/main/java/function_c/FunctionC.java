package function_c;

import function_b.FunctionB;

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
		return;
	}
}
