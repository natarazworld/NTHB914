package com.nt.dao;

public interface OneToManyDAO {
    public  void saveDataUsingParent();
    public  void saveDataUsingChilds();
    
	public   void loadDataUsingParent();
	public   void loadDataUsingChild();
	
	
}
