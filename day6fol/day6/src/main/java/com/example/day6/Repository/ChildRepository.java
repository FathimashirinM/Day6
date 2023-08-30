package com.example.day6.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day6.Entity.Child;

public interface ChildRepository extends JpaRepository<Child, Integer> {

}