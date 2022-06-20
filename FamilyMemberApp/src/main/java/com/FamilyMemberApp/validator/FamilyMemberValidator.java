package com.FamilyMemberApp.validator;

import com.FamilyMemberApp.entity.FamilyMember;
import com.FamilyMemberApp.exception.MembersWithoutFamillyIdException;
import com.FamilyMemberApp.repository.FamilyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FamilyMemberValidator {

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    public void FamilyIdValidator(List<FamilyMember> familyMembers) throws MembersWithoutFamillyIdException {
        FamilyMember familyMember = familyMembers.get(0);
        if (familyMember.getFamilyId() != 0) {
            familyMemberRepository.save(familyMembers);
        } else {
            throw new MembersWithoutFamillyIdException();
        }
    }
}