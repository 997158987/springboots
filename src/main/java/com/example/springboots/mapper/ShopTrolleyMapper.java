package com.example.springboots.mapper;

import com.example.springboots.model.ShopTrolley;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ShopTrolleyMapper {
    @Delete({
        "delete from shop_trolley",
        "where shop_trolleyId = #{shopTrolleyid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer shopTrolleyid);

    @Insert({
        "insert into shop_trolley (shop_trolleyId, book_name, ",
        "book_price, book_num, ",
        "trolley_user, trolley_book)",
        "values (#{shopTrolleyid,jdbcType=INTEGER}, #{bookName,jdbcType=VARCHAR}, ",
        "#{bookPrice,jdbcType=VARCHAR}, #{bookNum,jdbcType=VARCHAR}, ",
        "#{trolleyUser,jdbcType=INTEGER}, #{trolleyBook,jdbcType=INTEGER})"
    })
    int insert(ShopTrolley record);

    @Select({
        "select",
        "shop_trolleyId, book_name, book_price, book_num, trolley_user, trolley_book",
        "from shop_trolley",
        "where shop_trolleyId = #{shopTrolleyid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="shop_trolleyId", property="shopTrolleyid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="book_name", property="bookName", jdbcType=JdbcType.VARCHAR),
        @Result(column="book_price", property="bookPrice", jdbcType=JdbcType.VARCHAR),
        @Result(column="book_num", property="bookNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="trolley_user", property="trolleyUser", jdbcType=JdbcType.INTEGER),
        @Result(column="trolley_book", property="trolleyBook", jdbcType=JdbcType.INTEGER)
    })
    ShopTrolley selectByPrimaryKey(Integer shopTrolleyid);

    @Select({
        "select",
        "shop_trolleyId, book_name, book_price, book_num, trolley_user, trolley_book",
        "from shop_trolley"
    })
    @Results({
        @Result(column="shop_trolleyId", property="shopTrolleyid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="book_name", property="bookName", jdbcType=JdbcType.VARCHAR),
        @Result(column="book_price", property="bookPrice", jdbcType=JdbcType.VARCHAR),
        @Result(column="book_num", property="bookNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="trolley_user", property="trolleyUser", jdbcType=JdbcType.INTEGER),
        @Result(column="trolley_book", property="trolleyBook", jdbcType=JdbcType.INTEGER)
    })
    List<ShopTrolley> selectAll();

    @Update({
        "update shop_trolley",
        "set book_name = #{bookName,jdbcType=VARCHAR},",
          "book_price = #{bookPrice,jdbcType=VARCHAR},",
          "book_num = #{bookNum,jdbcType=VARCHAR},",
          "trolley_user = #{trolleyUser,jdbcType=INTEGER},",
          "trolley_book = #{trolleyBook,jdbcType=INTEGER}",
        "where shop_trolleyId = #{shopTrolleyid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ShopTrolley record);
}