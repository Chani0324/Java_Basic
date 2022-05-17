package practice;

import java.util.ArrayList;

class A {
    private A() {}

    static void test() {
        System.out.println("ㅎㅇ");
    }
}


public class App 
{
    static void m() {
        try{
            Class.forName("practice.App");
            System.out.println("정상로딩되었습니다.");
        }catch(ClassNotFoundException e) {
            System.out.println("해당 class 없음");
        }
        System.out.println("1");

    }
    
    static boolean UserException(String id, int pw) throws InvalidateUserException{
        if(id.equals("root") && pw == 11){
            return true;
        }else {
            throw new InvalidateUserException("무효");
        }
    
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

        try {
            boolean r = UserException("root", 22);
            System.out.print("정상 로그인");
        }catch(InvalidateUserException e) {
            System.out.println(e.getMessage());
        }

        A.test();
    }
}
