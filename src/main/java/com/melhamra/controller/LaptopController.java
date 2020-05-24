package com.melhamra.controller;

import com.melhamra.enity.LaptopDto;
import com.melhamra.mapper.MyMapper;
import com.melhamra.model.Laptop;
import com.melhamra.model.User;
import com.melhamra.repository.LaptopRepository;
import com.melhamra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {

    @Autowired
    private MyMapper myMapper;
    @Autowired
    private LaptopRepository laptopRepository;
    @Autowired
    private UserRepository userRepository;


    @PostMapping("/laptops")
    public void saveLaptop(@RequestBody LaptopDto laptopDto){
        User user = userRepository.getUserByID(laptopDto.getIdUser());
        Laptop laptop = myMapper.toLaptop(laptopDto);
        laptop.setUser(user);
        laptopRepository.saveLaptop(laptop);
    }

    @GetMapping("/laptops")
    public List<LaptopDto> getAllLaptop(){
        List<Laptop> laptopList = laptopRepository.getAllLaptops();
        return myMapper.toLaptopDtos(laptopList);
    }

    @GetMapping("/laptops/{id}")
    public LaptopDto getLaptopByID(@PathVariable int id){
        Laptop laptop = laptopRepository.getLaptopByID(id);
        return myMapper.toLaptopDto(laptop);
    }

    @DeleteMapping("/laptops/{id}")
    public void deleteLaptop(@PathVariable int id){
        Laptop laptop = laptopRepository.getLaptopByID(id);
        laptopRepository.deleteLaptop(laptop);
    }

    @PatchMapping("/laptops/{id}")
    public void updateLaptop(@PathVariable int id,
                        @RequestBody LaptopDto laptopDto){
        Laptop laptop = laptopRepository.getLaptopByID(id);
        laptop.setName(laptopDto.getName());
        laptop.setUser(userRepository.getUserByID(laptopDto.getIdUser()));
        laptopRepository.updateLaptop(laptop);
    }
}
