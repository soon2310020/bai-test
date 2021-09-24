package com.example.demo.controller;

import com.example.demo.dao.ApiDao;
import com.example.demo.helper.ExcelHelper;
import com.example.demo.model.Company;
import com.example.demo.model.Lic_info;
import com.example.demo.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    ApiService apiService;
    @Autowired
    ApiDao apiDao;
    @GetMapping("/search-info")
    public ResponseEntity<List<Company>> searchInfor(@RequestParam Long page, @RequestParam Long size)
    {
        List<Company> companies =apiService.getAllCompany();
        return new ResponseEntity<List<Company>>(companies, HttpStatus.OK);
    }
    @PostMapping("/upload-info")
    public ResponseEntity<String> upload(@RequestParam Long company_id, @RequestParam("file") MultipartFile file)
    { List<Lic_info> lic_infos =new ArrayList<Lic_info>();
        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                lic_infos=ExcelHelper.excelToLic(file.getInputStream(),company_id);
                for (Lic_info lic_info:lic_infos) {

                    apiDao.save(lic_info);
                }
                return new ResponseEntity<String>("Success", HttpStatus.OK);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }



        }
        return new ResponseEntity<String>("Error", HttpStatus.OK);
    }
}
