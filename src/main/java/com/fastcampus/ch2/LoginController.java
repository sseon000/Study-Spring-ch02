package com.fastcampus.ch2;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
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
		// 1. ���� ����
		session.invalidate();
		// 2. Ȩ���� �̵�
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(String id, String pwd, boolean rememberId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. id�� pwd�� Ȯ��
		if(!loginCheck(id, pwd)) {
			String msg = URLEncoder.encode("id �Ǵ� pwd�� ��ġ���� �ʽ��ϴ�.", "utf-8");
			// 2-1. id�� pwd�� ��ġ���� ������, loginForm���� �̵�			
			return "redirect:/login/login?msg="+msg;
		}
		
		// 2-2. id�� pwd�� ��ġ�ϸ�
		// ���� ��ü ������
		HttpSession session = request.getSession();
		// ���� ��ü�� id�� ����
		session.setAttribute("id", id);
		
		if(rememberId) { 
			// ��Ű����, ���信 ���� 
			Cookie cookie = new Cookie("id", id);
			response.addCookie(cookie); 
		} else {
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0); // ��Ű ����
			response.addCookie(cookie); 
		}
		// Ȩ���� �̵�
		return "redirect:/";
	}

	private boolean loginCheck(String id, String pwd) {
		return "asdf".equals(id) && "1234".equals(pwd);
	}
}
