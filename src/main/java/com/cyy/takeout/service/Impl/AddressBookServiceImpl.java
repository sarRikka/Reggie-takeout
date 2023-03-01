package com.cyy.takeout.service.Impl;

import com.cyy.takeout.common.R;
import com.cyy.takeout.entity.AddressBook;
import com.cyy.takeout.mapper.AddressBookMapper;
import com.cyy.takeout.service.AddressBookService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class AddressBookServiceImpl implements AddressBookService{

    @Autowired
    AddressBookMapper addressBookMapper;
    
    @Override
    public AddressBook save(AddressBook addressBook) {
        
        addressBookMapper.insert(addressBook);
        return addressBook;
    }

    @Override
    public AddressBook getDefault() {
        return addressBookMapper.getDefault();
    }

    @Transactional
    @Override
    public AddressBook updateDefault(AddressBook addressBook) {
        addressBookMapper.set0Default();
        addressBookMapper.setDefault(addressBook.getId());
        return addressBook;
    }

    @Override
    public List<AddressBook> list(AddressBook addressBook) {
        return addressBookMapper.list(addressBook);
    }

    @Override
    public AddressBook getById(Long id) {
        return addressBookMapper.getById(id);
    }
}
