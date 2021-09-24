package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String created_by;
    private String created_time;
    private String address;
    private String code;
    private String international_name;
    private String name;
    private String short_name;
    private String email;
    private String phone;
    private String representation_person;
    private String address_contact;
    private String contact_person;
    private String website;
    @OneToMany(mappedBy = "company" ,cascade = CascadeType.ALL)
    @Getter@Setter
    private List<Lic_info> lic_info;

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInternational_name() {
        return international_name;
    }

    public void setInternational_name(String international_name) {
        this.international_name = international_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRepresentation_person() {
        return representation_person;
    }

    public void setRepresentation_person(String representation_person) {
        this.representation_person = representation_person;
    }

    public String getAddress_contact() {
        return address_contact;
    }

    public void setAddress_contact(String address_contact) {
        this.address_contact = address_contact;
    }

    public String getContact_person() {
        return contact_person;
    }

    public void setContact_person(String contact_person) {
        this.contact_person = contact_person;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
