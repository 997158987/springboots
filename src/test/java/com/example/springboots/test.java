package com.example.springboots;


import org.junit.Test;

import java.util.*;

public class test {

    @Test
    public void contextLoads() {
        int[] admin_id={1,2,1};//管理员[1,2]
        int[] shopchoice={1,9,4};//书编号
        int[] price={20,30,100};
        HashMap<Integer,List> map=new HashMap();
        Set<Integer> set = map.keySet();
        for (int i = 0; i < admin_id.length; i++) {
            List bookid=new ArrayList();
            List orderprice=new ArrayList();
            List allinfo=new ArrayList();
                if (set.contains(admin_id[i])){
                    List bookidlist=new ArrayList();//新开辟Id空间准备复制
                    List orderpircelist=new ArrayList();//新开辟Id空间准备复制
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
        System.out.println(map);
        for (Integer integer : set) {
            System.out.println(integer);
        }

        List test=new ArrayList();
        test.add(1);
        System.out.println(test.get(0));
    }
}
