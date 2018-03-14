package com.leyidai.web.service;

import com.leyidai.entity.MeetingRoom;
import com.leyidai.web.mapper.MeetingRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService {

    @Autowired
    MeetingRoomMapper meetingRoomMapper;

    /**
     * 获取会议室列表
     * @return
     */
    public List<MeetingRoom> getListRoom() {
        return meetingRoomMapper.getListRoom();
    }
}
