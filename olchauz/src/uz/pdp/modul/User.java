package uz.pdp.modul;

import uz.pdp.service.BaseService;

public class User extends Base {
    private String surName;
    private String telNumber;
    private String password;
    private String role;
    private int age;
    private String cardNumber;
    private double amount;

    public User() {
    }

    public User(String name, String surName, String telNumber, String password, String role) {

        this.name = name;
        this.surName = surName;
        this.telNumber = telNumber;
        this.password = password;
        this.role = role;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", age=" + age +
                ", cardNumber='" + cardNumber + '\'' +
                ", amount=" + amount +
                '}';
    }
    public String toStringForOrder() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telNumber='" + telNumber + '\'' +
                '}';
    }
}