package kr.co.smart;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import smart.common.CommonUtility;

@Controller @RequestMapping("/data")
public class DataController {
	private String key = "CmdwdrVDPAH0A40Af3zXcU6PGKetrDF1TI74tfwOdoQMRi8svpP5GfN5Ph%2BZ9qAsk9e1Vl1nByaDvvCdzr3gTw%3D%3D";
	
	@Autowired private CommonUtility common;
	
	//약국목록 조회 요청
//	@ResponseBody @RequestMapping(value="/pharmacy", produces="application/text; charset=utf-8")
//	public String pharmacy_list() {
//		StringBuffer url = new StringBuffer("http://apis.data.go.kr/B551182/pharmacyInfoService/getParmacyBasisList");
//		url.append("?ServiceKey=").append(key);
//		url.append("&_type=json");
//		return common.requestAPI(url.toString());
//	}
	@ResponseBody @RequestMapping("/pharmacy")
	public Object pharmacy_list(int pageNo) {
		StringBuffer url = new StringBuffer("http://apis.data.go.kr/B551182/pharmacyInfoService/getParmacyBasisList");
		url.append("?ServiceKey=").append(key);
		url.append("&_type=json");
		url.append("&PageNo=").append(pageNo);
		HashMap<String, Object> map = new Gson().fromJson(common.requestAPI(url.toString()),
								new TypeToken<HashMap<String, Object>>(){}.getType());
		
		return map;
	}
	
	//공공데이터 목록화면 요청
	@RequestMapping("/list")
	public String list(HttpSession session) {
		session.setAttribute("category", "da");
		return "data/list";
	}

}
