package step01.review.view;

import step01.review.controller.Controller;
import step01.review.model.dto.AttackUnit;
import step01.review.model.dto.Unit;

public class StartView {

	
	public static void main(String[] args) {
				
		System.out.println("===유닛 생성===");
		Unit scv1 = new Unit("scv", 60, 5, 0);
		AttackUnit marine1 = new AttackUnit("marine", 40, 4, 0, 5);
		AttackUnit tank1 = new AttackUnit("tank", 150, 4, 0, 30);
		AttackUnit tank2 = new AttackUnit("tank", 150, 4, 0, 30);
		
		
		System.out.println("===부대 생성===");
		Controller.gameUnitInsert(scv1);
		Controller.gameUnitInsert(tank1);
		Controller.gameUnitInsert(marine1);
//		System.out.println(tank1.getClass().getName());
		
		
		Controller.attack(tank2);
		Controller.attack(tank2);
		Controller.attack(tank2);
		Controller.attack(tank2);
		Controller.attack(tank2);
		Controller.attack(tank2);
		Controller.attack(tank2);
		
	}

}
