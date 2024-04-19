package site.jaedoo.mygeorecord.web.controller.geotable.dto;

import lombok.Data;
import site.jaedoo.mygeorecord.domain.entity.GeoTable;

public record GeoTableResponse (Long id, String name) {
    public GeoTableResponse(GeoTable geoTable) {
        this(geoTable.getId(), geoTable.getName());
    }
}