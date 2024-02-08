package com.fastcampus.ch2;


import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController2 {
	/*
	 * GlobalCatch Ŭ������ ���� ���� ó���ϰԲ� ����
	 * @ControllerAdvice ������̼� Ȱ��
	 * ��Ʈ�ѷ� ������ ExcpetionHandler�� �����ϸ� ��Ʈ�ѷ� ���� �ִ°� ó����
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	*/
	
	@RequestMapping("/ex3")
	public String main() throws Exception {
		throw new Exception("���ܰ� �߻��߽��ϴ�.");
	}
	
	@RequestMapping("/ex4")
	public String main2() throws Exception {
		throw new NullPointerException("�������� ���ܰ� �߻��߽��ϴ�.");
	}
}
