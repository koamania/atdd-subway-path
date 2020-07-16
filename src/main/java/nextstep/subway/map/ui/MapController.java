package nextstep.subway.map.ui;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nextstep.subway.map.application.MapService;
import nextstep.subway.map.dto.MapResponse;

@RestController
@RequestMapping("/maps")
public class MapController {

    private final MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping
    public ResponseEntity<MapResponse> responseMap() {
        MapResponse response = mapService.responseMap();
        return ResponseEntity.ok().body(response);
    }
}
