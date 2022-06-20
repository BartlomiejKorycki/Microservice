package com.FamilyApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Family {
    private String familyName;
    private int id;
    private int nrOfAdults;
    private int nrOfChildren;
    private int nrOfInfants;
    private List<FamilyMember> familyMembers;
}