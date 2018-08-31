package com.huangj.advance.utils;

import com.huangj.advance.dto.MenuResDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huangj
 * @version V1.0
 * @title: 菜单递归工具类
 * @description:
 * @date 2018/8/31
 */
public class MenuRecursionUtil {


    /**
     * 阶乘递归计算
     * 比如求5的阶乘，数学公式就是：5*4*3*2*1
     *
     * @param n
     * @return
     */
    public static int factorial(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        return n * factorial(n - 1);
    }

    /**
     * 获取某个父节点下面的所有子节点
     *
     * @param allMenus 所有的菜单数据
     * @param parentId 父节点
     * @return
     */
    public static List<MenuResDto> getChild(int parentId, List<MenuResDto> allMenus) {
        List<MenuResDto> childMenus = new ArrayList<>();
        // 先遍历该父节点的菜单集合
        for (MenuResDto menu : allMenus) {
            if (parentId == menu.getParentId()) {
                childMenus.add(menu);
            }
        }

        // 递归查询该父节点下的子节点
        for (MenuResDto menu : childMenus) {
            menu.setChildren(getChild(menu.getId(), allMenus));
        }

        // 递归退出条件
        if (childMenus.size() == 0) {
            return null;
        }
        return childMenus;
    }

    /**
     * 组装整个菜单级联结构
     *
     * @param allMenus 所有的菜单数据
     * @return
     */
    public static List<MenuResDto> formatAllMenus(List<MenuResDto> allMenus) {
        // 先找到所有的一级菜单
        List<MenuResDto> menuList = allMenus.stream()
                .filter(menu -> menu.getParentId() == 0)
                .collect(Collectors.toList());

        // 循环一级菜单，递归调用 getChild 方法组装整个菜单级联结构
        for (MenuResDto menu : menuList) {
            menu.setChildren(getChild(menu.getId(), allMenus));
        }
        return menuList;
    }

    public static void main(String args[]) {
        System.out.println("=====================  阶乘");
        int total = factorial(3);
        System.out.println("total:" + total);

        System.out.println("=====================  菜单");
        List<MenuResDto> menuList = new ArrayList<>();
        MenuResDto mu = new MenuResDto();
        mu.setId(1);
        mu.setName("目录");
        mu.setParentId(0);

        MenuResDto mu1 = new MenuResDto();
        mu1.setId(2);
        mu1.setName("目录1");
        mu1.setParentId(1);

        MenuResDto mu2 = new MenuResDto();
        mu2.setId(3);
        mu2.setName("目录1.1");
        mu2.setParentId(2);

        MenuResDto mu3 = new MenuResDto();
        mu3.setId(4);
        mu3.setName("目录1.2");
        mu3.setParentId(2);

        MenuResDto mu31 = new MenuResDto();
        mu31.setId(19);
        mu31.setName("目录1.1.1");
        mu31.setParentId(3);

        MenuResDto mu4 = new MenuResDto();
        mu4.setId(5);
        mu4.setName("目录2");
        mu4.setParentId(1);

        MenuResDto mu5 = new MenuResDto();
        mu5.setId(6);
        mu5.setName("目录2.1");
        mu5.setParentId(5);

        MenuResDto mu6 = new MenuResDto();
        mu6.setId(7);
        mu6.setName("目录2.2");
        mu6.setParentId(5);

        MenuResDto mu7 = new MenuResDto();
        mu7.setId(8);
        mu7.setName("目录2.2.1");
        mu7.setParentId(7);

        menuList.add(mu);
        menuList.add(mu1);
        menuList.add(mu2);
        menuList.add(mu3);
        menuList.add(mu4);
        menuList.add(mu5);
        menuList.add(mu6);
        menuList.add(mu7);
        menuList.add(mu31);

        List<MenuResDto> list = formatAllMenus(menuList);
        System.out.println("size:" + list.size());
    }

}
