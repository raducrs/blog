package com.apptozee.blogpages.models.utils;

public interface Updatable<T> {

    Updater getUpdater(T other);

    default void update(T other){
        getUpdater(other).update();
    }

}
