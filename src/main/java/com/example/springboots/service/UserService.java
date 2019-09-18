package com.example.springboots.service;

import com.example.springboots.model.*;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserService {
    int insert(User user);
    User select(String username,String password);
    int insertfavourite(int bookInfoId,int bookmark_user);
    List<Bookmark> selectfavourite(int bookmark_user);
    int deletefavourite(int bookInfoId,int bookmark_user);
    int insertshop(int trolley_user,int trolley_book);
    List<ShopTrolley> selectshop(int trolley_user);
    int deleteshop(int trolley_user,int trolley_book);
    int insertaddress(Address address);
    List<Address> alladdress(int address_user);
    int insertorder(Order order);
    int insertorderinfo(Orderinfo orderinfo,List shopchoice,Integer admin_id);
    List<Order> selectallorder(int order_user);
    int changeState(int order_id);
    List<Book> searchBook(String book_name);
    Address selectAddress(int address_id);
    int changeAddress(Address address);
    int deleteAddress(int address_id);
    int changeInfo(User user);
    User selectByID(int user_id);
    int insertComments(Remark remark);
    List<Remark>  selectRemark(int remark_bookId);
    Order selectorderById(int order_user,int order_id);
    int UpdateUserState(String username);
}
