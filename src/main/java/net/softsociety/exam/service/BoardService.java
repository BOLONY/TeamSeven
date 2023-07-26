package net.softsociety.exam.service;

import java.util.ArrayList;

import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;

public interface BoardService {

	// 게시판 리스트 불러오기 기능
	public ArrayList<Board> getBoardlist();
	
	// 글쓰기 기능
	public int writeBoard(Board b);
	
	// 글 읽기 기능
	public Board readBoard(int boardnum);
	
	// 댓글 불러오기 기능
	public ArrayList<Reply> getReplylist(int boardnum);

	public int deleteBoard(Board b);

	public void writeReply(Reply r);

	

	
}
