/**
 * Program Code Function C
 * @author Angus, Fung Yin Lai
 */
package Functions;

public class FunctionC extends FunctionB{
	//data members
	private int Bko_Rose;
	private int Bko_Noir;

	//data member for output
	private boolean Bko_fulfill = false;

	/**
	 * Constructor for FunctionC
	 * @param WeekOfYear	Number of weeks to be estimated for the harvest season in format of YYMM, e.g. 2301
	 * @param Cap_Labor		Labor resource planned for the production cycle (in Minute)
	 * @param Cap_Grape		Grape resource planned for the production cycle (in Kg)
	 * @param Prc_Rose		Price of Rosé 
	 * @param Prc_Noir		Price of P-Noir
	 * @param Bko_Rose		Backorder volume of Rosé (in Litre)
	 * @param Bko_Noir		Backorder volume of P-Noir (in Litre)
	 * @return FunctionC Object
	 */
	//constructor
	public FunctionC(int WeekOfYear, int Cap_Labor, int Cap_Grape, float Prc_Rose, float Prc_Noir, int Bko_Rose, int Bko_Noir){
		super(WeekOfYear, Cap_Labor, Cap_Grape, Prc_Rose, Prc_Noir);
		this.Bko_Rose = Bko_Rose;
		this.Bko_Noir = Bko_Noir;
	}

	//accessors
	/**
	 * Accesssor of FunctionC.Bko_fulfill
	 * @return FunctionC.Bko_fulfill
	 */
	public boolean getBko_fulfill() {
		return Bko_fulfill;
	}

	/**
	 * Reserve Labor and Grape resources to backorder
	 */
	//reserve Cap_Labor and Cap_Grape to backorder before calculating product mix
	public void reserve_backorder() {
		int required_labor = 0;
		int required_grape = 0;

		required_labor += lc_rose * Bko_Rose + lc_noir * Bko_Noir;
		required_grape += gc_rose * Bko_Rose + gc_noir * Bko_Noir;

		if ((required_labor > Cap_Labor)||(required_grape > Cap_Grape)||((Bko_Rose + Bko_Noir) > pc)) {
			//resource insufficient to produce all backorder, calculate optimal mix
			int max_revenue = 0;
			int opt_rose_bko = 0;
			int opt_noir_bko = 0;

			for(int num_rose = 0; num_rose <= Bko_Rose; num_rose++) {
				float temp_revenue = 0;
				for(int num_noir = 0; num_noir <= Bko_Noir; num_noir++) {
					if ((num_noir + num_rose) > pc) break;
					int totalLabor = (num_rose * lc_rose) + (num_noir * lc_noir);
					int totalGrape = (num_rose * gc_rose) + (num_noir * gc_noir);

					if (totalLabor <= this.Cap_Labor && totalGrape <= this.Cap_Grape) { //check if the required labor and grape capacity are valid
						temp_revenue = (num_rose * this.Prc_Rose) + (num_noir * this.Prc_Noir);
						if (temp_revenue > max_revenue) {
							max_revenue = (int)temp_revenue;
							opt_rose_bko = num_rose;
							opt_noir_bko = num_noir;
						}
					}
				}
			}

			//Bko_fulfill is false by default so no need to update
			Opt_Rose += opt_rose_bko;
			Opt_Noir += opt_noir_bko;
			Opt_Revenue += max_revenue;
			Cap_Labor -= ((opt_rose_bko * lc_rose) + (opt_noir_bko * lc_noir));
			Cap_Grape -= ((opt_rose_bko * gc_rose) + (opt_noir_bko * gc_noir));

		} else {
			//resource sufficient to produce backorder, update Cap_Labor, Cap_Grape, Opt_Rose, Opt_Noir
			Bko_fulfill = true;
			Cap_Labor -= required_labor;
			Cap_Grape -= required_grape;
			Opt_Rose += Bko_Rose;
			Opt_Noir += Bko_Noir;
			Opt_Revenue += Bko_Rose * Prc_Rose + Bko_Noir * Prc_Noir;
		}		
		return;
	}

	/**
	 * Reserve Labor and Grape resources to backorder and calculate optimal mix 
	 */
	//reserve resources to backorder and update optimal mix
	public void update_backorder() {
		reserve_backorder();
		update();
	}

	//function for identifying abnormal situation
	/**
	 * Function for Backorder Ratio Checking
	 * Return false if ratio of backorder volume is lower than 70% of the optimal production volume
	 * @return boolean value of backorder ratio being valid
	 */
	public boolean bko_ratio_valid() {
		//check if backorder ratio is greater than 70% of the optimal production volume
		if ((Bko_Rose + Bko_Noir) < (Opt_Rose + Opt_Noir)*0.7) {
			return false;
		}

		return true;
	}
}