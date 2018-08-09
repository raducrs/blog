package com.apptozee.blogpages.repositories;

import com.apptozee.blogpages.models.BlogPage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BlogPagesMongoRepository extends BlogPagesRepository,MongoRepository<BlogPage,Integer> {

    Optional<BlogPage> findById(Integer id);

    <S extends BlogPage> S insert(S s);


}


