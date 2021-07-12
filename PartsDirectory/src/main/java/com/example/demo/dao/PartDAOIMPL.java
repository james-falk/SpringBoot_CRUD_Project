package com.example.demo.dao;


import com.example.demo.entity.Part;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PartDAOIMPL implements PartDAO{

    // Define field for Entity manager

    private final EntityManager entityManager;

    // Set up constructor injection
    @Autowired
    public PartDAOIMPL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional // Defines the scope of a single database transaction
    public List<Part> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query myQuery = currentSession.createQuery("from Part");
        return myQuery.getResultList();
    }

    @Override
    @Transactional
    public Part findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Part.class, theId);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Part thePart) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(thePart);
    }

    @Override
    @Transactional // Defines the scope of a single database transaction
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Part myPart = currentSession.get(Part.class, theId);
        currentSession.delete(myPart);
    }
}
