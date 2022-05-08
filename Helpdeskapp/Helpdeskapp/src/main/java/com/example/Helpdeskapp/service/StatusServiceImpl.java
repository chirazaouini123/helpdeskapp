package com.example.Helpdeskapp.service;

import com.example.Helpdeskapp.exception.ResourcesNotfoundException;
import com.example.Helpdeskapp.model.AgentModel;
import com.example.Helpdeskapp.model.CategoryModel;
import com.example.Helpdeskapp.model.StatusModel;
import com.example.Helpdeskapp.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class StatusServiceImpl implements StatusServiceInterface {
    private StatusRepository statusRepository;
    @Autowired
    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public List<StatusModel> findAllStatus() {
        return statusRepository.findAll();
    }

    @Override
    public StatusModel AddStatus(StatusModel statusModel) {
        return statusRepository.save(statusModel);
    }

    @Override
    public StatusModel findStatusById(Long id) {
        return statusRepository.findById(id).orElseThrow(()-> new ResourcesNotfoundException("status doesn't exist with id:"+ id));
    }

    @Override
    public StatusModel updateStatus(Long id, StatusModel statusModel) {
        StatusModel status=findStatusById(id);
        status.setTitle(status.getTitle());
        return  statusRepository.save(status);    }

    @Override
    public Map<String, Boolean> deleteStatus(Long id) {
        StatusModel agent=findStatusById(id);
        statusRepository.delete(agent);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }
}
