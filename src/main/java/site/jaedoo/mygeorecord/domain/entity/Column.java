package site.jaedoo.mygeorecord.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public class Column {
    private String name;
    private DataType type;
}
