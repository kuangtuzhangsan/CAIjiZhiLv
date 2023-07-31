package doubleColon;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Demo {
//    @Test
//    public void test() {
//        List<String> list = Arrays.asList("aaaa", "bbbb", "cccc");
//
//        //静态方法语法	ClassName::methodName
//        list.forEach(Demo::print);
//    }
//
//    public static void print(String content){
//        System.out.println(content);
//    }

    @Test
    public void test() {
        List<String> list = Arrays.asList("aaaa", "bbbb", "cccc");

        //对象实例语法	instanceRef::methodName
        list.forEach(content -> new Demo().print(content));
    }

    public void print(String content){
        System.out.println(content);
    }

    // 引用特定类型的任意对象的实例方法
    /*注意：不要和引用静态方法搞混，认为为什么compareToIgnoreCase是非静态方法却可以使用类名去引用，这两者根本不是一回事，双冒号前的类含义也不同，就是两个应用方向*/
    @Test
    public void test2(){
        String[] arr = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        //引用String类型的任意对象的compareToIgnoreCase方法实现忽略大小写排序
        Arrays.sort(arr, String::compareToIgnoreCase);
        //上一行等价于
        //Arrays.sort(arr, (a,b)->a.compareToIgnoreCase(b));
        //输出
        for(String s:arr){
            System.out.println(s);
        }
    }

}
