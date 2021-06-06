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
    public Object getAll(HttpServletRequest request, HttpServletResponse response){
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
        json.put("bill",bill);
        return json;
    }
}
