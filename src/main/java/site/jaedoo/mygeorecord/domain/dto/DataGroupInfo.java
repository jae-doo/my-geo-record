package site.jaedoo.mygeorecord.domain.dto;

import site.jaedoo.mygeorecord.domain.entity.Column;

import java.util.Collections;
import java.util.List;

/**
 * 데이터 그룹 사용을 위해 외부에 제공되는 정보
 *
 * @param mapId       지도의 식별자
 * @param dataGroupId 데이터 그룹의 식별자
 * @param groupName   데이터 그룹의 이름
 * @param columnList  데이터 그룹의 컬럼 목록
 */
public record DataGroupInfo(
        Long mapId,
        Long dataGroupId,
        String groupName,
        List<Column> columnList
) {}
