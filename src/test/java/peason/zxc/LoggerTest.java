package peason.zxc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {



    @Test
    public void test1(){
        String name = "zxc";
        String password = "123465";
        log.debug("debug...");
        log.info("info...");
        //写法1
        log.info("name: "+name+" ,password: "+password);
        //写法二
        log.info("name : {} ,password: {}",name,password);
        log.error("error...");
    }
}
