package com.nt.test;

import com.nt.component.ECommerceStore;
import com.nt.factory.ECommerceStoreFactory;

public class Customer2 {

	public static void main(String[] args) {
		ECommerceStore store=null;
        store=ECommerceStoreFactory.getInstance("");
        System.out.println(store.getClass());
        System.out.println("Bill Amount::"+store.shopping(new String[] {"rakhi","sweets"},new double[] {4000,3000} ));
        

	}//main
}//class
