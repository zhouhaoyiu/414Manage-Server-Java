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

        List<Bill> bill = billMapper.selectBill();
        JSONObject json = new JSONObject();
        json.put("bill", bill);
        return json;
    }

    @GetMapping("setBill")
    public Object setBill(HttpServletRequest request, HttpServletResponse response) {
        String event = request.getParameter("event");
        Integer amount = new Integer(request.getParameter("amount"));
        Integer amountCode = new Integer(request.getParameter("amountCode"));
        String eventDate = request.getParameter("eventDate");
        Integer submitterId = new Integer(request.getParameter("submitterId"));
        String submitterTrueName = request.getParameter("submitterTrueName");
        String submitterUserName = request.getParameter("submitterUserName");

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
    @GetMapping("getBillsByDate")
    public Object getBillsByDate(HttpServletRequest request, HttpServletResponse response) {

        String eventDate = request.getParameter("eventDate");
        System.out.println(eventDate);
        List<Bill> bill = billMapper.selectBillByDate(eventDate);
        JSONObject json = new JSONObject();
        json.put("bill", bill);
        return json;
    }

}

