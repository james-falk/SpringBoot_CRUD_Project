package com.example.demo.controller;


import com.example.demo.entity.Part;
import com.example.demo.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController  // Used to create Restful Controllers
public class PartController {

    private final PartService partService;

    @Autowired
    public PartController(@Qualifier("partServiceIMPL")PartService partService) {
        this.partService = partService;
    }

    //Get  Request that will read a list of all the parts
    //http://localhost:8080/retrieveAllParts
    @GetMapping("/retrieveAllParts")
    public List<Part> findAll() {
        return partService.findAll();
    }

    //Get Request to read a single part by id
    @GetMapping("/retrievePart/{partId}")
    public Part findById(@PathVariable int partId) {
        return partService.findByID(partId);
    }

    //Post Request to add a new part
    //http://localhost:8080/addPart
    @PostMapping("/addPart")
    public Part addPart(@RequestBody Part thePart) {
        //Just in case an id is passed set the Id to 0
        // This is to force a save of a new item.... not an update
        thePart.setId(0);

        // Call partDAOIMPL.save method to save the new part
        partService.saveOrUpdate(thePart);
        return thePart;
    }

    //Put Request to update an existing part
    //http://localhost:8080/updatePart
    @PutMapping("/updatePart")
    public Part updatePart(@RequestBody Part updatePart) {
        partService.saveOrUpdate(updatePart);
        return updatePart;
    }

    // Delete request to delete an existing part
    //http://localhost:8080/deletePart/1
    @DeleteMapping("/deletePart/{partId}")
    public String deletePart(@PathVariable int partId) {
        //Executes deleteById method
        partService.deleteById(partId);
        return "Deleted part id : " + partId;
    }

}

