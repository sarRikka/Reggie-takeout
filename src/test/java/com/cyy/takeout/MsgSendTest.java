package com.cyy.takeout;

import com.cyy.takeout.utils.MessageSendUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MsgSendTest {
    
    @Test
    public void sendTest()
    {
        try {
            MessageSendUtil.sendMsg("18074522112","1233");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
