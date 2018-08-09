package com.apptozee.blogpages.models;

import com.apptozee.blogpages.models.utils.FieldUpdater;
import com.apptozee.blogpages.models.utils.Updatable;
import com.apptozee.blogpages.models.utils.Updater;

public class Author implements Updatable<Author> {

    private Integer idAuthor;

    @Override
    public Updater getUpdater(Author other) {
        return FieldUpdater.of(this::setIdAuthor,other::getIdAuthor);
    }

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }
}
