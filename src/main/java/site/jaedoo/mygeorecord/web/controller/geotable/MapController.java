package site.jaedoo.mygeorecord.web.controller.geotable;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.jaedoo.mygeorecord.domain.dto.DataGroupCreation;
import site.jaedoo.mygeorecord.domain.dto.DataGroupInfo;
import site.jaedoo.mygeorecord.domain.entity.Column;
import site.jaedoo.mygeorecord.domain.entity.GeoTable;
import site.jaedoo.mygeorecord.domain.service.DataGroupService;
import site.jaedoo.mygeorecord.domain.service.GeoTableService;
import site.jaedoo.mygeorecord.web.constant.SessionConst;
import site.jaedoo.mygeorecord.web.controller.geotable.dto.DataGroupFieldForm;
import site.jaedoo.mygeorecord.web.controller.geotable.dto.DataGroupForm;
import site.jaedoo.mygeorecord.web.controller.geotable.dto.GeoTableForm;
import site.jaedoo.mygeorecord.web.controller.geotable.dto.GeoTableResponse;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/map")
public class MapController {
    private final GeoTableService geoTableService;
    private final DataGroupService dataGroupService;

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
        GeoTable geoTable = geoTableService.registerGeoTable(id, geoTableForm.name());
        return ResponseEntity.ok(new GeoTableResponse(geoTable));
    }


    @PutMapping("/{id}")
    public ResponseEntity<GeoTableResponse> updateMap(
            @SessionAttribute(SessionConst.USER) Long userId,
            @PathVariable("id") Long geoTableId,
            @RequestBody GeoTableForm geoTableForm) {
        GeoTable geoTable = geoTableService.updateGeoTable(geoTableId, userId, geoTableForm.name());
        return ResponseEntity.ok(new GeoTableResponse(geoTable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMap(
            @SessionAttribute(SessionConst.USER) Long userId,
            @PathVariable("id") Long geoTableId) {
        boolean success = geoTableService.deleteGeoTable(geoTableId, userId);

        if (success)
            return new ResponseEntity<>(HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}/data-group")
    public ResponseEntity<List<DataGroupInfo>> findAllDataGroup(
            @SessionAttribute(SessionConst.USER) Long userId, @PathVariable("id") Long geoTableId) {
        List<DataGroupInfo> dataGroupInfos = dataGroupService.searchGeoTableDataGroups(userId, geoTableId);
        return ResponseEntity.ok(dataGroupInfos);
    }

    @PostMapping("/{id}/data-group")
    public ResponseEntity<List<DataGroupInfo>> registerDataGroup(
            @SessionAttribute(SessionConst.USER) Long userId, @PathVariable("id") Long geoTableId,
            @RequestBody DataGroupForm dataGroupForm) {

        String dataGroupName = dataGroupForm.name();
        List<Column> columnList = dataGroupForm.fieldInfoList().stream()
                .map(DataGroupFieldForm::toColumn)
                .toList();

        DataGroupCreation dataGroupCreation = new DataGroupCreation(userId, geoTableId, dataGroupName, columnList);
        List<DataGroupInfo> dataGroupInfos = dataGroupService.createDataGroup(dataGroupCreation);
        return ResponseEntity.ok(dataGroupInfos);
    }
}
