package com.pavan.entity;

import javax.persistence.*;

@Entity
@Table(name="COMPANY")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private long turnover;
    private String ceo;
    private String breif;
    private String bod;


    @ManyToOne(cascade=CascadeType.ALL)
    private Sector sector;

    public Company() {
        super();
    }

    public Company(int id, String name, long turnover, String ceo, String breif) {
        this.id = id;
        this.name = name;
        this.turnover = turnover;
        this.ceo = ceo;
        this.breif = breif;
    }

    public int getId() {
        return id;
    }

    public void setId(int ind) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTurnover() {
        return turnover;
    }

    public void setTurnover(long turnover) {
        this.turnover = turnover;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getBreif() {
        return breif;
    }

    public void setBreif(String breif) {
        this.breif = breif;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getBod() {
        return bod;
    }

    public void setBod(String bod) {
        this.bod = bod;
    }

}
