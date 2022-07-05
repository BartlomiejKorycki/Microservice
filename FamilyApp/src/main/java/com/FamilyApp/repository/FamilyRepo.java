package com.FamilyApp.repository;

import com.FamilyApp.entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepo extends JpaRepository<Family, Long> {
}