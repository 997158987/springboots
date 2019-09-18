package com.example.springboots.mapper;

import com.example.springboots.model.OrderState;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface OrderStateMapper {
    @Delete({
        "delete from order_state",
        "where state_id = #{stateId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer stateId);

    @Insert({
        "insert into order_state (state_id, state)",
        "values (#{stateId,jdbcType=INTEGER}, #{state,jdbcType=VARCHAR})"
    })
    int insert(OrderState record);

    @Select({
        "select",
        "state_id, state",
        "from order_state",
        "where state_id = #{stateId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="state_id", property="stateId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR)
    })
    OrderState selectByPrimaryKey(Integer stateId);

    @Select({
        "select",
        "state_id, state",
        "from order_state"
    })
    @Results({
        @Result(column="state_id", property="stateId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR)
    })
    List<OrderState> selectAll();

    @Update({
        "update order_state",
        "set state = #{state,jdbcType=VARCHAR}",
        "where state_id = #{stateId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OrderState record);
}