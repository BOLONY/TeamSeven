package net.softsociety.exam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
/**
 * 게시글 정보
 */
public class Board {

	int boardnum;
	String memberid;
	String title;
	String contents;
	String inputdate;
	String category;
	char soldout;
	String buyerid;

}
