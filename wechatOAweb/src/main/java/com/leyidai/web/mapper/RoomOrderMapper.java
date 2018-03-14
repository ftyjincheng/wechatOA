package com.leyidai.web.mapper;

import com.leyidai.entity.MeetingRoom;
import com.leyidai.entity.RoomOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;


import java.util.List;

public interface RoomOrderMapper {

    /**
     * @return 返回所有的会议室预约列表
     */
    @Select("select * from T_RoomOrder order by roomOrderId desc")
    public List<RoomOrder> getListOrder();

    /**
     * 按日期获取room预约
     *
     * @param date
     * @return
     */
    @Select("select * from T_RoomOrder where date=#{date} and roomId=#{roomId}")
    public List<RoomOrder> getListOrderByDateAndRoom(@Param("date") String date, @Param("roomId") int roomId);

    @Insert("insert into T_RoomOrder (date,startTime,endTime,userId,roomId) values (#{date}," +
            "#{startTime},#{endTime},#{userId},#{roomId})")
    @SelectKey(statement = "SELECT last_insert_id() as roomOrderId", keyProperty = "roomOrderId",
            before = false, resultType = Integer.class)
    public int insertRoomOrder(RoomOrder roomOrder);
}
