package com.nt.dao;

public interface OneToManyDAO {
    public  void saveDataUsingParent();
    public  void  deleteOneChildFromCollectionOfChildsBelogingToAParent();
    
}
