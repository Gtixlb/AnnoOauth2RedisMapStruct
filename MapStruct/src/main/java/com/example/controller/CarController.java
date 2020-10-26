package com.example.controller;

import com.example.dto.CarDTO;
import com.example.po.CarPO;
import com.example.service.CarConverter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: 1.00.00
 * @description: 控制层
 * @copyright: Copyright (c) 2018 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chd
 * @date: 2020-10-19 11:25
 */
@RestController
@Slf4j
public class CarController {

    @Autowired
    private CarConverter converter;

    public static void main(String[] args) {

    }

    @RequestMapping("/test01")
    public void test01(){
        CarDTO carDTO = new CarDTO("dd", "green", "男");
        CarDTO carDTO1 = new CarDTO("aa", "red", "女");
        List<CarDTO> carDTOS = new ArrayList<>();
        carDTOS.add(carDTO);
        carDTOS.add(carDTO1);
        List<CarPO> carPOS = converter.carDtoToPos(carDTOS);
        log.info("----------------  carPOS:{}:",carPOS);

//        List<CarPO> carPOS = CarConverter.INSTANCE.carDtoToPos(carDTOS);
//        System.out.println(carPOS);
//        CarPO carPO = CarConverter.INSTANCE.carDtoToPo(carDTO);
//        System.out.println(carPO);
    }

    
    
}
