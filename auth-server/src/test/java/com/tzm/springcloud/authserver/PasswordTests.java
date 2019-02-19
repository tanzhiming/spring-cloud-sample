package com.tzm.springcloud.authserver;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTests {

    @Test
    public void testPassword() {
        String pwd = new BCryptPasswordEncoder().encode("123456");
        System.out.println(pwd);
    }
}
