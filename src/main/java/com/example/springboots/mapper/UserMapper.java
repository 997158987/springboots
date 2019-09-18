package com.example.springboots.mapper;

import com.example.springboots.model.*;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface UserMapper {
    @Delete({
        "delete from user",
        "where user_id = #{user_Id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userId);

    @Insert({
        "insert into user (user_id, username, ",
        "password, phone, ",
        "email, gender,state)",
        "values (#{user_id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{gender,jdbcType=INTEGER},0)"
    })
    int insert(User user);

    @Select("SELECT * FROM user WHERE username=#{username} and password=#{password}")
    User select(String username,String password);

    @Select("SELECT * FROM user WHERE user_id=#{user_id}")
    User selectByID(int user_id);

    @Select({
        "select",
        "user_id, username, password, phone, email, gender",
        "from user"
    })
    List<User> selectAll();

    @Update({
        "update user",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "gender = #{gender,jdbcType=INTEGER}",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);


    //插入到收藏夹数据库
    @Insert("insert into bookmark (bookInfoId,bookmark_user) values (#{bookInfoId},#{bookmark_user})")
    int insertfavourite(int bookInfoId,int bookmark_user);

    //通过书查询对应类别
    @Select("select category_name from category where category_id=#{category_id}")
    Category category(Integer category_id);

    //通过书ID查询收藏夹中书的信息 一对一映射
    @Select("select * from book where book_id=#{book_id}")
    @Results({
            @Result(column="category",property="cate",one = @One(select = "com.example.springboots.mapper.UserMapper.category"))
    })
    Book selectBook(int book_id);

    //拿出所有的收藏夹
    @Select("SELECT * from bookmark where bookmark_user=#{bookmark_user}")
    @Results({
            @Result(column="bookInfoId",property="book",one = @One(select = "com.example.springboots.mapper.UserMapper.selectBook"))
    })
    List<Bookmark> selectfavourite(int bookmark_user);


    //删除收藏夹
    @Delete("delete from bookmark where bookInfoId=#{bookInfoId} and bookmark_user=#{bookmark_user}")
    int deletefavourite(int bookInfoId,int bookmark_user);

    //插入到购物车数据库
    @Insert("insert into shop_trolley (trolley_user,trolley_book) values (#{trolley_user},#{trolley_book})")
    int insertshop(int trolley_user,int trolley_book);

    //拿出所有的购物车
    @Select("SELECT * from shop_trolley where trolley_user=#{trolley_user}")
    @Results({
            @Result(column="trolley_book",property="book",one = @One(select = "com.example.springboots.mapper.UserMapper.selectBook"))
    })
    List<ShopTrolley> selectshop(int trolley_user);

    //删除购物车
    @Delete("delete from shop_trolley where trolley_user=#{trolley_user} and trolley_book=#{trolley_book}")
    int deleteshop(int trolley_user,int trolley_book);

    //增加收货地址
    @Insert("insert into address (reciver,reciver_phone,address,reciver_name,address_user) values (#{reciver},#{reciver_phone},#{address},#{reciver_name},#{address_user})")
    int insertaddress(Address address);

    //通过用户ID查询收货地址
    @Select("select * from address where address_user=#{address_user}")
    List<Address> alladdress(int address_user);

    //点击购买增加order表数据
    @Insert("insert into orders (order_time,order_state,order_user,total) VALUES (#{order_time},#{order_state},#{order_user},#{total})")
    @Options(useGeneratedKeys =true, keyProperty ="order_id",keyColumn = "order_id")
    int insertorder(Order order);

    //点击购买增加order表下的详情数据
//    @Insert("insert into orderinfo (orderaddress,orderId,orderbookId) VALUES <foreach array='shopchoice' item='shopchoice' separator=','>(#{orderinfo.orderaddress},#{orderinfo.orderId},1)</foreach>")
    @Insert({
            "<script>",
            "insert into orderinfo(orderaddress, orderId, orderbookId,admin_id) values ",
            "<foreach collection='shopchoice' item='shopchoice' index='index' separator=','>",
            "(#{orderinfo.orderaddress},#{orderinfo.orderId},#{shopchoice},#{admin_id})",
            "</foreach>",
            "</script>"
    })
    int insertorderinfo(@Param("orderinfo") Orderinfo orderinfo,@Param("shopchoice")List shopchoice,@Param("admin_id")Integer admin_id);

    //查询订单下面的详情信息
    @Select("select * from orderinfo where orderId=#{orderId}")
    @Results({
            @Result(column="orderbookId",property="book",one = @One(select = "com.example.springboots.mapper.UserMapper.selectBook")),
            @Result(column="orderaddress",property="address",one = @One(select = "com.example.springboots.mapper.UserMapper.selectAddress"))
    })
    List<Orderinfo> selectorderinfo(int orderId);

    //查询订单中对应的收货地址
    @Select("select * from address where address_id=#{address_id}")
    Address selectAddress(int address_id);

    //根据订单状态数字查询订单
    @Select("select * from order_state where state_id=#{state_id}")
    OrderState selectOrderState(int state_id);

    //点击订单查询所有的订单信息
    @Select("select * from orders where order_user=#{order_user}")
    @Results({
            @Result(column="order_id",property="orderinfo",many = @Many(select = "com.example.springboots.mapper.UserMapper.selectorderinfo")),
            @Result(column="order_state",property="orderState1",many = @Many(select = "com.example.springboots.mapper.UserMapper.selectOrderState"))
    })
    List<Order> selectallorder(int order_user);

    //点击订单详情查询单个订单信息
    @Select("select * from orders where order_user=#{order_user} and order_id=#{order_id}")
    @Results({
            @Result(column="order_id",property="orderinfo",many = @Many(select = "com.example.springboots.mapper.UserMapper.selectorderinfo")),
            @Result(column="order_state",property="orderState1",many = @Many(select = "com.example.springboots.mapper.UserMapper.selectOrderState"))
    })
    Order selectorderById(int order_user,int order_id);

    //修改订单状态信息为完成订单
    @Update("Update orders set order_state=4 where order_id=#{order_id}")
    int changeState(int order_id);

    //搜索书籍信息
    @Select("select * from book where book_name like concat('%',#{book_name},'%')")
    @Results({
            @Result(column="category",property="cate",one = @One(select = "com.example.springboots.mapper.BookMapper.category"))
    })
    List<Book> searchBook(String book_name);

    //修改收货地址信息
    @Update("update address set reciver=#{reciver},reciver_phone=#{reciver_phone},address=#{address},reciver_name=#{reciver_name} where address_id=#{address_id}")
    int changeAddress(Address address);

    //删除收货地址信息
    @Delete("delete from address where address_id=#{address_id}")
    int deleteAddress(int address_id);

    //修改个人信息
    @Update("update user set phone=#{phone},email=#{email},gender=#{gender} where user_id=#{user_id}")
    int changeInfo(User user);

    //新增评论
    @Insert("insert into remark(remark_user,remarkInfo,remarktime,remark_bookId) values(#{remark_user},#{remarkinfo},#{remarktime},#{remark_bookId})")
    int insertComments(Remark remark);

    //查询对应书籍评论
    @Select("select * from remark where remark_bookId=#{remark_bookId}")
    @Results({
            @Result(column="remark_user",property="user",one = @One(select = "com.example.springboots.mapper.UserMapper.selectByID"))
    })
    List<Remark> selectRemark(int remark_bookId);

    //更新用户状态激活
    @Update("Update user set state=1 where username=#{username}")
    int UpdateUserState(String username);
}