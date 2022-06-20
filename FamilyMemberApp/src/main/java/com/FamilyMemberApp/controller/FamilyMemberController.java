package com.FamilyMemberApp.controller;

import com.FamilyMemberApp.entity.FamilyMember;
import com.FamilyMemberApp.exception.MembersWithoutFamillyIdException;
import com.FamilyMemberApp.repository.FamilyMemberRepository;
import com.FamilyMemberApp.validator.FamilyMemberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/familyMembers")
public class FamilyMemberController {
    @Autowired
    private FamilyMemberRepository familyMemberRepository;
    @Autowired
    private FamilyMemberValidator familyMemberValidator;

    @GetMapping("/{id}")
    public List<FamilyMember> searchFamilyMemberById(@PathVariable("id") int id) {
        return familyMemberRepository.getAllByFamilyId(id);
    }

    @PostMapping("/")
    public void createFamilyMember(@RequestBody List<FamilyMember> familyMembers) throws MembersWithoutFamillyIdException {
        familyMemberValidator.FamilyIdValidator(familyMembers);
    }
}