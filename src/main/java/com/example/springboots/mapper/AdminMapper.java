package com.example.springboots.mapper;

import com.example.springboots.model.*;

import java.util.List;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface AdminMapper {
    @Delete({
        "delete from admin",
        "where admin_id = #{adminId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer adminId);

    @Insert({
        "insert into admin (admin_id, admin_name, ",
        "admin_pwd)",
        "values (#{adminId,jdbcType=INTEGER}, #{adminName,jdbcType=VARCHAR}, ",
        "#{adminPwd,jdbcType=VARCHAR})"
    })
    int insert(Admin record);

    @Select({
        "select",
        "admin_id, admin_name, admin_pwd",
        "from admin",
        "where admin_id = #{adminId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="admin_id", property="adminId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="admin_name", property="adminName", jdbcType=JdbcType.VARCHAR),
        @Result(column="admin_pwd", property="adminPwd", jdbcType=JdbcType.VARCHAR)
    })
    Admin selectByPrimaryKey(Integer adminId);

    @Select({
        "select",
        "admin_id, admin_name, admin_pwd",
        "from admin"
    })
    @Results({
        @Result(column="admin_id", property="adminId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="admin_name", property="adminName", jdbcType=JdbcType.VARCHAR),
        @Result(column="admin_pwd", property="adminPwd", jdbcType=JdbcType.VARCHAR)
    })
    List<Admin> selectAll();

    @Update({
        "update admin",
        "set admin_name = #{adminName,jdbcType=VARCHAR},",
          "admin_pwd = #{adminPwd,jdbcType=VARCHAR}",
        "where admin_id = #{adminId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Admin record);
    //验证管理员账号密码
    @Select("SELECT * FROM admin WHERE admin_name=#{admin_name} and admin_pwd=#{admin_pwd}")
    Admin select(String admin_name, String admin_pwd);

    //查询管理员手下对应所有的书
    @Select("select * from book join admin on admin_book=admin_id and admin_id=#{admin_book}")
    @Results({
            @Result(column="category",property="cate",one = @One(select = "com.example.springboots.mapper.BookMapper.category"))
    })
    Page<Book> selectAdminBook(int admin_book);

    //根据书ID查书信息
    @Select("select * from book where book_id=#{book_id}")
    Book selectBookById(int book_id);

    //查询所有的类别
    @Select("select * from category")
    List<Category> selectallCategory();


    //修改书本信息
    @Update("update book set book_name=#{book_name},writer=#{writer},publish=#{publish},category=#{category},price=#{price},num=#{num} where book_id=#{book_id}")
    int changeBook(Book book);


    //添加书本
    @Insert("insert into book (book_name,writer,publish,category,price,num,admin_book) values(#{book_name},#{writer},#{publish},#{category},#{price},#{num},#{admin_book})")
    int addBook(Book book);

    //根据订单编号查订单
    @Select("select * from orders where order_id=#{order_id}")
    @Results({
            @Result(column="order_state",property="orderState1",many = @Many(select = "com.example.springboots.mapper.UserMapper.selectOrderState"))
    })
    Order selectOrder(int order_id);

    //查询管理员对应的订单
    @Select("select * from orderinfo where admin_id=#{admin_id}")
    @Results({
            @Result(column="orderId",property="order",one = @One(select = "com.example.springboots.mapper.AdminMapper.selectOrder")),
            @Result(column="orderaddress",property="address",one = @One(select = "com.example.springboots.mapper.UserMapper.selectAddress")),
            @Result(column="orderbookId",property="book",one = @One(select = "com.example.springboots.mapper.UserMapper.selectBook")),
    })
    List<Orderinfo> selectAllOrder(int admin_id);

    //修改订单状态信息为已发货
    @Update("Update orders set order_state=3 where order_id=#{order_id}")
    int AdminchangeState(int order_id);
}