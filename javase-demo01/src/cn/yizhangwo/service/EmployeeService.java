package cn.yizhangwo.service;

import cn.yizhangwo.pojo.Employee;

@FunctionalInterface
public interface EmployeeService {
    public int a = 10;
    public static int b = 20;
    public final int c = 30;
    public static final int d = 40;
    Employee em = new Employee();

    public static void printString() {
        System.out.println("接口的静态方法");
    }

    default void print() {
        System.out.println("接口的默认方法");
    }

    private void printEmployee() {

    }

    ;

    void printE();
}
