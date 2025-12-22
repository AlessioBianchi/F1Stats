package com.example.f1stats.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class SessionDTO {

    @JsonProperty("meeting_key")
    private Long meetingKey;

    @JsonProperty("session_key")
    private Long sessionKey;

    @JsonProperty("location")
    private String location;

    @JsonProperty("date_start")
    private Date dateStart;

    @JsonProperty("date_end")
    private Date dateEnd;

    @JsonProperty("session_type")
    private String sessionType;

    @JsonProperty("session_name")
    private String sessionName;

    @JsonProperty("country_key")
    private Integer countryKey;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("country_name")
    private String countryName;

    @JsonProperty("circuit_key")
    private Integer circuitKey;

    @JsonProperty("circuit_short_name")
    private String circuitShortName;

    @JsonProperty("gmt_offset")
    private String gmtOffset;

    @JsonProperty("year")
    private Integer year;

    public SessionDTO(Long meetingKey,
                      Long sessionKey,
                      String location,
                      Date dateStart,
                      Date dateEnd,
                      String sessionType,
                      String sessionName,
                      Integer countryKey,
                      String countryCode,
                      String countryName,
                      Integer circuitKey,
                      String circuitShortName,
                      String gmtOffset,
                      Integer year) {
        this.meetingKey = meetingKey;
        this.sessionKey = sessionKey;
        this.location = location;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.sessionType = sessionType;
        this.sessionName = sessionName;
        this.countryKey = countryKey;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.circuitKey = circuitKey;
        this.circuitShortName = circuitShortName;
        this.gmtOffset = gmtOffset;
        this.year = year;
    }

    public Long getMeetingKey() {
        return meetingKey;
    }

    public Long getSessionKey() {
        return sessionKey;
    }

    public String getLocation() {
        return location;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public String getSessionType() {
        return sessionType;
    }

    public String getSessionName() {
        return sessionName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public int getCountryKey() {
        return countryKey;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getCircuitKey() {
        return circuitKey;
    }

    public String getCircuitShortName() {
        return circuitShortName;
    }

    public String getGmtOffset() {
        return gmtOffset;
    }

    public int getYear() {
        return year;
    }
}
