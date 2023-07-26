package net.softsociety.exam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 게시글 정보
 */
public class Board {
	int boardnum; 		// 글 번호
	String Memberid;	// 작성자 아이디
	String title;		// 제목
	String contents;	// 상품소개글 내용
	String inputdate;	// 작성일
	String category;	// 상품분류
	String soldout;		// 판매완료 여부
	String buyerid;		// 구매자 아이디
}
