package com.bee.airsystem.bean;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/14 21:46
 */
public class UserTicket {
    private String userName;
    private String nickName;
    private String sex;
    private String workUnit;
    private String identityCard;
    private String email;
    private String phone;
    private int userStatus;
    private String departure;
    private String destination;
    private double price;
    private String startTime;
    private String arrivalTime;
    private int flightFlag;
    private String planeName;
    private int reserveId;

    public UserTicket(int reserveId) {
        this.reserveId = reserveId;
    }

    public UserTicket(String userName, String nickName, String sex, String workUnit, String identityCard, String email, String phone, int userStatus, String departure, String destination, double price, String startTime, String arrivalTime, int flightFlag, String planeName, int reserveId) {
        this.userName = userName;
        this.nickName = nickName;
        this.sex = sex;
        this.workUnit = workUnit;
        this.identityCard = identityCard;
        this.email = email;
        this.phone = phone;
        this.userStatus = userStatus;
        this.departure = departure;
        this.destination = destination;
        this.price = price;
        this.startTime = startTime;
        this.arrivalTime = arrivalTime;
        this.flightFlag = flightFlag;
        this.planeName = planeName;
        this.reserveId = reserveId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getFlightFlag() {
        return flightFlag;
    }

    public void setFlightFlag(int flightFlag) {
        this.flightFlag = flightFlag;
    }

    public String getPlaneName() {
        return planeName;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    public int getReserveId() {
        return reserveId;
    }

    public void setReserveId(int reserveId) {
        this.reserveId = reserveId;
    }

    @Override
    public String toString() {
        return "UserTicket{" +
                "userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex='" + sex + '\'' +
                ", workUnit='" + workUnit + '\'' +
                ", identityCard='" + identityCard + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", price='" + price + '\'' +
                ", startTime='" + startTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", flightFlag='" + flightFlag + '\'' +
                ", planeName='" + planeName + '\'' +
                '}';
    }
}
