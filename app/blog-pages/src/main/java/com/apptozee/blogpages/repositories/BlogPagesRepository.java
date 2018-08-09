package com.apptozee.blogpages.repositories;

import com.apptozee.blogpages.models.BlogPage;

import java.util.Optional;

public interface BlogPagesRepository {

    Optional<BlogPage> findById(Integer id);

    <S extends BlogPage> S insert(S s);
}
