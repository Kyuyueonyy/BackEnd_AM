package org.scoula.security;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class PasswordEncoderTests {

    //싱글톤으로 만든 암호화해주는 객체를 주입
    @Autowired
    private PasswordEncoder encoder;

    @Test
    public void testEncode() {
        String str = "1234";
        String enStr = encoder.encode(str); // 암호화
        log.info("password: " + enStr);
        String enStr2 = encoder.encode(str); // 암호화
        log.info("password: " + enStr2);
        log.info("match :" + encoder.matches(str, enStr)); // 비밀번호일치여부검사
        log.info("match :" + encoder.matches(str, enStr2)); // 비밀번호일치여부검사
    }
}

