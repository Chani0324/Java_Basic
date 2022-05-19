package practice;

import java.util.ArrayList;
import java.util.Hashtable;

public class App 
{
    /**
     * List
     */
    // 제네릭(일반화) 미반영
    // 제네릭이란 동적 메모리에 저장하는 데이터타입을 제한하는 것이다. 안써도 되긴 하나 안쓰면 Object타입으로 되어버림.
    public static void m1() {
        ArrayList al = new ArrayList();
        al.add("String");
        al.add(new Integer("3"));

        System.out.println(al.toString());
        System.out.println(al.get(0).getClass().getSimpleName());    // 변수 타입
        System.out.println(al.get(1).getClass().getSimpleName());    // 변수 타입
        String v = (String)al.get(0);
        System.out.println(v.charAt(1));
    }

    // 제네릭 반영
    public static void m2() {
        ArrayList<String> al = new ArrayList<String>();
        al.add("String");
        // al.add(new Integer("3"));    String 타입만 저장 가능해서 오류 발생
        al.add("3");

        System.out.println(al.toString());
        System.out.println(al.get(0).getClass().getSimpleName());    // 변수 타입
        String v = (String)al.get(0);
        System.out.println(v.charAt(1));
    }

    // autoboxing , unboxing
    // 기본 타입과 8가지 wrapper class 타입간의 관계에서 형성. 객체 타입 명시하지 않아도 변환
    public static void m3 () {
        int i = 3;
        Integer i2 = new Integer(3); // 참조타입
        
        // unboxing
        // 객체 생성후에 intValue()로 int인 기본타입으로 변환해서 대입
        int i3 = new Integer("3");    // int i3 = (new Integer(3)).intValue();

        // autoboxing
        // int 기본값 3을 객체로 변환해서 대입
        Integer i4 = 3; // Integer i4 = new Integer(3);

    }

    /**
     * Map 
     * - python의 dictoinary 구조와 매우 흡사함.
     * - key와 value로 관리
     * - 저장 순서 없음.
     * - Key에 같은 값이 들어오면 key에 있던 value 덮어씌워짐.(이전 데이터 삭제)
     */

    public static void m4() {
        // key와 value에 객체타입 저장 가능.
        Hashtable<String, String> map = new Hashtable<String, String>();

        map.put("1", "카리나");
        map.put("2", "윈터");
        map.put("3", "아이유");

        System.out.println(map);
        System.out.println(map.get("3"));
        map.put("3", "아이린");
        System.out.println(map.get("3"));

    }


    public static void main( String[] args )
    {
        // m1();
        // m2();
        m4();



        


    }
}
