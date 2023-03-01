package com.cyy.takeout.controller;

import com.cyy.takeout.common.R;
import com.cyy.takeout.entity.AddressBook;
import com.cyy.takeout.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/addressBook")
public class AddressController {
    
    @Autowired
    AddressBookService service;
    
    @PostMapping
    public R<AddressBook> save(@RequestBody AddressBook addressBook,HttpServletRequest request)
    {
        addressBook.setUserId((long)request.getSession().getAttribute("user"));
        return R.success(service.save(addressBook));
    }
    
    @GetMapping("/default")
    public R<AddressBook> getDefault()
    {
        return R.success(service.getDefault());
    }
    
    @PutMapping("/default")
    public R updateDefault(@RequestBody AddressBook addressBook)
    {
        return R.success(service.updateDefault(addressBook));
    }
    
    @GetMapping("/list")
    public R<List<AddressBook>> list(AddressBook addressBook, HttpServletRequest request)
    {
        long user = (Long)request.getSession().getAttribute("user");
        addressBook.setUserId(user);
        List<AddressBook> list = service.list(addressBook);
        return R.success(list);
        
    }
    
    @GetMapping("/{id}")
    public R<AddressBook> getById(@PathVariable Long id)
    {
        return R.success(service.getById(id));
    }
    
}
