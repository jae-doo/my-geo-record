package site.jaedoo.mygeorecord.web.controller.geotable;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.jaedoo.mygeorecord.domain.entity.GeoTable;
import site.jaedoo.mygeorecord.domain.service.GeoTableService;
import site.jaedoo.mygeorecord.web.constant.SessionConst;
import site.jaedoo.mygeorecord.web.controller.geotable.dto.GeoTableForm;
import site.jaedoo.mygeorecord.web.controller.geotable.dto.GeoTableResponse;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/map")
public class MapController {
    private final GeoTableService geoTableService;

    @GetMapping
    public ResponseEntity<List<GeoTableResponse>> findMapByUserId(@SessionAttribute(SessionConst.USER) Long id) {
        List<GeoTableResponse> geoTableResponseList = geoTableService.findUserMaps(id)
                .stream().map(GeoTableResponse::new)
                .toList();
        return ResponseEntity.ok(geoTableResponseList);
    }

    @PostMapping
    public ResponseEntity<GeoTableResponse> registerMap(
            @SessionAttribute(SessionConst.USER) Long id, @RequestBody GeoTableForm geoTableForm) {
        GeoTable geoTable = geoTableService.registerGeoTable(id, geoTableForm.getName());
        return ResponseEntity.ok(new GeoTableResponse(geoTable));
    }
}
