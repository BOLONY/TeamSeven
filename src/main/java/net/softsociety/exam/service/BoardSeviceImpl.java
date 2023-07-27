package net.softsociety.exam.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.softsociety.exam.dao.BoardDAO;
import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;


@Transactional
@Service
public class BoardSeviceImpl implements BoardService {

	@Autowired
	BoardDAO dao;
	
	@Override
	public ArrayList<Board> getBoardlist() {
		return dao.selectAll();
	}
	
	@Override
	public int writeBoard(Board b) {
		return dao.insertOne(b);
	}

	@Override
	public Board readBoard(int boardnum) {
		return dao.selectOne(boardnum);
	}

	@Override
	public ArrayList<Reply> getReplylist(int boardnum) {
		return dao.selectReply(boardnum);
	}

	@Override
	public int deleteBoard(Board b) {
		return dao.deleteOne(b);
	}

	@Override
	public void writeReply(Reply r) {
		dao.insertReply(r);
	}

	@Override
	public ArrayList<Board> getSearchBoard(String category, String searchWord) {
		return dao.searchAll(category, searchWord);
	}

	@Override
	public void buyItem(Board b) {
		dao.buyOne(b);
	}

	
	
}
