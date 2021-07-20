package com.pavan.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="SECTOR")
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String breif;


//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(cascade=CascadeType.DETACH)
    private List<Company> companies;

    public Sector() {
        super();
    }

    public Sector(int id, String name, String breif) {
        this.id = id;
        this.name = name;
        this.breif = breif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreif() {
        return breif;
    }

    public void setBreif(String breif) {
        this.breif = breif;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
