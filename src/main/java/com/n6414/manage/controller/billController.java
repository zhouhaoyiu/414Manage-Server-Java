package com.n6414.manage.controller;

import com.n6414.manage.domain.Bill;
import com.n6414.manage.mapper.BillMapper;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RequestMapping("bill")
@RestController
public class billController {
    @Autowired
    private BillMapper billMapper;

    @GetMapping("getAllBills")
    public Object getAll(HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=UTF-8");
        response.addHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        List<Bill> bill = billMapper.selectBill();
        JSONObject json = new JSONObject();
        json.put("bill", bill);
        return json;
    }

    @GetMapping("setBill")
    public Object setBill(HttpServletRequest request, HttpServletResponse response) {
        String event = request.getParameter("event");
        System.out.println(event);
        Integer amount = new Integer(request.getParameter("amount"));
        System.out.println(amount);
        Integer amountCode = new Integer(request.getParameter("amountCode"));
        System.out.println(amountCode);
        String eventDate = request.getParameter("eventDate");
        System.out.println(eventDate);
        Integer submitterId = new Integer(request.getParameter("submitterId"));
        System.out.println(submitterId);
        String submitterTrueName = request.getParameter("submitterTrueName");
        System.out.println(submitterTrueName);
        String submitterUserName = request.getParameter("submitterUserName");
        System.out.println(submitterUserName);
        response.addHeader("Access-Control-Allow-Origin", "*");
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=UTF-8");
        response.addHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");

        int resultCount = billMapper.saveBill(event, amount, amountCode, eventDate, submitterId, submitterTrueName, submitterUserName);
        JSONObject json = new JSONObject();
        if (resultCount == 0) {
            json.put("code", "10011");
            json.put("message", "failed");
            return json;
        }
        json.put("code", "10010");
        json.put("message", "success");
        return json;
    }
}

