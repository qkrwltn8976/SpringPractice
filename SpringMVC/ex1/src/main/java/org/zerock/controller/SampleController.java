package org.zerock.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;

import lombok.extern.log4j.Log4j;

@Controller // 스프링의 빈으로 등록하고 컨트롤러로 사용, <component-scan>과 같이 활용
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@RequestMapping("")
	public void basic() {
		log.info("basic.............");
	}
	
	@GetMapping("/basicGET")
	public void basicGET() {
		log.info("basic get...........");
	}
	
	@GetMapping("/ex01")
	public void ex01(SampleDTO dto) {
		
		log.info(dto);
	}
	
	@GetMapping("/ex02")
	public void ex02(@RequestParam("name") String name, int age) {
		
		log.info(name);
		log.info(age);
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		
		log.info("ids: " + ids);
		
		return "ex02List";
	}
	
	@GetMapping({"/ex02Bean", "/ex022"})
	public String ex02Bean(@ModelAttribute("sample") SampleDTOList list, Model model) { // model 객체는 JSP에 컨트롤러에서 생성된 데이터를 담아서 전달하는 역할을 하는 존재, Model에 담는 데이터는 파라미터가 아닌 다른 곳에서 발생한 데이터를 담기 위한 용기
		// ModelAttribute는 컨트롤러에서 메서드의 파라미터는 기본 자료형을 제외한 객체형 타입은 다시 화면으로 전달, @ModelAttribute는 명시적으로 화면에 전달되도록 지정
		log.info(list);
		
		model.addAttribute("result", "success");
		
		return "sample/ex02Bean";
	}
	
	@GetMapping("/re1")
	public String re1() {
		
		log.info("re1..............");
		return "redirect:/sample/re2";
	}
	
	@GetMapping("/re2")
	public void re2() {
		
		log.info("re2...............");
	}
	
	@GetMapping("/exUpload")
	public void exUpload() {
		
		log.info("exUpload.......");
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		
		files.forEach(file -> {
			log.info(file.getOriginalFilename());
			log.info(file.getSize());
			log.info(file.getContentType());
		});
	}
}
