package site.jaedoo.mygeorecord.domain.entity;

public interface Field<T> {
    T getValue();
    void setValue(T value);
}
