package com.nt.service;

import com.nt.dao.ProductDAO;
import com.nt.dao.ProductDAOImpl;
import com.nt.dto.ProductDTO;
import com.nt.entity.Product;

public class ProductMgmtServiceImpl implements ProductMgmtService {
    private ProductDAO dao;
	
    public ProductMgmtServiceImpl() {
		dao=new ProductDAOImpl();
	}
	
	@Override
	public ProductDTO fetchProduct(int pid) {
		Product prod=null;
		ProductDTO dto=null;
	    //use DAO
		 prod=dao.getProduct(pid);
		 //convert entity to DTO
		 if(prod!=null) {
			 dto=new ProductDTO();
			 dto.setPid(prod.getPid());
			 dto.setPname(prod.getPname());
			 dto.setPrice((float)Math.round(prod.getPrice()));
			 dto.setQty((float)Math.round(prod.getQty()));
			  if(dto.getPrice()<1000)
				  dto.setCategory("Affordable");
			  else
				   dto.setCategory("premium");
			  return dto;
		 }
		 else {
		    return null;
		 }
	}//method
}//class
