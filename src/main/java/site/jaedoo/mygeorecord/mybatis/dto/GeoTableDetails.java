package site.jaedoo.mygeorecord.mybatis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GeoTableDetails {
    private Long id;
    private Long userId;
    private String name;

    public GeoTableDetails(Long userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}
