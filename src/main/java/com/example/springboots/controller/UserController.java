package com.example.springboots.controller;

import com.example.springboots.model.*;
import com.example.springboots.utils.MD5;
import com.example.springboots.utils.SendMail;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.example.springboots.service.BookService;
import com.example.springboots.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.example.springboots.utils.SendMail.SendMailReal;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @RequestMapping("regist")
    public String regist(User user,String num) throws Exception {
        userService.insert(user);
        String address="http://localhost:8080/user/ActiveMail?username="+user.getUsername();
        SendMail.SendMailReal(user.getEmail(),address);
        return "forward:/ActiveMail.jsp";
    }

    //书籍信息总
    @RequestMapping("allinfo")
    public String allbookinfo(Model model,String PageNos,HttpServletRequest req){
        int PageNo=1;
        if(PageNos!=null){
            PageNo=Integer.parseInt(PageNos);
        }
        int bookmark_user = (int) req.getSession().getAttribute("user");
        PageHelper.startPage(PageNo, 6);
        Page<Book> books = bookService.selectAll(bookmark_user);
        model.addAttribute("allbook",books);
        model.addAttribute("ThisPageNum",PageNo);
        return "bookinfo";
    }


    @RequestMapping("selectuser")
    public String selectuser(String username, String password, Model model, HttpServletRequest req){
        User userinfo = userService.select(username, password);
        System.out.println(userinfo);
        if(userinfo!=null&&userinfo.getState()==1){
            req.getSession().setAttribute("user",userinfo.getUser_id());
            req.getSession().setAttribute("username",userinfo.getUsername());
            req.getSession().setAttribute("userinfo",userinfo);
            model.addAttribute("username",userinfo.getUsername());
            return "forward:/user/allinfo";
        }
        else if (userinfo.getState()==0){
            model.addAttribute("error","账号未激活");
            return "forward:/login.jsp";
        }
        else {
            model.addAttribute("error","账号或密码不正确");
            return "forward:/login.jsp";
        }
    }

    @RequestMapping("favourtie")
    public String favourtie(HttpServletRequest req,Model model){
        int bookmark_user = (int) req.getSession().getAttribute("user");
        String username = (String) req.getSession().getAttribute("username");
        List<Bookmark> allfavourite = userService.selectfavourite(bookmark_user);
        model.addAttribute("username",username);
        model.addAttribute("allfavourite",allfavourite);
        return "favourtie";
    }

    @RequestMapping("favourtiereal")
    @ResponseBody
    public String favourtieReal(int bookInfoId,HttpServletRequest req){
        int bookmark_user = (int) req.getSession().getAttribute("user");
        userService.insertfavourite(bookInfoId,bookmark_user);
//        return "favourtie";
        return "1";
    }


    //删除收藏夹
    @RequestMapping("deletefavourite")
    public String deletefavourite(int bookInfoId, HttpServletRequest req){
        int bookmark_user = (int) req.getSession().getAttribute("user");
        int count = userService.deletefavourite(bookInfoId, bookmark_user);
        return "forward:/user/favourtie";
    }

    //进入购物车页面
    @RequestMapping("shoptrolly")
    public String shoptrolly(HttpServletRequest req,Model model){
        int trolley_user = (int) req.getSession().getAttribute("user");
        List<ShopTrolley> selectshop = userService.selectshop(trolley_user);
        List<Address> alladdress = userService.alladdress(trolley_user);
        model.addAttribute("alladdress",alladdress);
        model.addAttribute("allshop",selectshop);
        return "shop";
    }

    //添加至购物车数据库
    @RequestMapping("shoptrollyreal")
    @ResponseBody
    public String shoptrollyreal(int trolley_book,HttpServletRequest req){
        int trolley_user = (int) req.getSession().getAttribute("user");
        userService.insertshop(trolley_user,trolley_book);
        return "1";
    }

    //删除购物车
    @RequestMapping("deleteshop")
    public String deleteshop(int trolley_book, HttpServletRequest req){
        int trolley_user = (int) req.getSession().getAttribute("user");
        int count = userService.deleteshop(trolley_user, trolley_book);
        return "forward:/user/shoptrolly";
    }


    //退出登录
    @RequestMapping("out")
    public String out(HttpServletRequest req){
        req.getSession().removeAttribute("user");
        return "redirect:/login.jsp";
    }


    //新增收货地址主页面
    @RequestMapping("receiveaddress")
    public String receiveaddress(){
        return "receiveaddress";
    }

    //添加到数据库
    @RequestMapping("receiveaddressReal")
    public String receiveaddressReal(Address address,HttpServletRequest req){
        int userid = (int) req.getSession().getAttribute("user");
        address.setAddress_user(userid);
        userService.insertaddress(address);
        return "receiveaddress";
    }


    //个人信息主页面
    @RequestMapping("main")
    public String main(Model model,HttpServletRequest req){
        int user_id = (int) req.getSession().getAttribute("user");
        User user = userService.selectByID(user_id);
        model.addAttribute("userinfo",user);
        return "main";
    }

    //修改个人信息主页面
    @RequestMapping("changeinfo")
    public String changeinfo(){
        return "changeinfo";
    }

    //真正修改个人信息
    @RequestMapping("changeInfoReal")
    public String changeInfoReal(User user,HttpServletRequest req){
        int userid = (int) req.getSession().getAttribute("user");
        user.setUser_id(userid);
        userService.changeInfo(user);
        return "changeinfo";
    }

    //点击购买加入到订单
    @RequestMapping("insertorder")
    public String insertorder(int[] shopchoice,int addresschoice,int[] price,int[] admin_id,HttpServletRequest req,Order order,Orderinfo orderinfo){
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        String order_time = dateFormat.format(date);//当前时间
        //拆分订单
        HashMap<Integer,List> map=new HashMap();
        Set<Integer> set = map.keySet();
        for (int i = 0; i < admin_id.length; i++) {
            List bookid=new ArrayList();
            List orderprice=new ArrayList();
            List allinfo=new ArrayList();
            if (set.contains(admin_id[i])){
                List bookidlist=new ArrayList();//新开辟Id空间准备复制
                List orderpircelist=new ArrayList();//新开辟price空间准备复制
                List ThisIDList = (List) (map.get(admin_id[i])).get(0);//获取已经存在的id List表
                List ThisPriceList = (List) (map.get(admin_id[i])).get(1);//获取已经存在的price List表
                bookidlist.addAll(ThisIDList);
                orderpircelist.addAll(ThisPriceList);
                bookidlist.add(shopchoice[i]);
                orderpircelist.add(price[i]);
                allinfo.add(bookidlist);
                allinfo.add(orderpircelist);

                map.put(admin_id[i],allinfo);
            }
            else {
                bookid.add(shopchoice[i]);
                orderprice.add(price[i]);
                allinfo.add(bookid);
                allinfo.add(orderprice);
                map.put(admin_id[i],allinfo);
            }
        }
        System.out.println(map);//map里面主键为管理员ID，列表第一个是选择的书ID，第二个是对应的价格。
        //根据不同商家拆分订单循环插入订单
        for (Integer integer : set) {
            //计算总价
            List allprice = (List) map.get(integer).get(1);
            int sum=0;
            for (int i = 0; i < allprice.size(); i++) {
                Integer erveyprice = (Integer) allprice.get(i);
                sum+=erveyprice;
            }
            //存储时间
            order.setOrder_time(order_time);
            //存储状态
            order.setOrder_state(2);
            //存储对应用户ID
            order.setOrder_user((int) req.getSession().getAttribute("user"));
            //存储价格
            order.setTotal(sum);
            int order_id = userService.insertorder(order);
            orderinfo.setOrderaddress(addresschoice);
            orderinfo.setOrderId(order.getOrder_id());
            userService.insertorderinfo(orderinfo, (List) map.get(integer).get(0),integer);
        }
        return "redirect:/user/shoptrolly";
    }

    //订单信息页面
    @RequestMapping("order")
    public String order(HttpServletRequest req,Model model){
        int order_user = (int) req.getSession().getAttribute("user");
        List<Order> allorder = userService.selectallorder(order_user);
        model.addAttribute("allorder",allorder);
        return "order";
    }

    //修改收货地址主页面
    @RequestMapping("changeAddress")
    public String changeAddress(HttpServletRequest req,Model model,int address_id){
        Address address = userService.selectAddress(address_id);
        model.addAttribute("alladdress",address);
        return "changeAddress";
    }

    //真正修改收货地址操作
    @RequestMapping("changeAddressReal")
    public String changeAddressReal(Address address){
        userService.changeAddress(address);
        return "forward:/user/shoptrolly";
    }

    //删除收货地址
    @RequestMapping("deleteAddress")
    public String deleteAddress(int address_id){
        userService.deleteAddress(address_id);
        return "forward:/user/shoptrolly";
    }
    //修改订单状态信息为已完成
    @RequestMapping("changeState")
    public String changeState(int order_id){
        userService.changeState(order_id);
        return "redirect:/user/order";
    }

    //搜索书籍信息
    @RequestMapping("search")
    public String searchBook(String book_name,Model model){
        List<Book> books = userService.searchBook(book_name);
        model.addAttribute("books",books);
        return "search";
    }


    //评论主页
    @RequestMapping("UserComment")
    public String UserComment(int remark_bookId,Model model){
        model.addAttribute("remark_bookId",remark_bookId);
        return "Comments";
    }

    //评论
    @RequestMapping("CommentsReal")
    public String CommentsReal(Remark remark,HttpServletRequest req){
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        String remark_time = dateFormat.format(date);//当前时间
        int remark_user = (int) req.getSession().getAttribute("user");
        remark.setRemarktime(remark_time);
        remark.setRemark_user(remark_user);
        userService.insertComments(remark);
        return "redirect:/user/order";
    }

    //拿出评论
    @RequestMapping("selectRemark")
    @ResponseBody
    public List<Remark> selectRemark(int remark_bookId){
        List<Remark> remarks = userService.selectRemark(remark_bookId);
        return remarks;
    }

    //拿出单个订单详情
    @RequestMapping("selectOrderById")
    @ResponseBody
    public Order selectOrderById(int order_id,HttpServletRequest req){
        int order_user = (int) req.getSession().getAttribute("user");
        Order order = userService.selectorderById(order_user,order_id);
        return order;
    }

    @RequestMapping("ActiveMail")
    public String ActiveMail(String username){
        userService.UpdateUserState(username); 
        return "redirect/login.jsp";
    }
}
