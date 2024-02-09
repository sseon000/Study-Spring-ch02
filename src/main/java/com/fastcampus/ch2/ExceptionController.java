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
			throw new Exception("���ܰ� �߻��߽��ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		*/
		// @ExceptionHandler Model�� @RequestMapping Model�� �ٸ�
		m.addAttribute("msg", "message from ExceptionController.main()");
		throw new Exception("���ܰ� �߻��߽��ϴ�.");
	}
	
	// ex2�� try catch�� ���� ExceptionHandler ������̼� Ȱ��
	// ���� ��Ʈ�ѷ� ������ ��������(Excpetion)�� ���� ExceptionHandler(Exception) << �������ָ� ���� ��Ƽ� try catch�� ��ü
	@RequestMapping("/ex2")
	public String main2() throws Exception {
		throw new NullPointerException("�������� ���ܰ� �߻��߽��ϴ�.");
	}
	
	/*
	@RequestMapping("/ex3")
	public String main3() throws Exception {
		throw new FileNotFoundException("���ϳ��Ŀ�� ���ܰ� �߻��߽��ϴ�.");
	}
	*/
}
