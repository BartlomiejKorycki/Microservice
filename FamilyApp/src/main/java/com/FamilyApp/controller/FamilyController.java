package com.FamilyApp.controller;

import com.FamilyApp.entity.Family;
import com.FamilyApp.exception.InvalidInputException;
import com.FamilyApp.exception.WrongFamilyIdException;
import com.FamilyApp.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/family")
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @GetMapping("/{id}")
    public ResponseEntity<Family> getFamily(@PathVariable("id") int id) throws WrongFamilyIdException {
      return ResponseEntity.ok().body(familyService.getFamilyById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Integer> createFamily(@RequestBody Family family) throws InvalidInputException {
        return ResponseEntity.ok().body(familyService.addFamily(family));
    }
}