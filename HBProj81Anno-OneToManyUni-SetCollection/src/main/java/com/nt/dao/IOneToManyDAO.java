package com.nt.dao;

public interface IOneToManyDAO {
    public void  saveDataUsingParent();
    public   void loadDataUsingParent();
    public  void  loadDataUsingParentAndQBC();
    public  void  deleteOneChildFromCollectionOfChildsBelongingToAParent();
}
