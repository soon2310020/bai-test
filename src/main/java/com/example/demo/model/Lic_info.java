package com.example.demo.model;

import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lic_info")
public class Lic_info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date created_by;
    private Date created_time;
    private Date effect_date;
    private Date expired_date;
    private Date expired_time;
    private String lic_number;
    private Long company_id;
    private Long parent_id;
    @ManyToOne
    @JoinColumn(name="company_id", insertable = false, updatable = false)
    private Company company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated_by() {
        return created_by;
    }

    public void setCreated_by(Date created_by) {
        this.created_by = created_by;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    public Date getEffect_date() {
        return effect_date;
    }

    public void setEffect_date(Date effect_date) {
        this.effect_date = effect_date;
    }

    public Date getExpired_date() {
        return expired_date;
    }

    public void setExpired_date(Date expired_date) {
        this.expired_date = expired_date;
    }

    public Date getExpired_time() {
        return expired_time;
    }

    public void setExpired_time(Date expired_time) {
        this.expired_time = expired_time;
    }

    public String getLic_number() {
        return lic_number;
    }

    public void setLic_number(String lic_number) {
        this.lic_number = lic_number;
    }

    public Long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }
}
