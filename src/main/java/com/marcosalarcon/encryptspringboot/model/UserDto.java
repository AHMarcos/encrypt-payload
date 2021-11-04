package com.marcosalarcon.encryptspringboot.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String name;
    private String email;
    private Integer age;

    @Override
    public String toString() {
        return "{\n" +
                "    \"name\": \""+ name + "\",\n" +
                "    \"email\": \""+ email +"\",\n" +
                "    \"age\": "+ age +"\n" +
                "}";
    }
}
