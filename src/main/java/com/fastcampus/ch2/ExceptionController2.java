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
	 * GlobalCatch 클래스에 예외 공통 처리하게끔 변경
	 * @ControllerAdvice 어노테이션 활용
	 * 컨트롤러 내에도 ExcpetionHandler가 존재하면 컨트롤러 내에 있는게 처리함
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
		throw new MyException("예외가 발생했습니다22222222222222.");
	}
	
	@RequestMapping("/ex4")
	public String main2() throws Exception {
		throw new NullPointerException("널포인터 예외가 발생했습니다.");
	}
}
