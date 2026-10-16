
package com.klef.soa.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.exam.entity.Crud;
import com.klef.soa.exam.repository.CrudRepository;

@Service
public class CrudServiceImpl implements CrudService {

    @Autowired
    private CrudRepository repo;

    @Override
    public Crud addUser(Crud c) {
        return repo.save(c);
    }


    @Override
    public List<Crud> displayAllUsers() {
        return repo.findAll();
    }

    @Override
    public Crud displayUsersById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public String deleteUserById(Long id) {
        boolean flag = repo.existsById(id);

        if (flag) {
            repo.deleteById(id);
            return "Learning Module Deleted Successfully";
        } else {
            return "Learning Module ID Not Found";
        }
    }

}
