package com.fastcampus.ch2;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// 1. 세션 종료
		session.invalidate();
		// 2. 홈으로 이동
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(String id, String pwd, String toURL, boolean rememberId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// @CookieValue("id") String cookieId >> @쿠키에 저장된 값을 받아올 수 있는 어노테이션
		// 1. id와 pwd를 확인
		if(!loginCheck(id, pwd)) {
			String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");
			// 2-1. id와 pwd가 일치하지 않으면, loginForm으로 이동			
			return "redirect:/login/login?msg="+msg;
		}
		
		// 2-2. id와 pwd가 일치하면
		// 세션 객체 얻어오기
		HttpSession session = request.getSession();
		// 세션 객체에 id를 저장
		session.setAttribute("id", id);
		
		if(rememberId) { 
			// 쿠키생성, 응답에 저장 
			Cookie cookie = new Cookie("id", id);
			response.addCookie(cookie); 
		} else {
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0); // 쿠키 삭제
			response.addCookie(cookie); 
		}
		// 3. toURL값 체크해서 없으면 홈으로 있으면 toURL로 삼항연산 분기
		toURL = toURL == null || toURL.equals("") ? "/" : toURL;
		
		return "redirect:"+toURL;
	}

	private boolean loginCheck(String id, String pwd) {
		return "asdf".equals(id) && "1234".equals(pwd);
	}
}
