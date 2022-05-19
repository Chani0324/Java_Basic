package step01.review.controller;

import review.exception.UserException;
import step01.review.model.Model;
import step01.review.model.dto.Unit;
import step01.review.view.FailView;
import step01.review.view.SuccessView;

public class Controller {
	public static Model totalUnit = Model.getInstance();
	
	public static void gameUnitInsert(Unit unit) {
		if (unit != null) {
			totalUnit.gameUnitInsert(unit);
			SuccessView.successMessage(unit + " 유닛 부대에 지정 완료");
		}else {
			FailView.printFail("해당 유닛 재확인 필요.");
		}
	}
	
	public static void attack(Unit unit) {
		if(unit != null && unit.getUHp() > 0) {
			try {
				totalUnit.attack(unit);
				SuccessView.successMessage("공격받은" + unit.getUName() + "의 체력이" + unit.getUHp() + "이(가) 되었습니다.");
			}catch(UserException e) {
				e.printStackTrace();
				FailView.printFail(e.getMessage()); 
			}
		}else {
			FailView.printFail("공격받는 유닛이 있는지 재확인 하세요.");
		}
	}

}
