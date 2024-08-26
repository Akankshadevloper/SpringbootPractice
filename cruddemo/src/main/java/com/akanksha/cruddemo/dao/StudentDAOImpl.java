package com.akanksha.cruddemo.dao;

import com.akanksha.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{


    //define field fot entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);

    }

    @Override
    public Student findById(Integer id) {

        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by lastName  desc", Student.class);

        //return query
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);

    }

    @Override
    @Transactional
    public void delete(Integer id) {

        //retrieve the student
        Student theStudent = entityManager.find(Student.class,id);

        //delete the student
        entityManager.remove(theStudent);

    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRowDeleted = entityManager.createQuery("Delete from Student").executeUpdate();
        return numRowDeleted;
    }

}
















