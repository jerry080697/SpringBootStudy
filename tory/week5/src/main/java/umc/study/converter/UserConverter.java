package umc.study.converter;

import umc.study.domain.User;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.UserRequestDTO;
import umc.study.web.dto.UserResponseDTO;

import java.time.LocalDateTime;

public class UserConverter {

    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user){
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getUserId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static User toUser(UserRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
        }

        return User.builder()
                .address(request.getAddress())
                //.specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .preferFoodCategory(request.getPreferCategory().toString())
                .build();
    }
}