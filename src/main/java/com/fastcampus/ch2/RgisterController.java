package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // ctrl+shift+o 자동 import
public class RgisterController {
//	@RequestMapping(value="register/add", method={RequestMethod.GET, RequestMethod.POST})
//	@RequestMapping("register/add") // 신규회원 가입 화면
//	@GetMapping("register/add")
//	public String register() {
//		return "registerForm"; // WEB-INF/views/registerForm.jsp
//	}
	
//	@RequestMapping(value="register/save", method=RequestMethod.POST)
	@PostMapping("register/save") // 4.3부터
	public String save(User user, Model m) throws Exception{
		// 1. 유효성 검사
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");
			
			m.addAttribute("msg",msg);
			return "redirect:/register/add";
//			return "redirect:/register/add?msg="+msg; // URL재작성(rewriting)
		}
		
		return "registerInfo"; // WEB-INF/views/registerInfo.jsp
		
	}

	private boolean isValid(User user) {
		return true;
	}
}
