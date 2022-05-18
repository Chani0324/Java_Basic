package step01.review.model;

import java.util.ArrayList;

import review.exception.UserException;
import step01.review.model.dto.AttackUnit;
import step01.review.model.dto.Unit;

public class Model {

	private static Model instance = new Model();

	// 유닛을 array에 저장
	private ArrayList<Unit> unitList = new ArrayList<Unit>();

	private Model() {
	}

	public static Model getInstance() {
		return instance;
	}

	// 유닛 추가
	public void gameUnitInsert(Unit unit) {
		unitList.add(unit);
	}

	// 유닛 공격
	/*
	 * Array에 저장된 공격유닛 찾아서 개별로 공격 실시. 공격당한 해당 유닛 Hp 0되면 파괴
	 * 
	 * case 1 : 공격하는 유닛이 있을 경우 공격 진행 
	 * 	case 1 : 공격받는 유닛의 피가 0 초과인경우 
	 * 	case 2 : 공격받는 유닛의 hp가 0인경우 파괴 -> null로 
	 * case 2 : 공격하는 유닛이 없을 경우 exception 호출
	 */

	public void attack(Unit unit) {
		
		for (Unit tp : unitList) {
			if (tp.getClass().getName().equals("step01.review.model.dto.AttackUnit")) {
				int damagedHp = unit.getUHp() - (((AttackUnit)tp).getUDamage() - unit.getUDef());

				if (damagedHp > 0) {
					unit.setUHp(damagedHp);
				} else {
					unit.setUHp(0);
				}
			}
		}//throw new UserException("부대 내에 공격유닛이 있는지 재확인 하세요.");
	}
}
