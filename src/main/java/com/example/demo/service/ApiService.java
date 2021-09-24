package com.example.demo.service;

import com.example.demo.dao.ApiDao;
import com.example.demo.dao.CompanyDao;
import com.example.demo.model.Company;
import com.example.demo.model.Lic_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApiService {
//@Query(value = "select * from company c inner join lic_info i on c.id=i.company_id",nativeQuery = true)
@Autowired
private CompanyDao apiDao;
    public List<Company> getAllCompany() {
        return apiDao.findAll();
    }

}
