package nextstep.subway.line.dto;

import com.google.common.collect.Lists;
import nextstep.subway.line.domain.Line;
import nextstep.subway.station.dto.StationResponse;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class LineResponse {
    private Long id;
    private String name;
    private String color;
    private LocalTime startTime;
    private LocalTime endTime;
    private int intervalTime;
    private List<LineStationResponse> stations;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public LineResponse() {
    }

    public LineResponse(Long id, String name, String color, LocalTime startTime, LocalTime endTime, int intervalTime, List<LineStationResponse> stations, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.startTime = startTime;
        this.endTime = endTime;
        this.intervalTime = intervalTime;
        this.stations = stations;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public static LineResponse of(Line line, List<LineStationResponse> stations) {
        return new LineResponse(line.getId(), line.getName(), line.getColor(), line.getStartTime(), line.getEndTime(), line.getIntervalTime(), stations, line.getCreatedDate(), line.getModifiedDate());
    }

    public static LineResponse of(Line line) {
        List<LineStationResponse> lineStationResponses = LineStationResponse.from(line.getLineStationsInOrder());
        return of(line, lineStationResponses);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getIntervalTime() {
        return intervalTime;
    }

    public List<LineStationResponse> getStations() {
        return stations;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public List<StationResponse> getAllStation() {
        return this.getStations().stream()
                .map(LineStationResponse::getStation)
                .distinct()
                .collect(Collectors.toList());
    }
}
