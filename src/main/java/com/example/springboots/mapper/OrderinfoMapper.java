package com.example.springboots.mapper;

import com.example.springboots.model.Orderinfo;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface OrderinfoMapper {
    @Insert({
        "insert into orderinfo (orderbook, ordernum, ",
        "orderprice, ordertime, ",
        "orderaddress, orderId)",
        "values (#{orderbook,jdbcType=VARCHAR}, #{ordernum,jdbcType=VARCHAR}, ",
        "#{orderprice,jdbcType=VARCHAR}, #{ordertime,jdbcType=TIMESTAMP}, ",
        "#{orderaddress,jdbcType=INTEGER}, #{orderid,jdbcType=INTEGER})"
    })
    int insert(Orderinfo record);

    @Select({
        "select",
        "orderbook, ordernum, orderprice, ordertime, orderaddress, orderId",
        "from orderinfo"
    })
    @Results({
        @Result(column="orderbook", property="orderbook", jdbcType=JdbcType.VARCHAR),
        @Result(column="ordernum", property="ordernum", jdbcType=JdbcType.VARCHAR),
        @Result(column="orderprice", property="orderprice", jdbcType=JdbcType.VARCHAR),
        @Result(column="ordertime", property="ordertime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="orderaddress", property="orderaddress", jdbcType=JdbcType.INTEGER),
        @Result(column="orderId", property="orderid", jdbcType=JdbcType.INTEGER)
    })
    List<Orderinfo> selectAll();
}