package com.example.f1stats.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SessionResultsDTO {

    @JsonProperty("meeting_key")
    private Long meetingKey;

    @JsonProperty("session_key")
    private Long sessionKey;

    @JsonProperty("driver_number")
    private Integer driverNumber;

//    @JsonDeserialize(using = DurationDeserializer.class)
//    private List<Duration> duration;

    @JsonProperty("gap_to_leader")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<String> gapToLeader;

    @JsonProperty("number_of_laps")
    private Integer numberOfLaps;

    @JsonProperty("position")
    private Integer position;

    private DriverDTO driverInfo;

    public SessionResultsDTO(Long meetingKey,
                             Long sessionKey,
                             Integer driverNumber,
//                             List<Duration> duration,
                             List<String> gapToLeader,
                             Integer numberOfLaps,
                             Integer position,
                             DriverDTO driverInfo) {
        this.meetingKey = meetingKey;
        this.sessionKey = sessionKey;
        this.driverNumber = driverNumber;
//        this.duration = duration;
        this.gapToLeader = gapToLeader;
        this.numberOfLaps = numberOfLaps;
        this.position = position;
        this.driverInfo = driverInfo;
    }

    public Long getMeetingKey() {
        return meetingKey;
    }

    public Long getSessionKey() {
        return sessionKey;
    }

    public Integer getDriverNumber() {
        return driverNumber;
    }

//    public List<Duration> getDuration() {
//        return duration;
//    }

    public List<String> getGapToLeader() {
        return gapToLeader;
    }

    public Integer getNumberOfLaps() {
        return numberOfLaps;
    }

    public Integer getPosition() {
        return position;
    }

    public DriverDTO getDriverInfo() {
        return driverInfo;
    }
}
