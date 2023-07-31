package doubleColon;

import java.util.function.Function;

//todo 数组构造器引用语法
public class ColonArray{

    public static void main(String[] args) {
        Function<Integer,ColonArray[]> function = ColonArray[]::new;
        //调用apply方法创建数组，这里的5是数组的长度
        ColonArray[] arr = function.apply(5);
        //循环输出-初始都为null
        for(ColonArray c:arr){
            System.out.println(c);
        }
    }
}