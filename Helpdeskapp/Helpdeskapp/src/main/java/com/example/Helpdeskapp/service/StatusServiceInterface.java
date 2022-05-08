package com.example.Helpdeskapp.service;

import com.example.Helpdeskapp.model.StatusModel;

import java.util.List;
import java.util.Map;

public interface StatusServiceInterface {
    public List<StatusModel> findAllStatus();
    public StatusModel AddStatus( StatusModel statusModel);
    public StatusModel findStatusById( Long id);
    public StatusModel updateStatus(Long id,  StatusModel statusModel);
    public Map<String,Boolean> deleteStatus(Long id);

}
