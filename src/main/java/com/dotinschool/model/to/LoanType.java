package com.dotinschool.model.to;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Maral ito on 4/30/2015.
 */

@Entity
@Table(name="loan_type")
public class LoanType {

    private Long id;
    private String name;
    private Double interestRate;
    private Set<GrantCondition> conditions;

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
    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    @OneToMany
    @JoinColumn(name="loanType_id")
    @NotNull
    public Set<GrantCondition> getConditions() {
        return conditions;
    }

    public void setConditions(Set<GrantCondition> conditions) {
        this.conditions = conditions;
    }

//    @Override
//    public String toString() {
//        return "LoanType (name = " + name + ")";
//    }
}

