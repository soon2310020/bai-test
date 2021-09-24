package com.example.demo.dao;

import com.example.demo.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDao extends JpaRepository<Company,Long> {

}
