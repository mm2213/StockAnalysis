package aggregators;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

public class AggregatorProcessor <E extends Aggregator>{
	
	E aggregator;
	String file;
	
	public AggregatorProcessor(E agg, String file) {
		//super();
		this.aggregator=agg;
		this.file=file;
	}

	public double runAggregator(int colsId) throws IOException {
		StockFileReader stockFileReader=new StockFileReader(file);
		List<String> fileData=stockFileReader.readFileData();
		
		for(String line: fileData) {
			String [] linesData = line.split(",");
			String s=linesData[colsId-1];
			Double d=Double.parseDouble(s);
			aggregator.add(d);
		}
		
		double number =aggregator.calculate();
		
		
		return number;
	}
	
}
