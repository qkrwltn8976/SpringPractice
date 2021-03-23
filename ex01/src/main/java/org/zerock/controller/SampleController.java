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

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@RequestMapping("")
	public void basic() {
		log.info("basic...........");
	}
	
	@GetMapping("/basicGet")
	public void basciGet() {
		log.info("basic get..............");
	}
	
	@GetMapping("/ex01")
	public void ex01(SampleDTO dto) {
		log.info(dto);
	}
	
	@GetMapping("/ex02")
	public void ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name: " + name);
		log.info("age: " + age);
	}
	
	@GetMapping("/ex2List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids: " + ids);
		
		return "ex02List";
	}
	
	@GetMapping("/ex02Bean")
	public void ex02Bean(@ModelAttribute("Sample") SampleDTOList list, Model model) {
		log.info(list);

		model.addAttribute("result", "success");
		
//		return "sample/ex02Bean";
	}
	
	@GetMapping("/re1")
	public String re1() {
		log.info("re1.................");
		
		return "redirect:/sample/re2";
	}
	
	@GetMapping("/re2")
	public void re2() {
		log.info("re2.................");
		
//		return "redirect:/sample/re2";
	}
	
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("exUpload............");
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
