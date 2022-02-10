package operate;

import java.lang.reflect.InvocationTargetException;

/**
 * @author YanZhen
 * @date 2022/01/25 09:00
 */
public class Test {
    public static void main(String[] args) {
//        m1();
        Abc abc = new Abc("");
        m2(abc.getClass());
    }

    private static void m2(Class<?> a) {
        System.out.println(a.equals(Abc.class));
        System.out.println(a.getTypeName());
        System.out.println(Abc.class.getTypeName());
        System.out.println(Abc.class.getName());
    }

    private static void m1() {
        try {
            Abc abc = Test.getInitApi(Abc.class, new Abc(1));
            System.out.println(abc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> T getInitApi(Class<T> clazz, Object code) {
        try {
            return clazz.getDeclaredConstructor(Object.class).newInstance(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
