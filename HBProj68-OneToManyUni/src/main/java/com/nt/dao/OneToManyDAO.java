package com.nt.dao;

public interface OneToManyDAO {
    public  void saveDataUsingParent();
    public   void loadDataUsingParent();
    public  void  addNewChildToExistingParent();
    public  void  deletingAParentAndItsChilds();
    public   void  deleteAllParentsAndTheirChilds();
    public   void  deleteAllParentsAndTheirChilds1();
    public  void  deleteAllChildsOfAParent();
    public  void  deleteOneChildFromCollectionOfChildsFromAParent();
    public  void  transferOneChildOfOneParentToAnotherParent();   
    
    
}
