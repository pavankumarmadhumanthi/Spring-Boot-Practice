package com.example.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entites.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>{

}
