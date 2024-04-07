package site.jaedoo.mygeorecord.domain.entity;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Column {
    private String name;
    private DataType type;
}
