package com.example.demo.dao;

import com.example.demo.model.Company;
import com.example.demo.model.Lic_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.model.Company;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface ApiDao extends CrudRepository<Lic_info,Long> {

}
