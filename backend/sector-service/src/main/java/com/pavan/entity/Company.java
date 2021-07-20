package com.pavan.entity;

import javax.persistence.*;

@Entity
@Table(name="COMPANY")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ind;
    private String name;
    private long turnover;
    private String ceo;
    private String breif;

    @ManyToOne(cascade=CascadeType.ALL)
    private Sector sector;

    public Company() {
        super();
    }

    public Company(int ind, String name, long turnover, String ceo, String breif) {
        this.ind = ind;
        this.name = name;
        this.turnover = turnover;
        this.ceo = ceo;
        this.breif = breif;
    }

    public int getInd() {
        return ind;
    }

    public void setInd(int ind) {
        this.ind = ind;
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
}
