package com.w2m.superheros.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class SuperheroDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("alias")
    private String alias;

    @JsonProperty("powers")
    private List<String> powers;

    @JsonProperty("created-at")
    private LocalDate createdAt;

    @JsonProperty("last-modification")
    private LocalDate lastModification;

    @JsonProperty("height")
    private Double height;

    @JsonProperty("weight")
    private Double weight;

    @JsonProperty("team")
    private String team;

    @JsonProperty("publisher")
    private String publisher;

    @JsonProperty("is-villain")
    private boolean isVillain;

    @JsonProperty("main-weapon")
    private String mainWeapon;

    public SuperheroDto() {}

    public SuperheroDto(Long id, String name, String alias, List<String> powers, LocalDate createdAt, LocalDate lastModification, Double height, Double weight, String team, String publisher, boolean isVillain, String mainWeapon) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.powers = powers;
        this.createdAt = createdAt;
        this.lastModification = lastModification;
        this.height = height;
        this.weight = weight;
        this.team = team;
        this.publisher = publisher;
        this.isVillain = isVillain;
        this.mainWeapon = mainWeapon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<String> getPowers() {
        return powers;
    }

    public void setPowers(List<String> powers) {
        this.powers = powers;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getLastModification() {
        return lastModification;
    }

    public void setLastModification(LocalDate lastModification) {
        this.lastModification = lastModification;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public boolean isVillain() {
        return isVillain;
    }

    public void setVillain(boolean villain) {
        isVillain = villain;
    }

    public String getMainWeapon() {
        return mainWeapon;
    }

    public void setMainWeapon(String mainWeapon) {
        this.mainWeapon = mainWeapon;
    }
}
