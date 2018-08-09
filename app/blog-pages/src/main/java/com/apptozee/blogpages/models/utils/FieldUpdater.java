package com.apptozee.blogpages.models.utils;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FieldUpdater<T> implements Updater{

    private Consumer<T> fieldSetter;
    private Supplier<T> fieldGetter;
    private Predicate<T> updateCondition = Objects::nonNull;

    private FieldUpdater(Consumer<T> fieldSetter, Supplier<T> fieldGetter) {
        this.fieldSetter = fieldSetter;
        this.fieldGetter = fieldGetter;
    }

    private FieldUpdater(Consumer<T> fieldSetter, Supplier<T> fieldGetter, Predicate<T> updateCondition) {
        this.fieldSetter = fieldSetter;
        this.fieldGetter = fieldGetter;
        this.updateCondition = updateCondition;
    }


    @Override
    public void update() {
        T field = fieldGetter.get();
        if (updateCondition.test(field)){
            fieldSetter.accept(field);
        }
    }

    public static <T> FieldUpdater<T> of(Consumer<T> fieldSetter, Supplier<T> fieldGetter){
        return new FieldUpdater<>(fieldSetter,fieldGetter);
    }

    public static <T> FieldUpdater<T> of(Consumer<T> fieldSetter, Supplier<T> fieldGetter, Predicate<T> updateCondition){
        return new FieldUpdater<>(fieldSetter,fieldGetter, updateCondition);
    }

}
