package com.example.springboots.mapper;

import com.example.springboots.model.Category;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface CategoryMapper {
    @Delete({
        "delete from category",
        "where category_id = #{categoryId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer categoryId);

    @Insert({
        "insert into category (category_id, category_name)",
        "values (#{categoryId,jdbcType=INTEGER}, #{categoryName,jdbcType=VARCHAR})"
    })
    int insert(Category record);

    @Select({
        "select",
        "category_id, category_name",
        "from category",
        "where category_id = #{categoryId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="category_name", property="categoryName", jdbcType=JdbcType.VARCHAR)
    })
    Category selectByPrimaryKey(Integer categoryId);

    @Select({
        "select",
        "category_id, category_name",
        "from category"
    })
    @Results({
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="category_name", property="categoryName", jdbcType=JdbcType.VARCHAR)
    })
    List<Category> selectAll();

    @Update({
        "update category",
        "set category_name = #{categoryName,jdbcType=VARCHAR}",
        "where category_id = #{categoryId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Category record);
}