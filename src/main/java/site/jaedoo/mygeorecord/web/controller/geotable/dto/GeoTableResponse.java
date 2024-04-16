package site.jaedoo.mygeorecord.web.controller.geotable.dto;

import lombok.Data;
import site.jaedoo.mygeorecord.domain.entity.GeoTable;

@Data
public class GeoTableResponse {
    private Long id;
    private String name;

    public GeoTableResponse(GeoTable geoTable) {
        this.id = geoTable.getId();
        this.name = geoTable.getName();
    }
}
