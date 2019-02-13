package com.codingdojo.event.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.event.models.Message;
@Repository
public interface MessageRepository extends CrudRepository<Message,Long>{
List<Message> findAll();
}
