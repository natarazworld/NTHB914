package com.nt.dao;

import java.util.List;

import com.nt.entity.InsurancePolicy;

public interface IInsurancePolicyDAO {
    public  List<InsurancePolicy>  getPageData(int pageSize,int startPos);
    public  long  getTotalRecordsCount(); 
}
