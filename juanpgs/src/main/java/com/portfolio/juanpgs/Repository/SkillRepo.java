package com.portfolio.juanpgs.Repository;

import com.portfolio.juanpgs.Entity.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepo extends JpaRepository<Skill, Integer> {

    public Optional<Skill> findByNombreSkill(String nombreSkill);

    public boolean existsByNombreSkill(String nombreSkill);
}
