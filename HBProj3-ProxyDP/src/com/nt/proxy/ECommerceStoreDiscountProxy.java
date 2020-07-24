package com.nt.proxy;

import com.nt.component.AmazonStore;
import com.nt.component.ECommerceStore;

public class ECommerceStoreDiscountProxy implements ECommerceStore {
	private  ECommerceStore  real;
	private float discount;
	
	public ECommerceStoreDiscountProxy(float discount) {
		this.discount=discount;
		real=new AmazonStore();
	}

	@Override
	public double shopping(String[] items, double[] prices) {
		double billAmt=0.0f;
		double finalAmt=0.0f;
		  //use real object
		billAmt=real.shopping(items, prices);
		//give the discount
		 finalAmt=billAmt-(billAmt*discount/100);
		 
		return finalAmt;
	}

}
