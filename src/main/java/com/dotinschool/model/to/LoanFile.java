package com.dotinschool.model.to;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Maral Khojasteh
 */
@Entity
@Table(name = "loan_file")
public class LoanFile {

    private Long id;
    private Double amount;
    private Integer duration;
    private LoanType loanType;
    private Person person;

    @NotNull
    @OneToOne
    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @NotNull
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @NotNull
    @OneToOne
    @JoinColumn(name="person_id")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
