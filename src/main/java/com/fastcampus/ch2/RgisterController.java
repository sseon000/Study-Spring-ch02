package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // ctrl+shift+o ÀÚµ¿ import
public class RgisterController {
	@RequestMapping("register/add")
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	}
	
	@RequestMapping("register/save")
	public String save() {
		return "registerInfo"; // WEB-INF/views/registerInfo.jsp
	}
}
