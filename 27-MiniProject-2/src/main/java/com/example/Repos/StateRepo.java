package com.example.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entities.State;

public interface StateRepo extends JpaRepository<State,Integer>{

	List<State> findByCid(Integer cid);

}
