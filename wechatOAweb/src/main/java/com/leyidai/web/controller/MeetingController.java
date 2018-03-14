package com.leyidai.web.controller;

import com.leyidai.entity.MeetingRoom;
import com.leyidai.entity.RoomOrder;
import com.leyidai.entity.vo.UserInfo;
import com.leyidai.web.service.MeetingService;
import com.leyidai.web.service.RoomOrderService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 会议室管理
 */

@Controller
public class MeetingController {

    @Autowired
    MeetingService meetingService;
    @Autowired
    RoomOrderService roomOrderService;
    private static Logger log = org.slf4j.LoggerFactory
            .getLogger(MeetingController.class);

    /**
     * 加载会议预约页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/meetingRoom/loadOrderPage")
    public String loadOrderPage(Model model, HttpServletRequest request) {
        UserInfo userInfo = new UserInfo();
        if (null != request.getSession().getAttribute("user")) {
            userInfo = (UserInfo) request.getSession().getAttribute("user");
        }
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("listRoom", meetingService.getListRoom());
        return "book";
    }

    /**
     * 预约会议室提交
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/meetingRoom/OrderSubmit")
    public String orderSubmit(Model model, RoomOrder order) {
        log.info(String.valueOf(order.getRoomId()));
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        int insertResult = roomOrderService.insertRoomOrder(order);
        if (insertResult <= 0) {
            rtnMap.put("rtnCode", "9");
            rtnMap.put("rtnMsg", "插入失败");
            return "redirect:/meetingRoom/loadOrderPage";
        }
        else {
            rtnMap.put("rtnCode", "0");
            return "myOrder";
        }

    }

    /**
     * 查看已预定的会议室
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/meetingRoom/OrderedRoom")
    public String OrderedRoom(Model model) {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> arrDays = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            arrDays.add(sdf.format(calendar.getTime()));
            if (arrDays.size() == 8) {
                break;
            }
        }
        model.addAttribute("arrDays", arrDays);
        model.addAttribute("arrOrderHtml", buildHtml(arrDays.get(0)).toString());
        return "orderedRoom";
    }


    /**
     * 查看我的预约
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/meetingRoom/myOrder")
    public String myOrder(Model model) {

        model.addAttribute("arrOrder", roomOrderService.getAllRoomOrderList());
        return "myOrder";
    }


    private StringBuilder buildHtml(String date) {
        StringBuilder htmlRoom = new StringBuilder();
        //循环查找对应的预约条目
        for (MeetingRoom item : meetingService.getListRoom()) {
            List<RoomOrder> orderList = roomOrderService.getRoomOrderListByDateAndRoom(date, item.getMeetingRoomId());
            log.info(String.valueOf(item.getMeetingRoomId()));
            htmlRoom.append("<div class='bgWhite' id='room" + item.getMeetingRoomId() + "' style='margin: 10px 15px;'><div class='container'>" +
                    "<img src='/resources/img/room" + item.getMeetingRoomId() + ".gif' alt='' class='img-responsive' style='margin-top: 6px;'></div>" +
                    "<div class='' style='padding:10px;min-height: 50px;'>");
            int i = 1;
            if (orderList.size() <= 0) {
                htmlRoom.append("<div class='' style='padding:10px;min-height: 50px;'>" +
                        "<div class='left timeSection section1' style=''>暂无</div></div>");
            } else {
                for (RoomOrder order : orderList) {
                    htmlRoom.append("<div class='left timeSection section" + i + "' style=''>" + order.getStartTime()
                            + "-" + order.getEndTime() + "</div>");
                    if (i % 3 == 0 && i != orderList.size()) {
                        htmlRoom.append("</div><div class='' style='padding:10px;min-height: 50px;'>");
                    }
                    i++;
                }
            }
            htmlRoom.append("</div></div>");
        }
        return htmlRoom;
    }

    @ResponseBody
    @RequestMapping(value = "/meetingRoom/selectDate")
    public String selectDate(String date) {
        return buildHtml(date).toString();
    }

}
