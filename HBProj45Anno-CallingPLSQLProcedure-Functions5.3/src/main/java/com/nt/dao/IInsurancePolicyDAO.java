package com.nt.dao;

import java.util.List;

import com.nt.entity.InsurancePolicy;

public interface IInsurancePolicyDAO {
     public List<InsurancePolicy>  getPolociesByTenure(int start,int end);
     public  String[]  getPolocyById(int id);
}
