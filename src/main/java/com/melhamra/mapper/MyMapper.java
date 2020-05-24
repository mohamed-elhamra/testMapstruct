package com.melhamra.mapper;

import com.melhamra.enity.LaptopDto;
import com.melhamra.enity.UserDto;
import com.melhamra.model.Laptop;
import com.melhamra.model.User;
import com.melhamra.repository.UserRepository;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import java.util.List;

@org.mapstruct.Mapper(componentModel = "spring")
public interface MyMapper {

    UserDto toUserDto(User entity);

    User toUser(UserDto dto);

    Laptop toLaptop(LaptopDto laptopDto);

    default LaptopDto toLaptopDto(Laptop laptop){
         if ( laptop == null ) {
             return null;
         }

         LaptopDto laptopDto = new LaptopDto();
         laptopDto.setId( laptop.getId() );
         laptopDto.setName( laptop.getName() );
         laptopDto.setIdUser( laptop.getUser().getId() );

         return laptopDto;
    }

    List<User> toUsers(List<UserDto> userDtos);

    List<UserDto> toUserDtos(List<User> users);

    List<Laptop> toLaptops(List<LaptopDto> laptopDtos);

    List<LaptopDto> toLaptopDtos(List<Laptop> laptops);


}
