package com.dotinschool.model.to;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by Maral ito on 4/30/2015.
 */
@Entity
@Table(name="grant_condition")
public class GrantCondition {

    private Long id;
    private String name;
    private Integer minimumDays;
    private Integer maximumDays;
    private Double minimumAmount;
    private Double maximumAmount;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @NotBlank
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public Integer getMinimumDays() {
        return minimumDays;
    }

    public void setMinimumDays(Integer minimumDays) {
        this.minimumDays = minimumDays;
    }

    @NotNull
    public Integer getMaximumDays() {
        return maximumDays;
    }

    public void setMaximumDays(Integer maximumDays) {
        this.maximumDays = maximumDays;
    }

    @NotNull
    public Double getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(Double minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    @NotNull
    public Double getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(Double maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

}
