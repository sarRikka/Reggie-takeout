package com.cyy.takeout.service;

import com.cyy.takeout.common.R;
import com.cyy.takeout.entity.AddressBook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AddressBookService {

    public AddressBook save(AddressBook addressBook);

    
    public AddressBook getDefault();

    
    public AddressBook updateDefault(AddressBook addressBook);

    
    public List<AddressBook> list(AddressBook addressBook);

    
    public AddressBook getById(Long id);
    
}
