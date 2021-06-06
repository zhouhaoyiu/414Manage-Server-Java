package com.n6414.manage.mapper;

import com.n6414.manage.domain.Bill;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillMapper {
    @Select("select * from bill")
    public List<Bill> selectBill();

}
