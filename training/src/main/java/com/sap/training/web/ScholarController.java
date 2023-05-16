package com.sap.training.web;

import com.sap.training.model.Scholar;
import com.sap.training.service.ScholarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/scholar")
public class ScholarController {
    Logger logger = LoggerFactory.getLogger(ScholarController.class);

    @Autowired
    public ScholarService scholarService;

    @PostMapping
    public HttpEntity<Scholar> addScholar(@RequestBody Scholar scholar) {
        Scholar res;
        logger.info("Request body: " + scholar);
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if(scholarService.addScholar(scholar)) {
            status = HttpStatus.CREATED;
            res = scholar;
        } else
            res = new Scholar();
        return new ResponseEntity<>(res, status);
    }

    @GetMapping
    public HttpEntity<List<Scholar>> listAllScholar() {
        HttpStatus status = HttpStatus.OK;
        List<Scholar> res = scholarService.getAllScholars();
        return new ResponseEntity<>(res, status);
    }

//    @GetMapping("/{id}")
//    public HttpEntity<List<Scholar>> getScholarById (@RequestBody long id) {
//
//    }
}
