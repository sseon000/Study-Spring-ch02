package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

/*
 * MVC 패턴으로 변경
 * -. reqeustmapping url 변경
 * -. 함수에 인자 변경하기!! httpservlet -> 각 변수로
 * 1. 유효성 검사(비지니스로직)
 * 2. 요일 계산(비지니스로직) 
 * 3. model에 값 담기
 * 4. view 지정 -> 함수 return 타입 string으로 변환
 * */

@Controller
public class YoilTellerMVC {
	@RequestMapping("/getYoilMVC")
	// 1. 반환 타입 String일 경우 return "화면명"
	// 2. 반환 타입 X void일 경우 requestMapping url과 같은 화면명
	// 3. ModelAndView
	public ModelAndView main(int year, int month, int day, Model model) throws IOException {
		
		ModelAndView mv = new ModelAndView();
		
		// 1. 유효성 검사
//		if(!isValid(year, month, day)) {
//			return "yoilError";
//		}
		
		// 2. 요일 계산
		char yoil = getYoil(year, month, day);
		
		// 3. 계산한 결과를 모델에 저장
//		model.addAttribute("year", year);
//		model.addAttribute("month", month);
//		model.addAttribute("day", day);
//		model.addAttribute("yoil", yoil);
		
		mv.addObject("year", year);
		mv.addObject("month", month);
		mv.addObject("day", day);
		mv.addObject("yoil", yoil);
		
		// 4. 결과를 보여줄 view를 지정 (ModelAndView 방식)
		mv.setViewName("yoil");
		
//		return "yoil";
		return mv;
		
		// 4. 결과를 보여줄 view를 지정
		// 뷰리졸버 설정은 /WEB-INF/spring/appServlet/servlet-context.xml -> <beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver"> ...생략
		// 매핑함수 반환타입을 void로 하면 매핑명이랑 동일한 jsp를 따라감 ex) getYoilMVC
		// return "yoil"; // /WEB-INF/views/yoil.jsp
	}

	// 해당 클래스내에서만 사용하기 때문에 private
	private boolean isValid(int year, int month, int day) {
		return true;
	}
	
	// 해당 클래스내에서만 사용하기 때문에 private
	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " 일월화수목금토".charAt(dayOfWeek);
	}
}

/*
 * browser 요청이 오면 톰캣이 HttpServletRequest 객체를 만들어서 객체를 넘겨줌
 * @ReqeustMapping("/requestInfo")
 * public void main(HttpServletReqeust request){ ... } 
 * */