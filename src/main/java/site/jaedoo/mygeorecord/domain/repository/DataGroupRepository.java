package site.jaedoo.mygeorecord.domain.repository;

import site.jaedoo.mygeorecord.domain.entity.DataGroup;

import java.util.List;

public interface DataGroupRepository {
    List<DataGroup> findAllDataGroup();
}
