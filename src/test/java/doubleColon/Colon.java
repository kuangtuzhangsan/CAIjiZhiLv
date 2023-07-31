package doubleColon;

//todo 引用类构造方法
//注意：该类无需实现接口
public class Colon{
    private String name;
    private int age;
    //无参构造
    public Colon() {
    }
    //有参构造
    public Colon(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        //无参构造引用
        ColonNoParam cnp = Colon::new;
        Colon c1 = cnp.createColon();
        System.out.println(c1);
        //有参构造引用
        ColonWithParam cwp = Colon::new;
        Colon c2 = cwp.createColon("小明",20);
        System.out.println(c2);
    }

    //生成toString方法打印查看
    @Override
    public String toString() {
        return "Colon{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
interface ColonNoParam{
    //无参方法提供对象
    Colon createColon();
}
interface ColonWithParam{
    //有参方法提供对象（数据类型要与Colon有参构造函数对应）
    Colon createColon(String s,int i);
}