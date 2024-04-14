package site.jaedoo.mygeorecord.domain.entity;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Field<T> {
    private T value;
}
