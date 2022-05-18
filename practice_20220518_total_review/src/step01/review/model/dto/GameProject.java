package step01.review.model.dto;

import lombok.Data;

@Data
public class GameProject {

	private Unit gameUnit;
	
	private AttackUnit gameAttackUnit;
	
	public GameProject(Unit gameUnit, AttackUnit gameAttackUnit) {
		super();
		this.gameUnit = gameUnit;
		this.gameAttackUnit = gameAttackUnit;
	}
	
	
	
	public Unit getGameUnit() {
		return gameUnit;
	}
	
	public void setUDamage(Unit gameUnit) {
		this.gameUnit = gameUnit;
	}
	
	public AttackUnit getGameAttackUnit() {
		return gameAttackUnit;
	}
	
	public void setGameAttackUnit(AttackUnit gameAttackUnit) {
		this.gameAttackUnit = gameAttackUnit;
	}
	
	
	
	
}
