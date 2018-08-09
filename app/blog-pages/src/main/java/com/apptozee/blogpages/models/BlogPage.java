package com.apptozee.blogpages.models;

import com.apptozee.blogpages.models.utils.FieldUpdater;
import com.apptozee.blogpages.models.utils.ObjectUpdater;
import com.apptozee.blogpages.models.utils.Updatable;
import com.apptozee.blogpages.models.utils.Updater;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.apptozee.blogpages.models.utils.FieldSupplier.nullOrBuild;

@Document
public class BlogPage implements Updatable<BlogPage> {
    @Id
    private Integer id;

    @Version
    private Long version;

    @LastModifiedDate
    private LocalDateTime date;

    private String title;

    private String content;

    private Snipet snipet;

    private Author author;

    private PageStatus pageStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Snipet getSnipet() {
        return snipet;
    }

    public void setSnipet(Snipet snipet) {
        this.snipet = snipet;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public PageStatus getPageStatus() {
        return pageStatus;
    }

    public void setPageStatus(PageStatus pageStatus) {
        this.pageStatus = pageStatus;
    }


    @Override
    public Updater getUpdater(BlogPage other) {
        ObjectUpdater objectUpdater = new ObjectUpdater();
        objectUpdater.add(FieldUpdater.of(this::setTitle,other::getTitle));
        objectUpdater.add(FieldUpdater.of(this::setPageStatus,other::getPageStatus));
        objectUpdater.add(FieldUpdater.of(this::setVersion,other::getVersion));
        objectUpdater.add(FieldUpdater.of(this::setDate,other::getDate));
        objectUpdater.add(ObjectUpdater.from(other.getAuthor(), nullOrBuild(this::getAuthor,this::setAuthor,Author::new)));
        objectUpdater.add(ObjectUpdater.from(other.getSnipet(), nullOrBuild(this::getSnipet,this::setSnipet,Snipet::new)));


        return objectUpdater;
    }


}
