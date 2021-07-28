package com.pavan.service;
import java.util.List;
import java.util.Optional;

import com.pavan.entity.Ipo;
import com.pavan.repository.IpoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class IpoService {

    @Autowired
    private IpoRepository ipoRepository;

    public List<Ipo> getAllIpo() {
        return ipoRepository.findAllByOrderByDateTimeAsc();
    }

    public Ipo addIpo(Ipo ipo) {
        return ipoRepository.save(ipo);
    }

    public Ipo getIpoByCompany(int id){
        return ipoRepository.findByCompanyId(id);
    }

    public Ipo updateIpo(int id, Ipo ipo) {
        Optional<Ipo> ipoToDelete = ipoRepository.findById(id);
        if(ipoToDelete.isPresent()) {
            ipo.setId(id);
            return ipoRepository.save(ipo);
        }
        return null;
    }

}
