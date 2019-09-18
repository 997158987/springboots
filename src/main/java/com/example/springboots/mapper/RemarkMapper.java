package com.example.springboots.mapper;

import com.example.springboots.model.Remark;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface RemarkMapper {
    @Delete({
        "delete from remark",
        "where remark_id = #{remarkId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer remarkId);

    @Insert({
        "insert into remark (remark_id, remark_user, ",
        "remarkInfo, remarktime)",
        "values (#{remarkId,jdbcType=INTEGER}, #{remarkUser,jdbcType=INTEGER}, ",
        "#{remarkinfo,jdbcType=VARCHAR}, #{remarktime,jdbcType=TIMESTAMP})"
    })
    int insert(Remark record);

    @Select({
        "select",
        "remark_id, remark_user, remarkInfo, remarktime",
        "from remark",
        "where remark_id = #{remarkId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="remark_id", property="remarkId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="remark_user", property="remarkUser", jdbcType=JdbcType.INTEGER),
        @Result(column="remarkInfo", property="remarkinfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="remarktime", property="remarktime", jdbcType=JdbcType.TIMESTAMP)
    })
    Remark selectByPrimaryKey(Integer remarkId);

    @Select({
        "select",
        "remark_id, remark_user, remarkInfo, remarktime",
        "from remark"
    })
    @Results({
        @Result(column="remark_id", property="remarkId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="remark_user", property="remarkUser", jdbcType=JdbcType.INTEGER),
        @Result(column="remarkInfo", property="remarkinfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="remarktime", property="remarktime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Remark> selectAll();

    @Update({
        "update remark",
        "set remark_user = #{remarkUser,jdbcType=INTEGER},",
          "remarkInfo = #{remarkinfo,jdbcType=VARCHAR},",
          "remarktime = #{remarktime,jdbcType=TIMESTAMP}",
        "where remark_id = #{remarkId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Remark record);
}