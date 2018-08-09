package com.apptozee.blogpages.repositories;

import com.apptozee.blogpages.models.BlogPage;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class BlogPagesDummyRepository implements BlogPagesRepository {

    private static int id;
    private List<BlogPage> inMemoryStore = new ArrayList<>();

    @Override
    public Optional<BlogPage> findById(Integer id) {
        return inMemoryStore.stream()
                .filter(page -> id.equals(page.getId()))
                .findFirst();
    }

    @Override
    public <S extends BlogPage> S insert(S s) {
        s.setId(id++);
        inMemoryStore.add(s);
        return s;
    }


}
