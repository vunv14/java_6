package com.example.training_JAva6.Service.Impl;

import com.example.training_JAva6.Entity.Status;
import com.example.training_JAva6.Repository.StatusRepository;
import com.example.training_JAva6.Service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StatusServiceImpl implements StatusService {


    @Autowired
    StatusRepository statusRepository;

    @Override
    public List<Status> getAllStatus() {
        return statusRepository.listStatus();
    }
}
