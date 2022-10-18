package com.srjons.filters.handler;

import com.srjons.filters.entities.Country;
import com.srjons.filters.repo.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryHandler {

    @Autowired
    private CountryRepo countryRepo;

    @GetMapping
    public List<Country> findAll() {
        return countryRepo.findAll();
    }

    @PostMapping
    public String add(@RequestBody Country country) {
        countryRepo.save(country);
        return "added";
    }

    @GetMapping("/{id}")
    public Country findById(@PathVariable("id") int id) {
        return countryRepo.findById(id).get();
    }
}
