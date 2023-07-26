package net.softsociety.exam.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;

/**
 * 게시판 관련 매퍼
 */
@Mapper
public interface BoardDAO {

	public ArrayList<Board> selectAll();
	
	public int insertOne(Board b);

	public Board selectOne(int boardnum);

	public ArrayList<Reply> selectReply(int boardnum);

	public int deleteOne(Board b);

	public void insertReply(Reply r);

	
}
