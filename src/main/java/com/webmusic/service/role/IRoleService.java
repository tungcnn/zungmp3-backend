package com.webmusic.service.role;


import com.webmusic.model.Role;
import com.webmusic.service.IGeneral;

public interface IRoleService extends IGeneral<Role> {
    Role findByName(String name);
}
