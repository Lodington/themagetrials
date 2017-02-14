package dev.pet.MageTrials.utils;

public class IDAssigner {
	
	private int baseID;
	
	public IDAssigner(int baseID){
		this.baseID = baseID;//Assign an ID to ThreadPool
	}
	
	public int next(){
		return baseID++;//Increment ID
	}
	
	public int getCurrentID(){
		return baseID;
	}
	
}//end of class