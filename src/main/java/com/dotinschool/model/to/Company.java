package com.dotinschool.model.to;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Maral Khojasteh
 */
@Entity
@Table(name="company")
@PrimaryKeyJoinColumn(name="customer_id")
public class Company extends Customer {

    private String companyName;
    private Date registrationDate;
    private String economicCode;


    @NotNull
    @NotBlank
    public String getName() {
        return companyName;
    }

    public void setName(String companyName) {
        this.companyName = companyName;
    }

    @NotNull
    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @NotNull
    @NotBlank
    public String getEconomicCode() {
        return economicCode;
    }

    public void setEconomicCode(String economicCode) {
        this.economicCode = economicCode;
    }

}
