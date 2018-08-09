package com.apptozee.blogpages.models;

import com.apptozee.blogpages.models.utils.FieldUpdater;
import com.apptozee.blogpages.models.utils.ObjectUpdater;
import com.apptozee.blogpages.models.utils.Updatable;
import com.apptozee.blogpages.models.utils.Updater;

import static com.apptozee.blogpages.models.utils.FieldSupplier.nullOrBuild;

public class Snipet implements Updatable<Snipet> {

    private String contentShort;
    private String contentLong;
    private Image  image;

    public String getContentShort() {
        return contentShort;
    }

    public void setContentShort(String contentShort) {
        this.contentShort = contentShort;
    }

    public String getContentLong() {
        return contentLong;
    }

    public void setContentLong(String contentLong) {
        this.contentLong = contentLong;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public Updater getUpdater(Snipet other) {
        ObjectUpdater objectUpdater = new ObjectUpdater();
        objectUpdater.add(FieldUpdater.of(this::setContentLong,other::getContentLong));
        objectUpdater.add(FieldUpdater.of(this::setContentShort,other::getContentShort));
        objectUpdater.add(ObjectUpdater.from(other.getImage(),nullOrBuild(this::getImage, this::setImage, Image::new)));
        return objectUpdater;
    }
}
