package com.FamilyMemberApp.repository;

import com.FamilyMemberApp.entity.FamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyMemberRepo extends JpaRepository<FamilyMember, Long> {
}