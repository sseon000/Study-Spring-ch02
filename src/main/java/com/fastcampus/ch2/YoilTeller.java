package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;



// 년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTeller {
	//public static void main(String[] args) {
	@RequestMapping("/getYoil")
	public void main(HttpServletRequest reqeust, HttpServletResponse response) throws IOException{
		//                                       브라우저 출력을 위한 response객체 사용
		// 1. 입력
		String year = reqeust.getParameter("year");
		String month = reqeust.getParameter("month");
		String day = reqeust.getParameter("day");
		
		// 2. 작업
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm-1, dd);;
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		char yoil = " 일월화수목금토".charAt(dayOfWeek);
		
		// 3. 출력
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter(); // response객체에서 브라우저로의 출력 스트림을 얻는다.
		out.println(year + "년 " + month + "월" + day + "일은 ");
		out.println(yoil + "요일입니다.");
	}
}

/*
 * browser 요청이 오면 톰캣이 HttpServletRequest 객체를 만들어서 객체를 넘겨줌
 * @ReqeustMapping("/requestInfo")
 * public void main(HttpServletReqeust request){ ... } 
 * */
 