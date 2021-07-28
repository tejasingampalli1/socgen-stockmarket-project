package com.pavan.repository;
import java.util.List;

import com.pavan.entity.Ipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IpoRepository extends JpaRepository<Ipo, Integer>{

    public List<Ipo> findAllByOrderByDateTimeAsc();

    public Ipo findByCompanyId(@Param("companyId") int companyId);

}