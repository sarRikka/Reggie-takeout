package com.cyy.takeout.mapper;

import com.cyy.takeout.common.R;
import com.cyy.takeout.entity.AddressBook;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressBookMapper {

    public boolean insert(AddressBook addressBook);

    public AddressBook getDefault();

    public boolean setDefault(Long id);
    
    public boolean set0Default();

    public List<AddressBook> list(AddressBook addressBook);

    public AddressBook getById(Long id);

    public AddressBook getByUserId(Long userId);
    
}
