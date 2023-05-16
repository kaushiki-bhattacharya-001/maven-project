package com.sap.training.service;

import com.sap.training.model.Scholar;
import com.sap.training.repository.ScholarReppository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScholarService {
    Logger logger = LoggerFactory.getLogger(ScholarService.class);

    @Autowired
    public ScholarReppository scholarReppository;

    public boolean addScholar(Scholar scholar) {
        try {
            scholarReppository.save(scholar);
            return true;
        } catch (Exception e) {
            logger.error("Something went wrong: ", e);
            return false;
        }
    }

    public List<Scholar> getAllScholars() {
        List<Scholar> list;
        try {
            list = scholarReppository.findAll();
        } catch (Exception e) {
            logger.error("Something went wrong: ", e);
            list = new ArrayList<>();
        }
        return list;
    }

    public boolean deleteScholar(long id) {
        try {
            scholarReppository.deleteById(id);
            return true;
        } catch (Exception e) {
            logger.error("Something went wrong: ", e);
            return false;
        }
    }


}
