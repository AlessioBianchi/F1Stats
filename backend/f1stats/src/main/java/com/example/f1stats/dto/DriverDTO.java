package com.example.f1stats.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DriverDTO {

    @JsonProperty("meeting_key")
    private Long meetingKey;

    @JsonProperty("session_key")
    private Long sessionKey;

    @JsonProperty("driver_number")
    private Integer driverNumber;

    @JsonProperty("broadcast_name")
    private String broadcastName;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("name_acronym")
    private String nameAcronym;

    @JsonProperty("team_name")
    private String teamName;

    @JsonProperty("team_colour")
    private String teamColour;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("headshot_url")
    private String headshotUrl;

    @JsonProperty("country_code")
    private String countryCode;

    public DriverDTO(Long meetingKey,
                     Long sessionKey,
                     Integer driverNumber,
                     String broadcastName,
                     String fullName,
                     String nameAcronym,
                     String teamName,
                     String teamColour,
                     String firstName,
                     String lastName,
                     String headshotUrl,
                     String countryCode) {
        this.meetingKey = meetingKey;
        this.sessionKey = sessionKey;
        this.driverNumber = driverNumber;
        this.broadcastName = broadcastName;
        this.fullName = fullName;
        this.nameAcronym = nameAcronym;
        this.teamName = teamName;
        this.teamColour = teamColour;
        this.firstName = firstName;
        this.lastName = lastName;
        this.headshotUrl = headshotUrl;
        this.countryCode = countryCode;
    }

    public Long getMeetingKey() {
        return meetingKey;
    }

    public Long getSessionKey() {
        return sessionKey;
    }

    public int getDriverNumber() {
        return driverNumber;
    }

    public String getBroadcastName() {
        return broadcastName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getNameAcronym() {
        return nameAcronym;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamColour() {
        return teamColour;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getHeadshotUrl() {
        return headshotUrl;
    }
}
