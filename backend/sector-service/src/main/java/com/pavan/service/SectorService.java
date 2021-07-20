package com.pavan.service;

import com.pavan.entity.Company;
import com.pavan.entity.Sector;
import com.pavan.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectorService {

    @Autowired
    private SectorRepository sectorRepository;


    public List<Sector> getAllSectors() {
        return sectorRepository.findAll();
    }

    public Sector addSector(Sector sector) {
        return sectorRepository.save(sector);
    }

    public Sector getOneSector(int id) {
        Optional<Sector> sectorOptional=sectorRepository.findById(id);
        if(sectorOptional.isPresent()){
            return sectorOptional.get();
        }
        return null;
    }


    public List<Company> getCompanies(int id) {
        Optional<Sector> sector =sectorRepository.findById(id);
        if(sector.isPresent()){
            return sector.get().getCompanies();
        }
        return null;

    }
}
