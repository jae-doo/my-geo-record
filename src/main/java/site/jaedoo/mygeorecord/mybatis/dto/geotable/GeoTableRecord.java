package site.jaedoo.mygeorecord.mybatis.dto.geotable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GeoTableRecord {
    private Long id;
    private Long userId;
    private String name;

    public GeoTableRecord(Long userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}
