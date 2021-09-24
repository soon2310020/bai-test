package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "network_type")
public class Network_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String created_by;
    private String created_time;
    private String description;
    private String name;
    private Long parent_id;
    private Long order_no;
    private String alias;

}
