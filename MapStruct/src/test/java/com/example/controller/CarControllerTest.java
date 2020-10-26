package com.example.controller;

import cn.hutool.core.convert.Convert;
import com.example.dto.CarDTO;
import com.example.po.AddrInfoPO;
import com.example.po.CarPO;
import com.example.po.GreenCarPO;
import com.example.po.PersonPO;
import com.example.service.CarConverter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
class CarControllerTest {

    public static final String DDD = "dddsdsd ";
    @Autowired
    private CarConverter converter;
    private String dddsdsd ;

    @Test
    void test01() {
        CarDTO carDTO = new CarDTO("dd", "green", "男");
        CarDTO carDTO1 = new CarDTO("aa", "red", "女");
//        CarDTO carDTO2 = new CarDTO("999", "red", "不男不女");
        List<CarDTO> carDTOS = new ArrayList<>();
        carDTOS.add(carDTO);
        carDTOS.add(carDTO1);
//        carDTOS.add(carDTO2);
        List<CarPO> carPOS = converter.carDtoToPos(carDTOS);
        log.info("----------------  carPOS:{}:",carPOS);
    }

    @Test
    void test02() {
        AddrInfoPO addrInfoPO = new AddrInfoPO();
        addrInfoPO.setCity("厦门市");
        addrInfoPO.setName("立林科技");
        addrInfoPO.setLat(11.2);
        addrInfoPO.setLng(33.9);

        PersonPO ddaa = new PersonPO();
        ddaa.setName("滴滴");
        ddaa.setAge(18);
        converter.updatePerson(addrInfoPO, ddaa);
        log.info("----------------------  ddaa:{}", ddaa);

    }

    @Test
    void test03() {

        CarDTO carDTO = null;
        List<CarDTO> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++){
            carDTO = new CarDTO("我的我的我的我的我的我的", "你的你的你的你的你的你的", "男");
            list.add(carDTO);
        }
        Long start = System.currentTimeMillis();
        List<GreenCarPO> greenCarPOS = converter.toGreens(list);
        Long end = System.currentTimeMillis();
        log.info("--------------  test3 :{}", end-start);
    }

    @Test
    void test06() {
        CarDTO carDTO = null;
        List<CarDTO> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++){
            carDTO = new CarDTO("我的我的我的我的我的我的", "你的你的你的你的你的你的", "男");
            list.add(carDTO);
        }
        Long start = System.currentTimeMillis();
        List<GreenCarPO> greenCarPOS = Convert.toList(GreenCarPO.class, list);
        Long end = System.currentTimeMillis();
        log.info("--------------  test3 :{}", end-start);
    }

    @Test
    void test07() {
        CarDTO carDTO = new CarDTO("我的我的我的我的我的我的", "你的你的你的你的你的你的", "男");
        Long start = System.currentTimeMillis();
        GreenCarPO greenCarPO = converter.toGreen(carDTO);
        Long end = System.currentTimeMillis();
        log.info("--------------  test3 :{}", end-start);
    }

    @Test
    void test05() {
        CarDTO carDTO = new CarDTO("我的我的我的我的我的我的", "你的你的你的你的你的你的", "男");
        Long start = System.currentTimeMillis();
        GreenCarPO greenCarPO = Convert.convert(GreenCarPO.class, carDTO);
        Long end = System.currentTimeMillis();
        log.info("--------------  test3 :{}", end-start);
    }

    @Test
    void test08(){
        print();
        System.out.println();
        System.out.println();
    }

    private void print() {
        System.out.println(DDD);
        String bbb = "bbb";
        System.out.println(bbb);
        dddsdsd  = "ddsaaa";
        System.out.println(dddsdsd );
    }
}