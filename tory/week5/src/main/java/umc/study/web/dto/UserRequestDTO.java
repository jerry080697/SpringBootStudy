package umc.study.web.dto;

import lombok.Getter;

public class UserRequestDTO {

    @Getter
    public static class JoinDto{
        String name;
        Integer gender;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        String address;
        //String specAddress;
        String preferCategory;
    }
}