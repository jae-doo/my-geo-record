package site.jaedoo.mygeorecord.domain.entity;

import lombok.ToString;

import java.util.List;

@ToString
public class DataGroup {
    private Long id;
    private String name;
    private List<Column> columns;
    private List<Record> records;
}
