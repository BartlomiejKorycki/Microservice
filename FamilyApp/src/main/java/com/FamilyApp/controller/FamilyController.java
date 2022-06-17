package com.FamilyApp.controller;

import com.FamilyApp.entity.Family;
import com.FamilyApp.exception.InvalidInputException;
import com.FamilyApp.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/family")
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @GetMapping("/{id}")
    public Family getFamily(@PathVariable("id") int id) {
      return familyService.getFamilyById(id);
    }

    @PostMapping("/")
    public int createFamily(@RequestBody Family family) throws InvalidInputException {
        return familyService.addFamily(family);
    }
}