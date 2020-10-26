package com.example.service;

import com.example.dto.CarDTO;
import com.example.po.GreenCarPO;
import com.example.enums.GenderEnum;
import com.example.po.AddrInfoPO;
import com.example.po.CarPO;
import com.example.po.PersonPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;

/**
 * @version: 1.00.00
 * @description: 转换类
 * @copyright: Copyright (c) 2018 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chd
 * @date: 2020-10-19 10:46
 */
//@Mapper(componentModel = "spring")
@Mapper
public interface CarConverter {
//    CarConverter INSTANCE = Mappers.getMapper(CarConverter.class);

    @Mapping(source = "cardName", target = "name")
    @Mapping(source = "cardColor", target = "color")
    @Mapping(source = "gender", target = "sex", qualifiedByName = "genderToSex")
    CarPO carDtoToPo(CarDTO dto);

    List<CarPO> carDtoToPos(List<CarDTO> dtos);

    @Mapping(source = "name", target = "addr")
    @Mapping(source = "city", target = "city")
    void updatePerson(AddrInfoPO addrInfoPO, @MappingTarget PersonPO personPO);

    GreenCarPO toGreen(CarDTO carDTO);

    List<GreenCarPO> toGreens(List<CarDTO> carDTOS);

    @Named("genderToSex")
    default Integer genderToSex(String gender) {
        //两个的枚举
//        return GenderEnum.MAN.getSex().equals(gender) ? GenderEnum.MAN.getCode() : GenderEnum.WOMAN.getCode();
        //三个及以上
        GenderEnum[] genderEnums = GenderEnum.values();
        for (GenderEnum e : genderEnums){
            if (e.getSex().equals(gender)){
                return e.getCode();
            }
        }
        throw new IllegalArgumentException(gender);
    }

}
