package site.jaedoo.mygeorecord.mybatis.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import site.jaedoo.mygeorecord.mybatis.dto.datagroup.DataGroupFieldRecord;
import site.jaedoo.mygeorecord.mybatis.dto.datagroup.DataGroupInsert;
import site.jaedoo.mygeorecord.mybatis.dto.datagroup.DataGroupUpdate;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@MybatisTest
class DataGroupMapperTest {
    @Autowired DataGroupMapper dataGroupMapper;

    @Test
    @DisplayName("사용자가 식별자로 DataGroupFieldRecord를 잘 가져오는지 확인")
    void getUserDataGroupFieldRecordTest() {
        // given
        Long userId = 1L;

        // when
        List<DataGroupFieldRecord> result = dataGroupMapper.findAllDataGroupInfoByUserId(userId);

        // then
        assertThat(result).asList().isNotEmpty();
    }

    @Test
    @DisplayName("지도 식별자로 DataGroupFieldRecord를 잘 가져오는지 확인")
    void getDataGroupFieldRecordTest() {
        // given
        Long mapId = 1L;

        // when
        List<DataGroupFieldRecord> result = dataGroupMapper.findAllDataGroupInfoByGeoTableId(mapId);

        // then
        assertThat(result).asList().isNotEmpty();
    }
    
    @Test
    @DisplayName("DataGroup 생성 테스트")
    void insertTest() {
        // given
        DataGroupInsert insert = new DataGroupInsert(1L, 1L, "test");

        // when
        int modified = dataGroupMapper.insertDataGroup(insert);

        // then
        assertThat(modified).isGreaterThan(0);
    }
    
    @Test
    @DisplayName("DataGroup 갱신 테스트")
    void updateTest() {
        // given
        DataGroupUpdate dataGroupUpdate = new DataGroupUpdate(1L, "test");
        
        // when
        int modified = dataGroupMapper.updateDataGroup(dataGroupUpdate);

        // then
        assertThat(modified).isGreaterThan(0);
    }
}