package com.example.demo1;

import java.time.LocalDate;

public class User {
    String name;
    LocalDate date;
    String sport;
    Integer number;
    public String getSport() {
        return sport;}
    public void setSport(String sport) {
        this.sport = sport;}
    public User(String name, LocalDate date, String sport, Integer number) {
        this.name = name;
        this.date = date;
        this.sport = sport;
        this.number = number;}

    public String getName() {
        return name;}
    public void setName(String name) {
        this.name = name;}

    public LocalDate getDate() {
        return date;}

    public void setDate(LocalDate date) {
        this.date = date;}
    public Integer getNumber() {
        return number;}

    public void setNumber(Integer number) {
        this.number = number;}


}
