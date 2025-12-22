package com.example.f1stats.dto;

import java.util.Date;

public class SessionDTOBuilder {

    private Long meetingKey;
    private Long sessionKey;
    private String location;
    private Date dateStart;
    private Date dateEnd;
    private String sessionType;
    private String sessionName;
    private Integer countryKey;
    private String countryCode;
    private String countryName;
    private Integer circuitKey;
    private String circuitShortName;
    private String gmtOffset;
    private Integer year;

    public SessionDTOBuilder withMeetingKey(Long meetingKey) {
        this.meetingKey = meetingKey;
        return this;
    }

    public SessionDTOBuilder withSessionKey(Long sessionKey) {
        this.sessionKey = sessionKey;
        return this;
    }

    public SessionDTOBuilder withLocation(String location) {
        this.location = location;
        return this;
    }

    public SessionDTOBuilder withDateStart(Date dateStart) {
        this.dateStart = dateStart;
        return this;
    }

    public SessionDTOBuilder withDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }

    public SessionDTOBuilder withSessionType(String sessionType) {
        this.sessionType = sessionType;
        return this;
    }

    public SessionDTOBuilder withSessionName(String sessionName) {
        this.sessionName = sessionName;
        return this;
    }

    public SessionDTOBuilder withCountryKey(Integer countryKey) {
        this.countryKey = countryKey;
        return this;
    }

    public SessionDTOBuilder withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public SessionDTOBuilder withCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public SessionDTOBuilder withCircuitKey(Integer circuitKey) {
        this.circuitKey = circuitKey;
        return this;
    }

    public SessionDTOBuilder withCircuitShortName(String circuitShortName) {
        this.circuitShortName = circuitShortName;
        return this;
    }

    public SessionDTOBuilder withGmtOffset(String gmtOffset) {
        this.gmtOffset = gmtOffset;
        return this;
    }

    public SessionDTOBuilder withYear(Integer year) {
        this.year = year;
        return this;
    }

    public SessionDTO build() {
        return new SessionDTO(meetingKey,
                sessionKey,
                location,
                dateStart,
                dateEnd,
                sessionType,
                sessionName,
                countryKey,
                countryCode,
                countryName,
                circuitKey,
                circuitShortName,
                gmtOffset,
                year);
    }
}
