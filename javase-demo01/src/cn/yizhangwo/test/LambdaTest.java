package cn.yizhangwo.test;

import cn.yizhangwo.compare.LengthComparator;
import cn.yizhangwo.pojo.Employee;
import cn.yizhangwo.pojo.EmployeeBo;
import org.junit.Test;


import javax.swing.*;
import java.util.Arrays;


public class LambdaTest {
    /**
     * 克隆练习 fun05 fun06
     */
    @Test
    public void fun06() throws CloneNotSupportedException {
        Employee employee = new Employee();
        employee.setName("克隆测试");
        employee.setAddr("都是吹牛逼");
        Employee clone = employee.clone();
        System.out.println(employee);
        System.out.println(clone);
    }
    @Test
    public void fun05() {
        EmployeeBo[] employeeBos = getEmployeeBos();
        EmployeeBo bo = employeeBos[1];
        bo.setAddr("富人到");
        EmployeeBo employeeBo = bo;
        System.out.println(bo);
        System.out.println(employeeBo);

    }

    @Test
    public void fun04() {
        String str1 = "网亲情";
        String str2 = "你过拉丝富国比人";
        String str3 = "都是王子";
        String[] strArr = {str1, str2, str3};
        Arrays.sort(strArr, new LengthComparator());
        System.out.println(Arrays.toString(strArr));
    }

    /**
     * 定时任务
     */
    @Test
    public void fun03() {
        Timer timer = new Timer(1000, new TimePrinter());
        timer.start();
        JOptionPane.showMessageDialog(null, "退出程序！");
        System.exit(0);
    }

    @Test
    public void fun02() {
        System.out.println(this.getClass());
    }

    @Test
    public void fun01() {
        EmployeeBo[] employeeBos = getEmployeeBos();
        System.out.println(Arrays.toString(employeeBos));
        Arrays.sort(employeeBos);
        System.out.println(Arrays.toString(employeeBos));
    }

    public EmployeeBo[] getEmployeeBos() {
        EmployeeBo bo1 = new EmployeeBo();
        bo1.setName("员工一");
        EmployeeBo bo2 = new EmployeeBo();
        bo2.setName("员工二");
        EmployeeBo bo3 = new EmployeeBo();
        bo3.setName("员工三");
        return new EmployeeBo[]{bo1, bo3, bo2};
    }
}
