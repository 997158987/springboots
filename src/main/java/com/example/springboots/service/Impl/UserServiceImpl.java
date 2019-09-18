package com.example.springboots.service.Impl;


import com.example.springboots.mapper.UserMapper;
import com.example.springboots.model.*;
import com.example.springboots.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int insert(User user) {
        int insert = userMapper.insert(user);
        return insert;
    }

    @Override
    public User select(String username,String password) {
        User result = userMapper.select(username,password);
        return result;
    }

    @Override
    public int insertfavourite(int bookInfoId, int bookmark_user) {
        int count = userMapper.insertfavourite(bookInfoId, bookmark_user);
        return count;
    }

    @Override
    public List<Bookmark> selectfavourite(int bookmark_user) {
        List<Bookmark> selectfavourite = userMapper.selectfavourite(bookmark_user);
        return selectfavourite;
    }

    @Override
    public int deletefavourite(int bookInfoId, int bookmark_user) {
        int count = userMapper.deletefavourite(bookInfoId, bookmark_user);
        return count;
    }

    @Override
    public int insertshop(int trolley_user, int trolley_book) {
        return userMapper.insertshop(trolley_user,trolley_book);
    }

    @Override
    public List<ShopTrolley> selectshop(int trolley_user) {
        return userMapper.selectshop(trolley_user);
    }

    @Override
    public int deleteshop(int trolley_user, int trolley_book) {
        return userMapper.deleteshop(trolley_user,trolley_book);
    }

    @Override
    public int insertaddress(Address address) {
        int insertaddress = userMapper.insertaddress(address);
        return insertaddress;
    }

    @Override
    public List<Address> alladdress(int address_user) {
        List<Address> alladdress = userMapper.alladdress(address_user);
        return alladdress;
    }

    @Override
    public int insertorder(Order order) {
        int order_id = userMapper.insertorder(order);
        return order_id;
    }

    @Override
    public int insertorderinfo(Orderinfo orderinfo, List shopchoice,Integer admin_id) {
        int insertorderinfo = userMapper.insertorderinfo(orderinfo,shopchoice,admin_id);
        return insertorderinfo;
    }

    @Override
    public List<Order> selectallorder(int order_user) {
        List<Order> allorder = userMapper.selectallorder(order_user);
        return allorder;
    }

    @Override
    public int changeState(int order_id) {
        int i = userMapper.changeState(order_id);
        return i;
    }

    @Override
    public List<Book> searchBook(String book_name) {
        List<Book> books = userMapper.searchBook(book_name);
        return books;
    }

    @Override
    public Address selectAddress(int address_id) {
        return userMapper.selectAddress(address_id);
    }

    @Override
    public int changeAddress(Address address) {
        int i = userMapper.changeAddress(address);
        return i;
    }

    @Override
    public int deleteAddress(int address_id) {
        return userMapper.deleteAddress(address_id);
    }

    @Override
    public int changeInfo(User user) {
        return userMapper.changeInfo(user);
    }

    @Override
    public User selectByID(int user_id) {
        return userMapper.selectByID(user_id);
    }

    @Override
    public int insertComments(Remark remark) {
        return userMapper.insertComments(remark);
    }

    @Override
    public List<Remark>  selectRemark(int remark_bookId) {
        List<Remark> remarks = userMapper.selectRemark(remark_bookId);
        return remarks;
    }

    @Override
    public Order selectorderById(int order_user, int order_id) {
        return userMapper.selectorderById(order_user,order_id);
    }

    @Override
    public int UpdateUserState(String username) {
        return userMapper.UpdateUserState(username);
    }
}
