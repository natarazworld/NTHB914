package com.nt.factory;

import com.nt.component.AmazonStore;
import com.nt.component.ECommerceStore;
import com.nt.proxy.ECommerceStoreDiscountProxy;

public class ECommerceStoreFactory {
	
	public  static  ECommerceStore  getInstance(String cuponCode) {
		
		   if(cuponCode.equalsIgnoreCase("") || cuponCode.trim().length()==0)
			      return new AmazonStore();  // real object
		   else {
			     if(cuponCode.equalsIgnoreCase("AM10"))
			    	 return new ECommerceStoreDiscountProxy(10);  //proxy obj
			     else if(cuponCode.equalsIgnoreCase("AM20"))
			    	 return new ECommerceStoreDiscountProxy(20); //proxy obj
			     else
			    	 return new ECommerceStoreDiscountProxy(5); //proxy object
		   }
		   
		  
	}//method

}//class
