package com.marcosalarcon.encryptspringboot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcosalarcon.encryptspringboot.helper.AESEncryptionDecryption;
import com.marcosalarcon.encryptspringboot.model.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EncrypterService {

    private final ObjectMapper objectMapper;

    public String objectEncrypt(String text) throws Exception {

        UserDto userDto = UserDto.builder()
                .name("Ciurlizza Ascencio")
                .email("ascencio.luyo@gmail.com")
                .age(20)
                .build();

        log.info("Plain Text : {}", userDto.toString());

        String valueEnc = AESEncryptionDecryption.encrypt(userDto.toString())
                .replaceAll("\\R", "");

        log.info("Encrypted : {}", valueEnc);

        return valueEnc;
    }

    public UserDto stringEncryptToObject(String string) throws Exception {
        log.info("For Decrypted : {}", string);

        String value =  AESEncryptionDecryption.decrypt(string);

        log.info("Decrypted : {}", value);

        return objectMapper.readValue(value, UserDto.class);
    }

}
