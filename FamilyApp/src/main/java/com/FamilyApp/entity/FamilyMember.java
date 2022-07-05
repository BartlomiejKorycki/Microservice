package com.FamilyApp.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "familymember")
@AllArgsConstructor
@NoArgsConstructor
public class FamilyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int familyId;
    private String familyName;
    private String givenName;
    private int age;
}