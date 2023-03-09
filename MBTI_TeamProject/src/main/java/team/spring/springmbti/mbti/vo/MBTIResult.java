package team.spring.springmbti.mbti.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MBTIResult {
	private String MBTI;
	private String MBTICharacter;
	private String MBTIComments;
}
