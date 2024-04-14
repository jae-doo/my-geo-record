package site.jaedoo.mygeorecord.domain.repository;

import site.jaedoo.mygeorecord.domain.entity.Row;

import java.util.List;

public interface RowRepository {
    List<Row> findAllRow();
}
