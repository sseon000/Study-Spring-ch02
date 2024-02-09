package com.fastcampus.ch2;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.BAD_REQUEST) // 500 -> 400
class MyException extends RuntimeException {
	MyException(String msg) {
		super(msg);
	}
	
	MyException() { this(""); }
}

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
		throw new MyException("���ܰ� �߻��߽��ϴ�22222222222222.");
	}
	
	@RequestMapping("/ex4")
	public String main2() throws Exception {
		throw new NullPointerException("�������� ���ܰ� �߻��߽��ϴ�.");
	}
}
