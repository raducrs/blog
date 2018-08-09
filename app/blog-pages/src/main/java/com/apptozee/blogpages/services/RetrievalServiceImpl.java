package com.apptozee.blogpages.services;

import com.apptozee.blogpages.models.BlogPage;
import com.apptozee.blogpages.repositories.BlogPagesMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RetrievalServiceImpl implements RetrievalService{


    @Autowired
    private BlogPagesMongoRepository blogPageRepo;

    @Override
    public BlogPage getBlogPageById(int id) {
        Optional<BlogPage> blogPageOptional = blogPageRepo.findById(id);
        if (!blogPageOptional.isPresent()){
            // log
            throw new ResourceNotFoundException();
        }

        return blogPageOptional.get();
    }

    @Override
    public BlogPage addBlogPage(BlogPage blogPage) {
        return blogPageRepo.insert(blogPage);
    }

    @Override
    public Page<BlogPage> retrievePage(PageRequest pageRequest) {
        return blogPageRepo.findAll(pageRequest);
    }

    @Override
    public BlogPage updateBlogPage(BlogPage blogPage) {
        BlogPage old = blogPageRepo.findById(blogPage.getId()).orElseGet(BlogPage::new);
        // in case we retrieved a new page
        old.setId(blogPage.getId());
        // update
        old.update(blogPage);
        blogPageRepo.save(old);
        return old;
    }

    @Override
    public void deleteBlogPage(int pageId) {
        if (!blogPageRepo.existsById(pageId)){
            throw new ResourceNotFoundException();
        }
        blogPageRepo.deleteById(pageId);
    }
}
