package com.zensar.olxapplication.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.zensar.olxapplication.User;

@Repository
public interface olxLoginRepository extends JpaRepository<User, Integer>{

}
