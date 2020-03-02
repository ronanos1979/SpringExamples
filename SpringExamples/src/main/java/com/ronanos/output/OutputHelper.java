package com.ronanos.output;

import com.ronanos.output.impl.CsvOutputGenerator;

public class OutputHelper {
	IOutputGenerator outputGenerator;
	
	public OutputHelper(){
		outputGenerator = new CsvOutputGenerator();
	}
	
	public void generateOutput(){
		outputGenerator.generateOutput();
	}
	
}
