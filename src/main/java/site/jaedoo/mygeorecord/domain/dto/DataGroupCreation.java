package site.jaedoo.mygeorecord.domain.dto;

import site.jaedoo.mygeorecord.domain.entity.Column;

import java.util.List;

/**
 * DataGroup의 생성에 필요한 정보를 정의
 * @param userId 생성하는 사용자의 식별자
 * @param mapId DataGroup이 속하게 되는 지도의 식별자
 * @param dataGroupName 생성되는 DataGroup의 이름
 * @param columnList DataGroup의 컬럼 리스트
 */
public record DataGroupCreation(
        Long userId,
        Long mapId,
        String dataGroupName,
        List<Column> columnList
) {
}
