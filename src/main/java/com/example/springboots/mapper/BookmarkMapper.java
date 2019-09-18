package com.example.springboots.mapper;

import com.example.springboots.model.Bookmark;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface BookmarkMapper {
    @Delete({
        "delete from bookmark",
        "where bookmark_id = #{bookmarkId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer bookmarkId);

    @Insert({
        "insert into bookmark (bookmark_id, bookInfoId, ",
        "bookmark_user)",
        "values (#{bookmarkId,jdbcType=INTEGER}, #{bookinfoid,jdbcType=INTEGER}, ",
        "#{bookmarkUser,jdbcType=INTEGER})"
    })
    int insert(Bookmark record);

    @Select({
        "select",
        "bookmark_id, bookInfoId, bookmark_user",
        "from bookmark",
        "where bookmark_id = #{bookmarkId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="bookmark_id", property="bookmarkId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="bookInfoId", property="bookinfoid", jdbcType=JdbcType.INTEGER),
        @Result(column="bookmark_user", property="bookmarkUser", jdbcType=JdbcType.INTEGER)
    })
    Bookmark selectByPrimaryKey(Integer bookmarkId);

    @Select({
        "select",
        "bookmark_id, bookInfoId, bookmark_user",
        "from bookmark"
    })
    @Results({
        @Result(column="bookmark_id", property="bookmarkId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="bookInfoId", property="bookinfoid", jdbcType=JdbcType.INTEGER),
        @Result(column="bookmark_user", property="bookmarkUser", jdbcType=JdbcType.INTEGER)
    })
    List<Bookmark> selectAll();

    @Update({
        "update bookmark",
        "set bookInfoId = #{bookinfoid,jdbcType=INTEGER},",
          "bookmark_user = #{bookmarkUser,jdbcType=INTEGER}",
        "where bookmark_id = #{bookmarkId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Bookmark record);
}