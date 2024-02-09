package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionController {
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 200 -> 500
	public String catcher(Exception ex, Model m) {
		System.out.println("catcher() in ExceptionHandler");
		System.out.println("m="+m);
		//m.addAttribute("ex", ex);
		return "error";
	}
	
	/*
	@ExceptionHandler(NullPointerException.class)
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	*/
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	public String catcher2(Exception ex, Model m) {
		System.out.println("m="+m);
		m.addAttribute("ex", ex);
		return "error";
	}
	
	@RequestMapping("/ex")
	public String main(Model m) throws Exception {
		/*
		try {
			throw new Exception("예외가 발생했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		*/
		// @ExceptionHandler Model과 @RequestMapping Model은 다름
		m.addAttribute("msg", "message from ExceptionController.main()");
		throw new Exception("예외가 발생했습니다.");
	}
	
	// ex2는 try catch는 없이 ExceptionHandler 어노테이션 활용
	// 같은 컨트롤러 내에서 예외종류(Excpetion)에 따라 ExceptionHandler(Exception) << 매핑해주면 에러 잡아서 try catch문 대체
	@RequestMapping("/ex2")
	public String main2() throws Exception {
		throw new NullPointerException("널포인터 예외가 발생했습니다.");
	}
	
	/*
	@RequestMapping("/ex3")
	public String main3() throws Exception {
		throw new FileNotFoundException("파일낫파운드 예외가 발생했습니다.");
	}
	*/
}
