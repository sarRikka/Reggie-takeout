package com.cyy.takeout;

import com.cyy.takeout.entity.AddressBook;
import com.cyy.takeout.mapper.AddressBookMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class AddressBookTest {
    
    @Autowired
    AddressBookMapper mapper;;
    
    @Test void Test()
    {
        AddressBook addressBook=new AddressBook();
        addressBook.setUserId((long)123);
        addressBook.setPhone("12312312");
        addressBook.setConsignee("dsadsa");
        addressBook.setSex(1);
        
        List<AddressBook> list = mapper.list(addressBook);
        log.info(list.toString());
        //log.info(byId.toString());
    }

    @Test void jjkl()
    {
        int sum;
        sum=100*(1+100)/2;
        System.out.println(sum);
    }
    
    
}
