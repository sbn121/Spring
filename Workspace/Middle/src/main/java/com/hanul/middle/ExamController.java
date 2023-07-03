package com.hanul.middle;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExamController {
	
	// Request req(요청), Response(응답) : MVC
	// Model : 다음페이지에서 데이터가 필요하다면 넣어주는 통 Controller(Model) => jsp (Model, el);
	// SqlSession sql
	// Request 요청 : 요청에 대한 모든 정보를 가지고 있는 객체(Tomcat)
	@RequestMapping("/ex1")
	public void ex1(String board_no, HttpServletResponse res) throws Exception {
//		System.out.println(board_no);
//		System.out.println("ex1까지 접근이 되었습니다."+req.getParameter("board_no"));
//		return "";
		res.getWriter().println("asfdasfd");
	}

}
