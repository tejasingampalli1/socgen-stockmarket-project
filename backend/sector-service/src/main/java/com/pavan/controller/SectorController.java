package com.pavan.controller;

import com.pavan.entity.Company;
import com.pavan.entity.Sector;
import com.pavan.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SectorController {

    @Autowired
    private SectorService sectorService;

    public String working(){
        return "Hello from Sector Service";
    }

    @GetMapping("/sectors")
    public ResponseEntity<List<Sector>> getAllSectors() {
        return ResponseEntity.ok(sectorService.getAllSectors());
    }

    @PostMapping("/sectors")
    public ResponseEntity<Sector> addSector(@RequestBody Sector sector){
        return ResponseEntity.ok(sectorService.addSector(sector));
    }

    @GetMapping("/sectors/{id}")
    public ResponseEntity getOneSector(@PathVariable int id){
        Sector sector=sectorService.getOneSector(id);
        if(sector==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sector is not found for the given id");
        }
        return ResponseEntity.ok(sector);
    }

    @GetMapping("/companies/{id}")
    public ResponseEntity<List<Company>> getCompanies(@PathVariable int id){
        return ResponseEntity.ok(sectorService.getCompanies(id));
    }

}
