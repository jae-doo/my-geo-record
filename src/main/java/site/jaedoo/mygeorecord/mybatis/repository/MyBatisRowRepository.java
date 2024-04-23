package site.jaedoo.mygeorecord.mybatis.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import site.jaedoo.mygeorecord.domain.entity.Field;
import site.jaedoo.mygeorecord.domain.entity.Row;
import site.jaedoo.mygeorecord.domain.repository.RowRepository;
import site.jaedoo.mygeorecord.mybatis.dto.all.RowData;
import site.jaedoo.mygeorecord.mybatis.mapper.RowDataMapper;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

@Repository("rowRepository")
@RequiredArgsConstructor
public class MyBatisRowRepository implements RowRepository {
    private final RowDataMapper rowDataMapper;

    @Override
    public List<Row> findAllRow() {
        List<RowData<Integer>> numberRowData = rowDataMapper.findAllNumberRowData();
        List<RowData<String>> stringRowData = rowDataMapper.findAllStringRowData();

        Map<Long, List<RowData>> groupByRowId = Stream.of(numberRowData, stringRowData)
                .flatMap(List::stream)
                .collect(groupingBy(RowData::getRowId));

        return groupByRowId.values().stream()
                .map(this::mapToRow)
                .toList();
    }

    private Row mapToRow(List<RowData> sameRowIdData) {
        Map<String, Field> fields = sameRowIdData.stream()
                .collect(toMap(RowData::getFieldName, RowData::getField));

        return Row.builder()
                .latitude(sameRowIdData.get(0).getLatitude())
                .longitude(sameRowIdData.get(0).getLongitude())
                .data(fields).build();
    }
}
