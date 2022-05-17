package practice;

import java.util.ArrayList;


public class App 
{
    static void m() {
        try{
            Class.forName("practice.Ap");
            System.out.println("정상로딩되었습니다.");
        }catch(ClassNotFoundException e) {
            System.out.println("해당 class 없음");
        }
        System.out.println("1");

        

    }

    public static void main( String[] args )
    {
        
        // ArrayList<String> datas = new ArrayList<String>();
        // datas.add("안녕");
        // datas.add("hello");
        // datas.add("곰방와");
        // datas.add("스파시바");

        // System.out.println(datas);

        // datas.add(2, "잘가세요");

        // System.out.println(datas);

        // datas.remove(0);

        // System.out.println(datas);

        // ArrayList<Object> datas2 = new ArrayList<Object>();

        // datas2.add("새로운 데이터입니다.");
        // datas2.add("비교해주세요");

        // System.out.println(datas2);

        // datas2.add(1, datas);

        // System.out.println(datas2);

        m();

    }
}
