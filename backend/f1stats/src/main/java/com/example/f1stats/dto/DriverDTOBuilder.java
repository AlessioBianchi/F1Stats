package com.example.f1stats.dto;

public class DriverDTOBuilder {

    private Long meetingKey;
    private Long sessionKey;
    private Integer driverNumber;
    private String broadcastName;
    private String fullName;
    private String nameAcronym;
    private String teamName;
    private String teamColour;
    private String firstName;
    private String lastName;
    private String headshotUrl;
    private String countryCode;

    public DriverDTOBuilder withMeetingKey(Long meetingKey) {
        this.meetingKey = meetingKey;
        return this;
    }

    public DriverDTOBuilder withSessionKey(Long sessionKey) {
        this.sessionKey = sessionKey;
        return this;
    }

    public DriverDTOBuilder withDriverNumber(Integer driverNumber) {
        this.driverNumber = driverNumber;
        return this;
    }

    public DriverDTOBuilder withBroadcastName(String broadcastName) {
        this.broadcastName = broadcastName;
        return this;
    }

    public DriverDTOBuilder withFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public DriverDTOBuilder withNameAcronym(String nameAcronym) {
        this.nameAcronym = nameAcronym;
        return this;
    }

    public DriverDTOBuilder withTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public DriverDTOBuilder withTeamColour(String teamColour) {
        this.teamColour = teamColour;
        return this;
    }

    public DriverDTOBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public DriverDTOBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public DriverDTOBuilder withHeadshotUrl(String headshotUrl) {
        this.headshotUrl = headshotUrl;
        return this;
    }

    public DriverDTOBuilder withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public DriverDTO build() {
        return new DriverDTO(meetingKey,
                sessionKey,
                driverNumber,
                broadcastName,
                fullName,
                nameAcronym,
                teamName,
                teamColour,
                firstName,
                lastName,
                headshotUrl,
                countryCode);
    }
}
