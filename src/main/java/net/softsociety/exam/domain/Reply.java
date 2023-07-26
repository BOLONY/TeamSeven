package net.softsociety.exam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
/**
 * 리플 정보
 */
public class Reply {
	
	int replynum;
	int boardnum;
	String memberid;
	String replytext;
	String inputdate;
}
