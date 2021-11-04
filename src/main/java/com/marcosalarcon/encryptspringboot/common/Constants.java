package com.marcosalarcon.encryptspringboot.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
    public static final String ALGORITHM = "AES";
    public static final String myEncryptionKey = "ThisIsFoundation";
    public static final String UNICODE_FORMAT = "UTF8";
}
