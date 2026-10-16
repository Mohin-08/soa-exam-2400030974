
package com.klef.soa.exam.service;

import java.util.List;

import com.klef.soa.exam.entity.Crud;

public interface CrudService {

    Crud addUser(Crud c);

    List<Crud> displayAllUsers();

    Crud displayUsersById(Long id);

    String deleteUserById(Long id);

}
