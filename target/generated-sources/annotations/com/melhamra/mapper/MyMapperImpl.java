package com.melhamra.mapper;

import com.melhamra.enity.LaptopDto;
import com.melhamra.enity.UserDto;
import com.melhamra.model.Laptop;
import com.melhamra.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-19T17:52:02+0000",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 13.0.1 (Oracle Corporation)"
)
@Component
public class MyMapperImpl implements MyMapper {

    @Override
    public UserDto toUserDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( entity.getId() );
        userDto.setName( entity.getName() );

        return userDto;
    }

    @Override
    public User toUser(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setName( dto.getName() );

        return user;
    }

    @Override
    public Laptop toLaptop(LaptopDto laptopDto) {
        if ( laptopDto == null ) {
            return null;
        }

        Laptop laptop = new Laptop();

        laptop.setId( laptopDto.getId() );
        laptop.setName( laptopDto.getName() );

        return laptop;
    }

    @Override
    public List<User> toUsers(List<UserDto> userDtos) {
        if ( userDtos == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userDtos.size() );
        for ( UserDto userDto : userDtos ) {
            list.add( toUser( userDto ) );
        }

        return list;
    }

    @Override
    public List<UserDto> toUserDtos(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( users.size() );
        for ( User user : users ) {
            list.add( toUserDto( user ) );
        }

        return list;
    }

    @Override
    public List<Laptop> toLaptops(List<LaptopDto> laptopDtos) {
        if ( laptopDtos == null ) {
            return null;
        }

        List<Laptop> list = new ArrayList<Laptop>( laptopDtos.size() );
        for ( LaptopDto laptopDto : laptopDtos ) {
            list.add( toLaptop( laptopDto ) );
        }

        return list;
    }

    @Override
    public List<LaptopDto> toLaptopDtos(List<Laptop> laptops) {
        if ( laptops == null ) {
            return null;
        }

        List<LaptopDto> list = new ArrayList<LaptopDto>( laptops.size() );
        for ( Laptop laptop : laptops ) {
            list.add( toLaptopDto( laptop ) );
        }

        return list;
    }
}
