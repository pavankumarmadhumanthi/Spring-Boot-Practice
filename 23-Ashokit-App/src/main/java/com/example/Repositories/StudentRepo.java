package com.example.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entites.Counselor;
import com.example.Entites.Student;


public interface StudentRepo extends JpaRepository<Student, Integer> {
   public  int countBySestatusAndSid(String status, Integer sid);
   public List<Student> findByCounselor(Counselor con);
}
