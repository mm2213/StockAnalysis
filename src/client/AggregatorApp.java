package client;

import java.io.IOException;

import aggregators.AggregatorProcessor;
import aggregators.MaxAggregator;
import aggregators.MeanAggregator;
import aggregators.MinAggregator;

public class AggregatorApp {

	public static void main(String[] args) throws IOException {
		
		/**
			You'll need to uncomment the below code. You'll notice it does not compile!
			
			There are 2 objectives in this assignment.
			
			1).  Make sure the code compiles correctly after you uncomment it below.
			2).  Make sure it runs as explained in the assignment video!
			
			-->> YOUR WORK SHOULD BE DONE IN THE AggregatorProcessor CLASS. 
		**/

		MaxAggregator agg1 = new MaxAggregator();
		MinAggregator agg2 = new MinAggregator();
		MeanAggregator agg3 = new MeanAggregator();
		AggregatorProcessor<MaxAggregator> aggsProcessor1 = new AggregatorProcessor<MaxAggregator>(agg1, "table.csv");
		AggregatorProcessor<MinAggregator> aggsProcessor2 = new AggregatorProcessor<MinAggregator>(agg2, "table.csv");
		AggregatorProcessor<MeanAggregator> aggsProcessor3 = new AggregatorProcessor<MeanAggregator>(agg3, "table.csv");
		double value1 = aggsProcessor1.runAggregator(1);
		double value2 = aggsProcessor2.runAggregator(2);
		double value3 = aggsProcessor3.runAggregator(3);
		
		System.out.println("max value of 1st column " + value1);
		System.out.println("min value of 2nd column " + value2);
		System.out.println("mean value of 3rd column "+ value3);
	

	}

}
