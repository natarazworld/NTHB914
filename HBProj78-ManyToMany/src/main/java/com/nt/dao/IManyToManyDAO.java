package com.nt.dao;

public interface IManyToManyDAO {
    public void saveDataUsingParents();
    public void saveDataUsingChilds();
    public void  loadDataUsingParents();
    public void  loadDataUsingChilds();
    public  void  deleteSpecificChildFromSpecifcParent();
    public  void  deleteAllChildsOfAParent();
    
}
