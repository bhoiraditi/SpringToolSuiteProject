package com.Restaurant_Managment.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Restaurant_Managment.entities.Tablee;

public interface TableDao extends JpaRepository<Tablee, String> {

}
