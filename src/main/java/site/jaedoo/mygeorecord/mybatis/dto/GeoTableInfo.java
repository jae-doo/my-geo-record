package site.jaedoo.mygeorecord.mybatis.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GeoTableInfo {
    private Long id;
    private Long userId;
    private String name;

    public GeoTableInfo(Long userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}
