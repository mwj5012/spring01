package com.exam.spring.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.exam.spring.model.PointDTO;
import com.exam.spring.model.ProductDTO;

//컨트롤러 bean으로 등록
@Controller
public class MainController {

	// http://localhost/spring01/
	@GetMapping("/")	// url과 method 매핑
	public String main(Model model) {	// Model 데이터 저장소
		model.addAttribute("message", "welcome!");	// key, value
		
		return "main";	// main.jsp로 포워드
	}
	
	
	/* 구구단 화면 */
	@GetMapping("/test/multi_table.do")
	public void gugu() {
		System.out.println("구구단 화면");
	}
	
	/* 구구단 결과 */
	@PostMapping("/test/table_result.do")
	public String gugu_result(@RequestParam(defaultValue = "3") int num, Model model) {
		System.out.println(num + "단 구구단 결과");
		
		String result = "";
		
		for (int i = 1; i <= 9; i++) {
			result += num + "x" + i + " = " + num * i + "<br>";
		}
		
		model.addAttribute("result", result);
		
		return "/test/table_result";
	}
	
	
	/* 성적 계산 화면 */
	@GetMapping("/test/point.do")
	public void point() {
		System.out.println("성적 계산 화면");
	}
	
	/* 성적 계산 결과 */
	// @RequestParam : 개별 변수 처리 어노테이션
	// @ModelAttribute : 객체 처리 어노테이션
	@PostMapping("/test/point_result.do")
	public String point_result(@ModelAttribute PointDTO dto, Model model) {
		System.out.println(dto.getName() + "의 성적 계산 결과");
		
		// total
		dto.setTotal(dto.getKor() + dto.getEng() + dto.getMat());
		
		// avg
		double avg = Math.round(dto.getTotal() / 3.0);
		System.out.println("avg : " + avg);
		
		dto.setAvg(avg);
		
		model.addAttribute("dto", dto);
		
		return "/test/point_result";
	}
	
	
	/* redirect */
	@GetMapping("/test/move.do")
	public String move() throws Exception {
		System.out.println("redirect 화면");
		
		// encode(문자열, 문자셋)
		String name = URLEncoder.encode("김철수", "utf-8");
		return "redirect:/test/result.do?name=" + name + "&age=20";
		
		// URL - 한글, 특수문자 제한		
		// return "redirect:/test/result.do?name=김철수&age=20";
	}
	
	@GetMapping("/test/result.do")
	public String result(Model model,
			@RequestParam(defaultValue = "noname") String name,
			@RequestParam(defaultValue = "10") int age) throws Exception {
		System.out.println("redirect 결과");
		
		name = URLDecoder.decode(name, "UTF-8");
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "test/result";
	}
	
	
	/* ModelAndView */
	// Model : 데이터 저장소
	// view : 출력 페이지
	@GetMapping("/test/mav.do")
	public void getMav() {
		System.out.println("mav 화면");
	}
	
	@PostMapping("/test/mav_result.do")
	public ModelAndView postMav(ProductDTO dto) {
		System.out.println("mav 결과 화면");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		String name = dto.getName();
		int price = dto.getPrice();
		System.out.println("상품명 : " + name);
		System.out.println("가격 : " + price);
		
		Object toMap = new ProductDTO(name, price);
		System.out.println("toMap : " + toMap);
		
		map.put("dto", toMap);
		
		// new ModelAndView(view, key, value)
		return new ModelAndView("test/mav_result", "map", map);
	}
	
	
	/* ajax */
	@GetMapping("/test/ajax.do")
	public String ajax() {
		System.out.println("ajax.jsp로 포워드");
		
		return "/test/ajax";
	}
	
	// @ResponseBody : 데이터 자체를 리턴 => json 형식
	// { "name" : "TV", "price" : 500000 }
	// *변환기 필요 : pom.xml에 json 관련 라이브러리 추가
	@GetMapping("/test/background.do")
	@ResponseBody
	public ProductDTO background() {
		System.out.println("background.jsp로 데이터 리턴");
		
		ProductDTO pdto = new ProductDTO("TV", 500000);
		
		return pdto;	// 데이터 자체를 리턴
	}
	
	
	/* ajax 연습 */
	@GetMapping("/test/ajaxExam.do")
	public void ajaxExam() {
		System.out.println("ajax 연습");
		
//		return "/test/ajaxExam";
	}
	
	
	@PostMapping("/test/ajaxReturn.do")
	@ResponseBody
	public  ProductDTO ajaxReturn(ProductDTO pdto) {
		System.out.println("ajax 데이터 리턴");
		
		String name = pdto.getName();
		int price = pdto.getPrice();
		
		System.out.println("상품명 : " + name);
		System.out.println("가격 : " + price);
		
		pdto = new ProductDTO(name, price);
		
		System.out.println("pdto : " + pdto);
		
		// json 데이터 전달
		return pdto;
	}
}
