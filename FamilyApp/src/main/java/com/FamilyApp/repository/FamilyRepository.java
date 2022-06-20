package com.FamilyApp.repository;

import com.FamilyApp.entity.Family;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FamilyRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Family> getAll() {
        return jdbcTemplate.query("SELECT * FROM family", BeanPropertyRowMapper.newInstance(Family.class));
    }

    public Family getById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT id, familyName, nrOfAdults, nrOfChildren, nrOfInfants FROM family WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Family.class), id);
    }

    public int save(Family family) {
        jdbcTemplate.update("INSERT INTO family(familyName, nrOfAdults, nrOfChildren, nrOfInfants) VALUES(?, ?, ?, ?)",
                family.getFamilyName(), family.getNrOfAdults(), family.getNrOfChildren(),
                family.getNrOfInfants());
        return getAll().size();
    }
}