package model.domain;

public class Employee {
	private int empno;
	private String ename;
	private int age;
	
	
	public Employee() {
		super();
	}
	
	public Employee(int empno, String ename, int age) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.age = age;
	}
	
	public int getEmpno() {
		return empno;
	}
	
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	
	public String getEname() {
		return ename;
	}
	
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", age=" + age + "]";
	}
	

}
