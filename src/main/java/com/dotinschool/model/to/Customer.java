package com.dotinschool.model.to;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Maral Khojasteh
 */
@Entity
@Table(name="customer")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Customer {

    private Long id;

    private String customerNumber;

    @NotNull
    @NotBlank
    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String code) {
        this.customerNumber = code;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
