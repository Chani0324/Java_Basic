/*
database와 실제 연동되는 class라 가정
데이터를 이름값 -> Customer 자체를 반환 및 출력 구조로 변환
*/
package mvc.model;

public class Model {
    String name;
    String id;
    String pw;
    // 이름 제공해주는 메소드
    // 검색
    Model(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }


}




