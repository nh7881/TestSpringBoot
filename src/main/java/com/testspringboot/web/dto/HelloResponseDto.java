package com.testspringboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//lombok 라이브러리를 사용함으로써
//Getter, 생성자를 자동생성
//RequiredArgsConstructor = final 있는거 생성자 생성
@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
