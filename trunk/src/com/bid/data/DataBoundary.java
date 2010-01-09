package com.bid.data;

import java.util.List;

public class DataBoundary {

	boolean isUserValid(String id, String psw){
		return false;
	}
	
	List<String> getCatagories(){
		return null;
	}
	
	List<ItemDigest> getDyingItems(int from, int to){
		return null;
	}
	
	List<ItemDigest> getLatestItems(int from, int to){
		return null;
	}
}
