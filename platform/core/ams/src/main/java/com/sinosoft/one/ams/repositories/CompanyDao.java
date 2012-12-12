package com.sinosoft.one.ams.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.ams.model.Company;

public interface CompanyDao extends PagingAndSortingRepository<Company, String>{

}
