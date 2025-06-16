package org.scoula.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Rootconfig.class})
@Log4j2
class TimeMapperTest {

    @Autowired
    private TimeMapper timeMapper;

    @Test
    @DisplayName("TimeMapper의getTime2()")
    void getTime() {
        log.info("getTime2");
        log.info(timeMapper.getTime2());
    }

}