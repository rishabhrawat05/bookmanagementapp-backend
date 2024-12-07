package com.mangement.bookmanagement.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mangement.bookmanagement.entities.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String>{

}
