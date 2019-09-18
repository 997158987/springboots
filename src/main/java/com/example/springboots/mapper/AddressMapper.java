package com.example.springboots.mapper;

import com.example.springboots.model.Address;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface AddressMapper {
    @Delete({
        "delete from address",
        "where address_id = #{addressId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer addressId);

    @Insert({
        "insert into address (address_id, reciver, ",
        "reciver_phone, address, ",
        "reciver_name, address_user, ",
        "address_order)",
        "values (#{addressId,jdbcType=INTEGER}, #{reciver,jdbcType=VARCHAR}, ",
        "#{reciverPhone,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{reciverName,jdbcType=VARCHAR}, #{addressUser,jdbcType=INTEGER}, ",
        "#{addressOrder,jdbcType=INTEGER})"
    })
    int insert(Address record);

    @Select({
        "select",
        "address_id, reciver, reciver_phone, address, reciver_name, address_user, address_order",
        "from address",
        "where address_id = #{addressId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="address_id", property="addressId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="reciver", property="reciver", jdbcType=JdbcType.VARCHAR),
        @Result(column="reciver_phone", property="reciverPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="reciver_name", property="reciverName", jdbcType=JdbcType.VARCHAR),
        @Result(column="address_user", property="addressUser", jdbcType=JdbcType.INTEGER),
        @Result(column="address_order", property="addressOrder", jdbcType=JdbcType.INTEGER)
    })
    Address selectByPrimaryKey(Integer addressId);

    @Select({
        "select",
        "address_id, reciver, reciver_phone, address, reciver_name, address_user, address_order",
        "from address"
    })
    @Results({
        @Result(column="address_id", property="addressId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="reciver", property="reciver", jdbcType=JdbcType.VARCHAR),
        @Result(column="reciver_phone", property="reciverPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="reciver_name", property="reciverName", jdbcType=JdbcType.VARCHAR),
        @Result(column="address_user", property="addressUser", jdbcType=JdbcType.INTEGER),
        @Result(column="address_order", property="addressOrder", jdbcType=JdbcType.INTEGER)
    })
    List<Address> selectAll();

    @Update({
        "update address",
        "set reciver = #{reciver,jdbcType=VARCHAR},",
          "reciver_phone = #{reciverPhone,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "reciver_name = #{reciverName,jdbcType=VARCHAR},",
          "address_user = #{addressUser,jdbcType=INTEGER},",
          "address_order = #{addressOrder,jdbcType=INTEGER}",
        "where address_id = #{addressId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Address record);
}