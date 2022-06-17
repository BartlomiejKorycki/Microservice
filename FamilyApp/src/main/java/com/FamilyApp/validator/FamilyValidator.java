package com.FamilyApp.validator;

import com.FamilyApp.entity.Family;
import com.FamilyApp.entity.FamilyMember;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FamilyValidator {

    public int validateNrOfMembers(Family family) {
        List<FamilyMember> familyMembers = family.getFamilyMembers();
        int infants = family.getNrOfInfants();
        int children = family.getNrOfChildren();
        int adults = family.getNrOfAdults();

        for (FamilyMember member : familyMembers) {
            if (member.getAge() <= 4) infants--;
            if (member.getAge() > 4 && member.getAge() <= 16) children--;
            if (member.getAge() > 16) adults--;
        }

        int sum = infants + children + adults;
        if (sum == 0) return 1;
        else return 0;
    }
}
