package udf;




import javolution.lang.Reflection.Constructor;
import javolution.lang.Reflection.Method;

public class Apple {

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static void main(String[] args) throws Exception{
        //�����ĵ���
        Apple apple = new Apple();
        apple.setPrice(5);
        System.out.println("Apple Price:" + apple.getPrice()); //Apple Price:5
        //ʹ�÷������
        Class clz = Class.forName("com.chenshuyi.api.Apple");
        java.lang.reflect.Method setPriceMethod = clz.getMethod("setPrice", int.class);
        java.lang.reflect.Constructor appleConstructor = clz.getConstructor();
        Object appleObj = appleConstructor.newInstance();
        setPriceMethod.invoke(appleObj, 14);
        java.lang.reflect.Method getPriceMethod = clz.getMethod("getPrice");
        System.out.println("Apple Price:" + getPriceMethod.invoke(appleObj));
    }
}