package site.jaedoo.mygeorecord.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Builder @Getter
public class DataGroup {
    private Long id;
    private String name;
    private List<Column> columns;
    private List<Row> rows;
}
