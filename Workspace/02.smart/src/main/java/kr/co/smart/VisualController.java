package kr.co.smart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VisualController {
	//시각화 화면 요청
	@RequestMapping("/visual/list")
	public String list() {
		return "visual/list";
	}
}
