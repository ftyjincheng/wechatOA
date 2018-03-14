package com.leyidai.web.service;

import com.leyidai.entity.RoomOrder;
import com.leyidai.web.mapper.RoomOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomOrderService {

    @Autowired
    RoomOrderMapper roomOrderMapper;

    /**
     * 获得所有会议室预约列表
     * @return
     */
    public List<RoomOrder> getAllRoomOrderList()
    {
        return roomOrderMapper.getListOrder();
    }

    /**
     * 按日期获得会议室预约列表
     * @param date
     * @param roomId
     * @return
     */
    public List<RoomOrder> getRoomOrderListByDateAndRoom(String date,int roomId)
    {
        return roomOrderMapper.getListOrderByDateAndRoom(date,roomId);
    }


    /**
     * 插入会议室预约记录
     * @param order 插入的roomOrder对象
     * @return  插入错误则返回<=0
     */
    public int insertRoomOrder(RoomOrder order){
        return roomOrderMapper.insertRoomOrder(order);
    }

}
