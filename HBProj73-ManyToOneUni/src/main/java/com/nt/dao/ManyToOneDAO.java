package com.nt.dao;

public interface ManyToOneDAO {
     public   void saveDataUsingChild();
     public  void loadDataUsingChild();
     public   void deleteAllChildsAndItsParent();
     public   void deleteOneChildFromParent();
}
