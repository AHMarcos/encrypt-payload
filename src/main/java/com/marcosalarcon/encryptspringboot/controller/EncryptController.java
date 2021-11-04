package com.marcosalarcon.encryptspringboot.controller;

import com.marcosalarcon.encryptspringboot.model.UserDto;
import com.marcosalarcon.encryptspringboot.service.EncrypterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EncryptController {

    private final EncrypterService encrypterService;

    @PostMapping("/encrypt")
    public String encrypt(String text) throws Exception {
        return encrypterService.objectEncrypt(text);
    }

    @PostMapping("/decrypt")
    public UserDto decrypt(@RequestBody String text) throws Exception {
        return encrypterService.stringEncryptToObject(text);
    }

}
