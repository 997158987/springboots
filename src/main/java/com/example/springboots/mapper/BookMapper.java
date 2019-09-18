package com.example.springboots.mapper;

import com.example.springboots.model.Book;
import java.util.List;

import com.example.springboots.model.Category;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import javax.annotation.Generated;

@Mapper
public interface BookMapper {
    @Delete({
        "delete from book",
        "where book_id = #{bookId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer bookId);

    @Insert({
        "insert into book (book_id, book_name, ",
        "writer, publish, ",
        "category, price, ",
        "num, admin_book)",
        "values (#{bookId,jdbcType=INTEGER}, #{bookName,jdbcType=VARCHAR}, ",
        "#{writer,jdbcType=VARCHAR}, #{publish,jdbcType=VARCHAR}, ",
        "#{category,jdbcType=INTEGER}, #{price,jdbcType=VARCHAR}, ",
        "#{num,jdbcType=VARCHAR}, #{adminBook,jdbcType=INTEGER})"
    })
    int insert(Book record);

    @Select({
        "select",
        "book_id, book_name, writer, publish, category, price, num, admin_book",
        "from book",
        "where book_id = #{bookId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="book_id", property="bookId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="book_name", property="bookName", jdbcType=JdbcType.VARCHAR),
        @Result(column="writer", property="writer", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish", property="publish", jdbcType=JdbcType.VARCHAR),
        @Result(column="category", property="category", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.VARCHAR),
        @Result(column="num", property="num", jdbcType=JdbcType.VARCHAR),
        @Result(column="admin_book", property="adminBook", jdbcType=JdbcType.INTEGER),
    })
    Book selectByPrimaryKey(Integer bookId);

    @Select("select category_name from category where category_id=#{category_id}")
    Category category(Integer category_id);


    @Select("SELECT * from book LEFT JOIN bookmark on book.book_id=bookmark.bookInfoId and bookmark.bookmark_user=#{bookmark_user} ORDER BY book.book_id")
    @Results({
            @Result(column="category",property="cate",one = @One(select = "com.example.springboots.mapper.BookMapper.category")),
            @Result(column = "bookmark_id",property = "bookmark.bookmark_id")
    })
    Page<Book> selectAll(int bookmark_user);

    @Update({
        "update book",
        "set book_name = #{bookName,jdbcType=VARCHAR},",
          "writer = #{writer,jdbcType=VARCHAR},",
          "publish = #{publish,jdbcType=VARCHAR},",
          "category = #{category,jdbcType=INTEGER},",
          "price = #{price,jdbcType=VARCHAR},",
          "num = #{num,jdbcType=VARCHAR},",
          "admin_book = #{adminBook,jdbcType=INTEGER}",
        "where book_id = #{bookId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Book record);
}