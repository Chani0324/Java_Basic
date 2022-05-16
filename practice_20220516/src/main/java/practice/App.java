/*
 * 금일 진행한 내용 TotalReview진행
 *
 * 게임 Unit만들어서 공통 속성을 만들고
 * 공격유닛으로 상속받을 예정.
 *
 *
 */



package practice;

class Unit {
	String name;	// unit의 이름
	int hp;		// unit의 체력
	int def;	// unit의 방어력
	int speed;	// unit의 이동속도
	
	public Unit() {
		super();
	}
	
	public void createUnit(String name, int hp, int def, int speed) {
		this.name = name;
		this.hp = hp;
		this.def = def;
		this.speed = speed;
		System.out.println(name + "이(가) 생성되었습니다.");
		
	}
		
	public void moving() {
		System.out.println(speed + "의 속도로 이동합니다.");		
		
	}
		
}

class AttackUnit extends Unit{
	int damage;
	
	public AttackUnit() {
		super();	// 부모의 기본 생성자 호출
	}
	
	public void createUnit(String name, int hp, int def, int speed, int damage) {	// 오버라이딩
		super.createUnit(name, hp, def, speed);	// 부모의 parameter값과 변수를 받음.
		this.damage = damage;
		
	}
	
	void attack(Unit attackedUnit) {
		attackedUnit.hp = attackedUnit.hp - (damage - attackedUnit.def);
		System.out.println(damage + "의 공격력으로 공격합니다.");
		
		if (attackedUnit.hp <= 0){
			System.out.println(attackedUnit.name + "이 파괴되었습니다.");
			attackedUnit = null;
		}else {
			System.out.println(attackedUnit.name + "의 현재 hp가 " + attackedUnit.hp + "남았습니다.");
		}
	}
	
}

//class BuildingUnit extends Unit{
//
//}


public class App {

	public static void main(String[] args) {
		
		
		Unit scv1 = new Unit();
		scv1.createUnit("scv1", 60, 0, 7);
		
		AttackUnit marine1 = new AttackUnit();
		marine1.createUnit("marine", 40, 0, 5, 5);

		AttackUnit tank1 = new AttackUnit();
		tank1.createUnit("tank", 150, 2, 5, 30);
		
		System.out.println("===유닛 부대 지정===");
		Unit[] o = {scv1, marine1, tank1};
		
		
		System.out.println("===유닛 이동===");
		for (int i = 0; i <= 2; i++) {
			o[i].moving();
		}
		
//		scv1.moving();
//		marine1.moving();
//		tank1.moving();
		
		System.out.println("===유닛 공격===");
		marine1.attack(tank1);
		tank1.attack(marine1);
		tank1.attack(marine1);
		
		
		
	}

}