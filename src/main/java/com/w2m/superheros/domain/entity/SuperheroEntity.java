package com.w2m.superheros.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "SUPERHERO")
public class SuperheroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE")
    private String name;

    @Column(name = "ALIAS")
    private String alias;

    @Column(name = "PODER")
    private List<String> powers;

    @Column(name = "FECHA_CREACION")
    private LocalDate createdAt;

    @Column(name = "ULTIMA_MODIFICACION")
    private LocalDate lastModification;

    @Column(name = "ALTURA")
    private Double height;

    @Column(name = "PESO")
    private Double weight;

    @Column(name = "EQUIPO")
    private String team;

    @Column(name = "EDITORIAL")
    private String publisher;

    @Column(name = "ES_VILLANO")
    private boolean isVillain;

    @Column(name = "ARMA_PRINCIPAL")
    private String mainWeapon;

    public SuperheroEntity() {
    }

    public SuperheroEntity(Long id, String name, String alias, List<String> powers, LocalDate createdAt, LocalDate lastModification, Double height, Double weight, String team, String publisher, boolean isVillain, String mainWeapon) {
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
