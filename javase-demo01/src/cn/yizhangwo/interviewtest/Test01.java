package cn.yizhangwo.interviewtest;

import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;


public class Test01 {
    private static final Integer i;

    static {
        i = 10;
    }

    private final int y;

    public Test01() {
        this.y = 100;
    }


    public static void main(String[] args) {
       /* String str1 = "001";
        String str2 = "002";
        test04(str1, str2);
        System.out.println(str1 + "  " + str2);*/
        //
        //System.out.println(test03());
        test05();
    }

    private static void test05() {
        int i = 1;
        int y = 10;
        i=i+++y;
        i=++i+y;
        //++i;
        System.out.println(i);
    }

    private static void test04(String str1, String str2) {
        str1 = "1";
        str2 = "2";
    }

    private static String test03() {
        String str = "str";
        try {
            // return s.toString();
            return str;
        } finally {
            str = str.toUpperCase();
            System.out.println("执行成功！！！");
        }
    }

    private static StringBuffer test02() {
        StringBuffer s = new StringBuffer("长度二");
        try {
            // return s.toString();
            return s;
        } finally {
            s.append("1");
            System.out.println("执行成功！！！");
        }
    }

    private static int test01() {
        int resut = 1;
        try {
            return resut;
        } finally {
            System.out.println("finally被执行！！！");
            return resut = 3;
        }
    }

    private static void printInt(final int i) {
        ;
        System.out.println("打印： " + i);
    }

    private static void print() {
        System.out.println("static静态方法");
    }

    @Test
    public void fun02() {
        Test02 test02 = new Test02();
        test02.printStr();
    }

    @Test
    public void fun01() {
        StringBuffer buffer = new StringBuffer("test");
        buffer = new StringBuffer("ok");
        System.out.println(buffer);
        print();
    }
}
