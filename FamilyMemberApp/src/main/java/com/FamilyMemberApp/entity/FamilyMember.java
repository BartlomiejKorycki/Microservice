package com.FamilyMemberApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FamilyMember {
    private int familyId;
    private String familyName;
    private String givenName;
    private int age;
    private int id;
}
