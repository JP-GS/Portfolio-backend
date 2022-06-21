package com.portfolio.juanpgs.Repository;

import com.portfolio.juanpgs.Entity.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITecnologiaRepository extends JpaRepository<Tecnologia, Long> {
    
}
