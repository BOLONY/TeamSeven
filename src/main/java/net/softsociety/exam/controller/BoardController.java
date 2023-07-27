package net.softsociety.exam.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;
import net.softsociety.exam.service.BoardService;

/**
 * 상품게시판 관련 콘트롤러
 */
@Slf4j
@RequestMapping("board")
@Controller
public class BoardController {
	
	@Autowired
	BoardService service;
	
	// 판매 정보 게시판 홈화면
	@GetMapping("soldHome")
	public String soldList(Model m) {
		ArrayList<Board> list = service.getBoardlist();
		m.addAttribute("list", list);
		log.debug("{}", list);
		return "boardView/soldHome";
	}
	
	// 판매글 입력 페이지로 이동
	@GetMapping("soldEnroll")
	public String insertOne() {	
		return "boardView/soldEnroll";
	}
	
	// 판매글 등록
	@PostMapping("soldEnroll")
	public String insertOne(@AuthenticationPrincipal UserDetails user, Board b) {
		b.setMemberid(user.getUsername());
		service.writeBoard(b);
		return "redirect:/board/soldHome";
	}
	
	// 글 읽기 기능
	@GetMapping("readForm")
	public String readForm(Model m, @RequestParam(name="boardnum", defaultValue = "0") int boardnum) {
		Board b = service.readBoard(boardnum);
		// 댓글 가져오는 기능
		if (b == null) {
			return "redirect:/board/soldHome";
		}
		log.debug("리드 컨 {} ",b);
		m.addAttribute("bd", b);
		return "/boardView/readForm";
	}

	// 글 삭제 기능
	@GetMapping("deleteForm")
	public String deleteForm(@AuthenticationPrincipal UserDetails user, Board b) {
		// boardnum을 Board b 객체로 가져와야함
		b.setMemberid(user.getUsername());
		service.deleteBoard(b);
		return "redirect:/board/soldPage";
	}
	
	// 리플 저장 기능
	@ResponseBody
	@PostMapping("insertReply")
	public void insertReply(@AuthenticationPrincipal UserDetails user, Reply r) {
		r.setMemberid(user.getUsername());
		service.writeReply(r);
	}
	
	// 리플 읽어오기 기능
	@ResponseBody
	@GetMapping("readReply")
	public ArrayList<Reply> readReply(int boardnum) {
		ArrayList<Reply> replyList = service.getReplylist(boardnum);
		return replyList;
	}
	
	// 구매하기 버튼
}
