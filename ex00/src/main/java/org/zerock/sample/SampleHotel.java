package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

// 필드 주입, 세터 주입, 생성자 주입
@Component
@ToString
@RequiredArgsConstructor
public class SampleHotel {
	
	private Chef chef;

	// shift + alt + s : Generate Constructor with Fields
//	public SampleHotel(Chef chef) {
//		super();
//		this.chef = chef;
//	}
//	
//	
}
