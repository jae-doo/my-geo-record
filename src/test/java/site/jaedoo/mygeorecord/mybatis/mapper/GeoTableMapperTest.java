package site.jaedoo.mygeorecord.mybatis.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import site.jaedoo.mygeorecord.mybatis.dto.geotable.GeoTableRecord;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@MybatisTest
class GeoTableMapperTest {
    @Autowired GeoTableMapper geoTableMapper;
    @Autowired UserMapper userMapper;

    @Test
    @DisplayName("GeoTable의 아이디가 제대로 생성되는지 확인")
    void generatedKeyTest() {
        // given
        GeoTableRecord geoTableDetails = new GeoTableRecord(1L, "test");

        // when
        int modified = geoTableMapper.insertGeoTable(geoTableDetails);

        // then
        assertThat(modified).isEqualTo(1);
        assertThat(geoTableDetails.getId()).isNotNull();
        System.out.println(geoTableDetails.getId());
    }
}