package com.example.springboots.controller;

import com.example.springboots.mapper.AdminMapper;
import com.example.springboots.mapper.UserMapper;
import com.example.springboots.model.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("allAdminBooks")
    public String allAdminBooks(Model model,HttpServletRequest req,String PageNos){
        int PageNo=1;
        if(PageNos!=null){
            PageNo=Integer.parseInt(PageNos);
        }
        PageHelper.startPage(PageNo, 6);
        Admin admin = (Admin) req.getSession().getAttribute("admin");
        Page<Book> books = adminMapper.selectAdminBook(admin.getAdmin_id());
        model.addAttribute("allbook",books);
        model.addAttribute("ThisPageNum",PageNo);
        return "adminMain";
    }
    @RequestMapping("selectAdmin")
    public String selectAdmin(String admin_name, String admin_pwd, Model model, HttpServletRequest req){
        Admin admininfo = adminMapper.select(admin_name, admin_pwd);
        if(admininfo!=null){
            req.getSession().setAttribute("admin",admininfo);
            return "forward:/admin/allAdminBooks";
        }
        else {
            model.addAttribute("error","账号或密码不正确");
            return "forward:/admin.jsp";
        }
    }

    @RequestMapping("changeBook")
    public String changeBook(Model model,int bookInfoId){
        Book book = adminMapper.selectBookById(bookInfoId);
        List<Category> category = adminMapper.selectallCategory();
        model.addAttribute("bookinfo",book);
        model.addAttribute("allcategory",category);
        return "changeBook";
    }

    @RequestMapping("changeBookReal")
    public String changeBookReal(Book book){
        adminMapper.changeBook(book);
        return "forward:/admin/allAdminBooks";
    }

    @RequestMapping("addBook")
    public String addBook(Model model){
        List<Category> category = adminMapper.selectallCategory();
        model.addAttribute("allcategory",category);
        return "addBook";
    }

    @RequestMapping("addBookReal")
    public String addBookReal(Book book,HttpServletRequest req){
        Admin admin = (Admin) req.getSession().getAttribute("admin");
        book.setAdmin_book(admin.getAdmin_id());
        adminMapper.addBook(book);
        return "forward:/admin/allAdminBooks";
    }

    @RequestMapping("manageBook")
    public String manageBook(Model model,HttpServletRequest req){
        Admin admin = (Admin) req.getSession().getAttribute("admin");
        List<Orderinfo> orderinfos = adminMapper.selectAllOrder(admin.getAdmin_id());
        model.addAttribute("allOrder",orderinfos);
        System.out.println(orderinfos);
        return "manageBook";
    }

    @RequestMapping("changeBookstate")
    public String changeBookstate(int order_id){
        adminMapper.AdminchangeState(order_id);
        return "redirect:/admin/manageBook";
    }

    @RequestMapping("out")
    public String out(HttpServletRequest req){
        req.getSession().removeAttribute("admin");
        return "redirect:/admin.jsp";
    }

}
