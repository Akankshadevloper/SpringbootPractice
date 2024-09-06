package com.akanksha.cruddemo.dao;

import com.akanksha.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);
}
