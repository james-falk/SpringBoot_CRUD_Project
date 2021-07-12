package com.example.demo.dao;

import com.example.demo.entity.Part;

import java.util.List;

public interface PartDAO {
    List<Part> findAll();
    Part findById(int Id);
    void saveOrUpdate(Part thePart);
    void deleteById(int Id);
}
