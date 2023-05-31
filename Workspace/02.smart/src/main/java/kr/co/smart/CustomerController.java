package kr.co.smart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
	
	// 고객목록화면 요청
	@RequestMapping("/list.cu")
	public String list() {
		//비지니스로직
		//응답화면연결
		return "customer/list";
	}
	
}
