package com.leyidai.entity;

public class MeetingRoom {
    public int getMeetingRoomId() {
        return meetingRoomId;
    }

    public void setMeetingRoomId(int meetingRoomId) {
        this.meetingRoomId = meetingRoomId;
    }

    private int meetingRoomId;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    private String roomName;


    public int getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(int roomStatus) {
        this.roomStatus = roomStatus;
    }

    private int roomStatus;

}
