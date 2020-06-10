package cn.yizhangwo.test;


import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class LambdaTest2 {
    @Test
    public void fun02() {

    }
    @Test
    public void fun01() {
        String[] arr = {"安丘一霸", "间谍水根", "驴肉火烧不好吃","加一字"};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, (first, second) -> first.length() - second.length());
        //Arrays.sort(arr, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(arr));
        //定时任务
        var timer = new Timer(1000, e -> {
            System.out.println("时间：" + new Date(e.getWhen()));
            Toolkit.getDefaultToolkit().beep();
        });
        timer.start();
        JOptionPane.showInternalMessageDialog(null, "退出应用");
        System.exit(0);
    }
}
