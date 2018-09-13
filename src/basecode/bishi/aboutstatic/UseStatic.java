package basecode.bishi.aboutstatic;

//目前想到的笔试题就是这些
public class UseStatic {

    public static void main(String[] args){
        /*情况1
        B.a = "C";//先初始化再赋值，输出A
        B.b ="D";//输出B，只有使用到一个类的时候，类才会去初始化
        */
        //B.a = "C";情况2，编译不通过

    }

}


class A{
    /*情况1
    static String a = "A";

    static{
        System.out.println(a);
    }
    */

    /*情况2，编译不通过
    static{
        System.out.println(a);
    }

    static String a = "A";
    */

}

class B extends A{
    /*情况1
    static String b = new String("B");

    static{
        System.out.println(b);
    }
    */

    /*情况2，编译不通过
    static{
        System.out.println(b);
    }
    static String b = new String("B");
    */
}