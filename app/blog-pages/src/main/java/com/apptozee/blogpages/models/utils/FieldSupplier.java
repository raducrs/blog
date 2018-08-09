package com.apptozee.blogpages.models.utils;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class FieldSupplier {


    public static <T extends Updatable<T>>  Supplier<T> nullOrBuild(Supplier<T> fieldGetter, Consumer<T> fieldSetter, Supplier<T> fieldConstructor){
        return () -> {
            if (fieldGetter.get() == null) {
                fieldSetter.accept(fieldConstructor.get());
            }
            return fieldGetter.get();
        };
    }



}
