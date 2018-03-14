package com.leyidai.entity;

public class RoomOrder {
    public int getRoomOrderId() {
        return roomOrderId;
    }

    public void setRoomOrderId(int roomOrderId) {
        this.roomOrderId = roomOrderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private int roomOrderId;
    private String date;
    private String startTime;
    private String endTime;
    private int userId;


    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    private int roomId;

}
