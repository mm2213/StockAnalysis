package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

public class StockFileApplication {
	
	public static void main(String args[]) throws IOException{
		StockFileReader fr = new StockFileReader("table.csv");
		
		List<HashMap<String, Double>> dataResult = populateStockFileData(fr.getHeaders(), fr.readFileData());
		StockFileData fileData = new StockFileData();
		fileData.addData(dataResult);
		fileData.printData();
		System.out.println(dataResult.size());
		 
		
	}
	/**
	 * Complete the method body so that it returns the given structure needed to 
	 * populate the data field in the StockFileData class. 
	 * @param headers
	 * @param lines
	 * @return List
	 */
	public static List<HashMap<String, Double>> populateStockFileData(List<String> headers, List<String> lines){
		List<HashMap<String, Double>> dataResult = new ArrayList<>();
		// Insert your code here..
		for (String dataLines : lines) {
			String [] arrValues = dataLines.split(",");
			List<String> values = new ArrayList<String>();
			values = Arrays.asList(arrValues);
			HashMap<String,Double> headerValueMap=new HashMap<>();
			for(int i=0;i<headers.size();i++) {
				Double val=Double.parseDouble(values.get(i));
				headerValueMap.put(headers.get(i), val);
			}
			dataResult.add(headerValueMap);
			
		}
		
		return dataResult;
	}
}
