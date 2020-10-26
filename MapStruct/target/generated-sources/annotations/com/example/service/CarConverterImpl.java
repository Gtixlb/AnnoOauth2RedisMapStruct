package com.example.service;

import com.example.dto.CarDTO;
import com.example.po.AddrInfoPO;
import com.example.po.CarPO;
import com.example.po.GreenCarPO;
import com.example.po.PersonPO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-20T15:17:30+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class CarConverterImpl implements CarConverter {

    @Override
    public CarPO carDtoToPo(CarDTO dto) {
        if ( dto == null ) {
            return null;
        }

        CarPO carPO = new CarPO();

        carPO.setName( dto.getCardName() );
        carPO.setColor( dto.getCardColor() );
        carPO.setSex( genderToSex( dto.getGender() ) );

        return carPO;
    }

    @Override
    public List<CarPO> carDtoToPos(List<CarDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<CarPO> list = new ArrayList<CarPO>( dtos.size() );
        for ( CarDTO carDTO : dtos ) {
            list.add( carDtoToPo( carDTO ) );
        }

        return list;
    }

    @Override
    public void updatePerson(AddrInfoPO addrInfoPO, PersonPO personPO) {
        if ( addrInfoPO == null ) {
            return;
        }

        personPO.setAddr( addrInfoPO.getName() );
        personPO.setCity( addrInfoPO.getCity() );
        personPO.setName( addrInfoPO.getName() );
    }

    @Override
    public GreenCarPO toGreen(CarDTO carDTO) {
        if ( carDTO == null ) {
            return null;
        }

        GreenCarPO greenCarPO = new GreenCarPO();

        greenCarPO.setCardName( carDTO.getCardName() );
        greenCarPO.setCardColor( carDTO.getCardColor() );
        greenCarPO.setGender( carDTO.getGender() );

        return greenCarPO;
    }

    @Override
    public List<GreenCarPO> toGreens(List<CarDTO> carDTOS) {
        if ( carDTOS == null ) {
            return null;
        }

        List<GreenCarPO> list = new ArrayList<GreenCarPO>( carDTOS.size() );
        for ( CarDTO carDTO : carDTOS ) {
            list.add( toGreen( carDTO ) );
        }

        return list;
    }
}
