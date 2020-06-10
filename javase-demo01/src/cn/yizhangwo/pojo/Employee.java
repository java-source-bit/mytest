package cn.yizhangwo.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Employee implements Comparable<Employee>, Cloneable {
    private int id;
    private String name;
    private int age;
    private String sex;
    private String addr;

    @Override
    public int compareTo(Employee employee) {
        //判断两个类 类型是否相同（增强代码健壮性）
        if (this.getClass() != employee.getClass()) {
            throw new ClassCastException();
        }
        return Integer.compare(this.age, employee.getAge());
    }

    /**
     * 将权限改为public
     * 浅拷贝、深拷贝的测试
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Employee clone() throws CloneNotSupportedException {
        Employee clone = (Employee) super.clone();
        return (Employee) super.clone();
    }
}
