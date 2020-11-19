package com.nt.dao;

public interface OneToManyDAO {
  
	public void loadDataUsingParent();
	public void  loadDataUsingParentThroughQBC();
	public void  loadDataUsingParentThroughJPQBC();
	public  void LoadDataUisngParentThroughHQLJoin();
	public  void LoadDataUisngParentThroughHQLJoinScalar();
	
}
