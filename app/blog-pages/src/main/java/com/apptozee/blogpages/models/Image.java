package com.apptozee.blogpages.models;


import com.apptozee.blogpages.models.utils.FieldUpdater;
import com.apptozee.blogpages.models.utils.ObjectUpdater;
import com.apptozee.blogpages.models.utils.Updatable;
import com.apptozee.blogpages.models.utils.Updater;

import java.awt.*;

import static com.apptozee.blogpages.models.utils.FieldSupplier.nullOrBuild;

public class Image implements Updatable<Image> {

    public static class Dimension implements Updatable<Dimension> {
        private Integer width;
        private Integer height;

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        @Override
        public Updater getUpdater(Dimension other) {
            return ObjectUpdater.of(FieldUpdater.of(this::setHeight,other::getHeight),
                    FieldUpdater.of(this::setWidth, other::getWidth));
        }
    }

    private String url;
    private Dimension nativeResolution;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Dimension getNativeResolution() {
        return nativeResolution;
    }

    public void setNativeResolution(Dimension nativeResolution) {
        this.nativeResolution = nativeResolution;
    }

    @Override
    public Updater getUpdater(Image other) {
        return ObjectUpdater.of(FieldUpdater.of(this::setUrl,other::getUrl))
                .add(ObjectUpdater.from(other.getNativeResolution(), nullOrBuild(this::getNativeResolution, this::setNativeResolution, Dimension::new)));
    }
}
