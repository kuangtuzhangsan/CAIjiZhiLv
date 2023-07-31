package doubleColon;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

// 超类方法语法使用例子
/*public class Example extends BaseExample {

    @Test
    public void test() {
        List<String> list = Arrays.asList("aaaa", "bbbb", "cccc");

        //对象的超类方法语法： super::methodName
        list.forEach(super::print);
    }
}

class BaseExample {
    public void print(String content){
        System.out.println(content);
    }
}*/

public class Example {

    private String name;

    Example(String name){
        this.name = name;
    }

    public static void main(String[] args) {
        InterfaceExample com = Example::new;
        Example bean = com.create("hello world");
        System.out.println(bean.name);
    }
}
interface InterfaceExample{
    Example create(String name);
}

