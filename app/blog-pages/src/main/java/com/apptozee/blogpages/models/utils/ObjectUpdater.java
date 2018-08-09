package com.apptozee.blogpages.models.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ObjectUpdater implements Updater{

    private List<Updater> components = new ArrayList<>();
    private Updatable<?> source;

    public ObjectUpdater add(Updater fieldUpdater){
        if (fieldUpdater != null) {
            components.add(fieldUpdater);
        }
        return this;
    }


    @Override
    public void update() {
        components.forEach(Updater::update);
    }

    public static ObjectUpdater of(FieldUpdater<?> ... fieldUpdaters){
        ObjectUpdater objectUpdater = new ObjectUpdater();
        Arrays.stream(fieldUpdaters).forEach(objectUpdater::add);
        return objectUpdater;
    }

    public static <T extends Updatable<T>> Updater from(T sourceObject, Supplier<T> updateObject){
        if (sourceObject == null){
            return new ObjectUpdater();
        }

        return updateObject.get().getUpdater(sourceObject);
    }
}
