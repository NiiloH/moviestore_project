package com.example.palvelinprojekti.domain;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findByAuthor(@Param("author")String author);
}
