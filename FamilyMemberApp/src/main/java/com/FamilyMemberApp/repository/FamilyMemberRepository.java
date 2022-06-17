package com.FamilyMemberApp.repository;

import com.FamilyMemberApp.entity.FamilyMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FamilyMemberRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    Logger logger = LoggerFactory.getLogger(FamilyMemberRepository.class);

    public List<FamilyMember> getAllByFamilyId(int familyId) {
        List<FamilyMember> familyMembers = jdbcTemplate.query("SELECT * FROM familyMember WHERE familyId = ?",
                BeanPropertyRowMapper.newInstance(FamilyMember.class), familyId);
        logger.info(String.valueOf(familyId + " FamilyId: " + familyMembers));
        return familyMembers;
    }

    public String save(List<FamilyMember> familyMembers) {
        familyMembers.forEach(familyMember -> jdbcTemplate.update(
                "INSERT INTO familyMember(familyId, familyName, givenName, age) VALUES(?, ?, ?, ?)",
                familyMember.getFamilyId(), familyMember.getFamilyName(), familyMember.getGivenName(), familyMember.getAge()
        ));
        logger.info("Saved in FamilyMemberDB: " + familyMembers);
        return "Family member added";
    }
}