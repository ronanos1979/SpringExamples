package com.ronanos.output;

public class SpringOutputHelper {
	IOutputGenerator outputGenerator;
	
	public void generateOutput(){
		outputGenerator.generateOutput();
	}
	
	public void setOutputGenerator(IOutputGenerator outputGenerator){
		this.outputGenerator = outputGenerator;
	}
}
