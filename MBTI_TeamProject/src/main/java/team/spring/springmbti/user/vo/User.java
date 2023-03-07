package team.spring.springmbti.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private String userEmail;
	private String userName;
	private String userProfile;
	private int userCharacter;
	private String userMBTI;
	private int userWin;
	private int userDefeat;
	private int userI;
	private int userE;
	private int userS;
	private int userN;
	private int userT;
	private int userF;
	private int userP;
	private int userJ;
}