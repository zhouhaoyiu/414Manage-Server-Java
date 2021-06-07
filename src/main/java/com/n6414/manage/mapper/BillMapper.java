package com.n6414.manage.mapper;

import com.n6414.manage.domain.Bill;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillMapper {
    @Insert("INSERT into bill(event,amount,amountCode,eventDate,submitterId,submitterTrueName,submitterUserName) VALUES(#{event},#{amount},#{amountCode},#{eventDate},#{submitterId},#{submitterTrueName},#{submitterUserName})")
   int saveBill(@Param("event") String event,@Param("amount") Integer amount,@Param("amountCode") Integer amountCode,@Param("eventDate") String eventDate, @Param("submitterId") Integer submitterId, @Param("submitterTrueName") String submitterTrueName,@Param("submitterUserName") String submitterUserName);

//   @Insert("INSERT into bill(event,amount,amountCode,eventDate,submitterId,submitterTrueName,submitterUserName) VALUES(#{event},#{amount},#{amountCode},#{eventDate},#{submitterId},#{submitterTrueName})")
//     int saveBill(@Param("event") String event,@Param("amount") Integer amount,@Param("amountCode") Integer amountCode,@Param("eventDate") String eventDate, @Param("submitterId") Integer submitterId, @Param("submitterTrueName") String submitterTrueName);
    @Select("select * from bill")
    List<Bill> selectBill();

}
