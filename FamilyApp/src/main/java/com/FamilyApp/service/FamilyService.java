package com.FamilyApp.service;

import com.FamilyApp.entity.Family;
import com.FamilyApp.entity.FamilyMember;
import com.FamilyApp.exception.InvalidInputException;
import com.FamilyApp.exception.WrongFamilyIdException;
import com.FamilyApp.repository.FamilyRepository;
import com.FamilyApp.validator.FamilyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FamilyService {

    @Autowired
    private FamilyRepository familyRepository;
    @Autowired
    private FamilyValidator familyValidator;
    @Value("${url.familyMemberAPI}")
    private String familyMemberAPI;

    private final RestTemplate restTemplate = new RestTemplate();

    public int addFamily(Family family) throws InvalidInputException {
        if (familyValidator.validateNrOfMembers(family)) {
            int familyId = familyRepository.save(family);

            List<FamilyMember> familyMembers = family.getFamilyMembers();
            familyMembers.forEach(familyMember -> familyMember.setFamilyId(familyId));
            restTemplate.postForLocation(familyMemberAPI, familyMembers);
            return familyId;
        } else {
            throw new InvalidInputException();
        }
    }

    public Family getFamilyById(int id) throws WrongFamilyIdException {
        ResponseEntity<List<FamilyMember>> responseEntity =
                restTemplate.exchange(familyMemberAPI + id, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<FamilyMember>>() {
                        });
        List<FamilyMember> members = responseEntity.getBody();
        if (members.isEmpty()) {
            throw new WrongFamilyIdException();
        } else {
            Family selectedFamily = familyRepository.getById(id);
            selectedFamily.setFamilyMembers(members);
            return selectedFamily;
        }
    }
}