package team.spring.springmbti.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterInfo {
	private int characterNum;
	private double characterHP;
	private double characterAD;
	private double characterAP;
	private double characterADDefence;
	private double characterAPDefence;
	private double characterSpeed;
	private double characterHitRate;
	private double characterAvoidanceRate;
	private double characterCritical;
	private double characterAdditionalDmg;
}
