package com.leyidai.web.mapper;


import com.leyidai.entity.MeetingRoom;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MeetingRoomMapper {
    /**
     *
     * @return  返回所有的会议室列表
     */
    @Select("select * from T_MeetingRoom where roomStatus!=1")
    public List<MeetingRoom> getListRoom();



}
