package com.example.springboots.mapper;

import com.example.springboots.model.Order;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface OrderMapper {
    @Delete({
        "delete from order",
        "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer orderId);

    @Insert({
        "insert into order (order_id, book_name, ",
        "book_price, book_num, ",
        "order_time, total, ",
        "order_state, order_user)",
        "values (#{orderId,jdbcType=INTEGER}, #{bookName,jdbcType=VARCHAR}, ",
        "#{bookPrice,jdbcType=VARCHAR}, #{bookNum,jdbcType=VARCHAR}, ",
        "#{orderTime,jdbcType=TIMESTAMP}, #{total,jdbcType=VARCHAR}, ",
        "#{orderState,jdbcType=INTEGER}, #{orderUser,jdbcType=INTEGER})"
    })
    int insert(Order record);

    @Select({
        "select",
        "order_id, book_name, book_price, book_num, order_time, total, order_state, order_user",
        "from order",
        "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="book_name", property="bookName", jdbcType=JdbcType.VARCHAR),
        @Result(column="book_price", property="bookPrice", jdbcType=JdbcType.VARCHAR),
        @Result(column="book_num", property="bookNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_time", property="orderTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="total", property="total", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_state", property="orderState", jdbcType=JdbcType.INTEGER),
        @Result(column="order_user", property="orderUser", jdbcType=JdbcType.INTEGER)
    })
    Order selectByPrimaryKey(Integer orderId);

    @Select({
        "select",
        "order_id, book_name, book_price, book_num, order_time, total, order_state, order_user",
        "from order"
    })
    @Results({
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="book_name", property="bookName", jdbcType=JdbcType.VARCHAR),
        @Result(column="book_price", property="bookPrice", jdbcType=JdbcType.VARCHAR),
        @Result(column="book_num", property="bookNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_time", property="orderTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="total", property="total", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_state", property="orderState", jdbcType=JdbcType.INTEGER),
        @Result(column="order_user", property="orderUser", jdbcType=JdbcType.INTEGER)
    })
    List<Order> selectAll();

    @Update({
        "update order",
        "set book_name = #{bookName,jdbcType=VARCHAR},",
          "book_price = #{bookPrice,jdbcType=VARCHAR},",
          "book_num = #{bookNum,jdbcType=VARCHAR},",
          "order_time = #{orderTime,jdbcType=TIMESTAMP},",
          "total = #{total,jdbcType=VARCHAR},",
          "order_state = #{orderState,jdbcType=INTEGER},",
          "order_user = #{orderUser,jdbcType=INTEGER}",
        "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Order record);
}