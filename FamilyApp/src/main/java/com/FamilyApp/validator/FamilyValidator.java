package com.FamilyApp.validator;

import com.FamilyApp.entity.Family;
import com.FamilyApp.entity.FamilyMember;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FamilyValidator {

    private boolean validateInfants(int infantsNumber, List<FamilyMember> familyMembers) {
        return familyMembers.stream()
                .filter(familyMember -> familyMember.getAge() <= 4)
                .count() == infantsNumber;
    }

    private boolean validateChildren(int childrenNumber, List<FamilyMember> familyMembers) {
        return familyMembers.stream()
                .filter(familyMember -> familyMember.getAge() > 4 && familyMember.getAge() <= 16)
                .count() == childrenNumber;
    }

    private boolean validateAdults(int adultsNumber, List<FamilyMember> familyMembers) {
        return familyMembers.stream()
                .filter(familyMember -> familyMember.getAge() > 16)
                .count() == adultsNumber;
    }

    public boolean validateNrOfMembers(Family family) {
        List<FamilyMember> familyMembers = family.getFamilyMembers();
        int infants = family.getNrOfInfants();
        int children = family.getNrOfChildren();
        int adults = family.getNrOfAdults();

        return validateInfants(infants, familyMembers) &&
                validateChildren(children, familyMembers) &&
                validateAdults(adults, familyMembers);
    }
}