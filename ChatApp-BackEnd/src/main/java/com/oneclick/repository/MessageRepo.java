package com.oneclick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oneclick.entity.Message;

@Repository
public interface MessageRepo extends JpaRepository<Message, Integer>{

}
