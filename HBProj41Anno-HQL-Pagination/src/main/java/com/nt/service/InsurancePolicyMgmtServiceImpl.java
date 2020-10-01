package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.dao.IInsurancePolicyDAO;
import com.nt.dao.InsurancePolicyDAOImpl;
import com.nt.dto.InsurancePolicyDTO;
import com.nt.entity.InsurancePolicy;

public class InsurancePolicyMgmtServiceImpl implements IInsurancePolicyMgmtService {
	 private IInsurancePolicyDAO  dao=null;
	
	public InsurancePolicyMgmtServiceImpl() {
		dao=new InsurancePolicyDAOImpl();
	}

	@Override
	public long fetchPagesCount(int pageSize) {
		long recordsCount=0L;
		long pagesCount=0L;
		recordsCount=dao.getTotalRecordsCount();
		pagesCount=recordsCount/pageSize;
		if(recordsCount%pageSize!=0)
			 pagesCount++;
		return pagesCount;
	}

	@Override
	public List<InsurancePolicyDTO> fetchPageData(int pageSize,int pageNo) {
		int startPos=0;
		List<InsurancePolicy> listEntities=null;
		List<InsurancePolicyDTO> listDTO=new ArrayList();
		//get StartPostion of record in db table for every page (based on given pageNo
		startPos=(pageNo*pageSize)-pageSize;
		//use DAO
		listEntities=dao.getPageData(pageSize, startPos);
		//convert listEntities to ListDTO
		listEntities.forEach(entity->{
			InsurancePolicyDTO dto=new InsurancePolicyDTO();
			dto.setPolicyId(entity.getPolicyId());
			dto.setPolicyName(entity.getPolicyName());
			dto.setPolicyType(entity.getPolicyType());
			dto.setTenure(entity.getTenure());
			dto.setCompany(entity.getCompany());
			dto.setSerialNo(listDTO.size()+1);
			listDTO.add(dto);
		});
		
		return listDTO;
	}

}
