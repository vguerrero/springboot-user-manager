package com.user.manager.UserManager.model;

import jakarta.persistence.*;

@Entity
@Table(name="phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    private int number;

    private String contrycode;

    private String citycode;

    public Phone(User user, int number, String countryCode, String cityCode) {
        this.user = user;
        this.number = number;
        this.contrycode = countryCode;
        this.citycode = cityCode;
    }

    public Phone() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getContrycode() {
        return contrycode;
    }

    public void setContrycode(String contrycode) {
        this.contrycode = contrycode;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number=" + number +
                ", countryCode=" + contrycode +
                ", cityCode=" + citycode +
                '}';
    }
}
