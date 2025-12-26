package com.example.f1stats.dto;

import java.util.List;

public class SessionResultsDTOBuilder {

    private Long meetingKey;
    private Long sessionKey;
    private Integer driverNumber;
//    private List<Duration> duration;
    private List<String> gapToLeader;
    private Integer numberOfLaps;
    private Integer position;
    private DriverDTO driverInfo;

    public SessionResultsDTOBuilder(SessionResultsDTO sessionResults) {
        this.meetingKey = sessionResults.getMeetingKey();
        this.sessionKey = sessionResults.getSessionKey();
        this.driverNumber = sessionResults.getDriverNumber();
//        this.duration = sessionResults.getDuration();
        this.gapToLeader = sessionResults.getGapToLeader();
        this.numberOfLaps = sessionResults.getNumberOfLaps();
        this.position = sessionResults.getPosition();
        this.driverInfo = sessionResults.getDriverInfo();
    }

    public SessionResultsDTOBuilder withMeetingKey(Long meetingKey) {
        this.meetingKey = meetingKey;
        return this;
    }

    public SessionResultsDTOBuilder withSessionKey(Long sessionKey) {
        this.sessionKey = sessionKey;
        return this;
    }

    public SessionResultsDTOBuilder withDriverNumber(Integer driverNumber) {
        this.driverNumber = driverNumber;
        return this;
    }

//    public SessionResultsDTOBuilder withDuration(List<Duration> duration) {
//        this.duration = duration;
//        return this;
//    }

    public SessionResultsDTOBuilder withGapToLeader(List<String> gapToLeader) {
        this.gapToLeader = gapToLeader;
        return this;
    }

    public SessionResultsDTOBuilder withPosition(Integer position) {
        this.position = position;
        return this;
    }

    public SessionResultsDTOBuilder withDriverInfo(DriverDTO driverInfo) {
        this.driverInfo = driverInfo;
        return this;
    }

    public SessionResultsDTO build() {
        return new SessionResultsDTO(meetingKey,
                sessionKey,
                driverNumber,
//                duration,
                gapToLeader,
                numberOfLaps,
                position,
                driverInfo);
    }

}
