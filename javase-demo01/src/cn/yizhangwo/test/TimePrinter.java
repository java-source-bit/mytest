package cn.yizhangwo.test;


import cn.yizhangwo.interviewtest.Test02;
import org.junit.Test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimePrinter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the thone,the time is " + new Date(e.getWhen()));
        Toolkit.getDefaultToolkit().beep();
    }

    @Test
    public void fun01() {

    }
}
