package com.vivekkumar.projects.airBnbApp.dto;


import com.vivekkumar.projects.airBnbApp.entity.User;
import com.vivekkumar.projects.airBnbApp.entity.enums.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GuestDto {

    Long id;
    User user;
    String name;
    Gender gender;
    Integer age;
}
