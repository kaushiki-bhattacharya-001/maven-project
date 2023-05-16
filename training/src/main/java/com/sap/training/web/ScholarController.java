package com.sap.training.web;

import com.sap.training.dto.ScholarDto;
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
    public HttpEntity<Scholar> addScholar(@RequestBody ScholarDto scholarDto) {
        Scholar res;
        logger.info("Request body: " + scholarDto);
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        Scholar scholar = new Scholar();
        scholar.setFullName(scholarDto.getFull_name());
        scholar.setBatch(scholarDto.getBatch());
        if(scholarService.addScholar(scholar)) {
            status = HttpStatus.CREATED;
            res = scholar;
        } else
            res = new Scholar();
        return new ResponseEntity<>(res, status);
    }

    @GetMapping("/")
    public HttpEntity<List<Scholar>> listAllScholar() {
        HttpStatus status = HttpStatus.OK;
        List<Scholar> res = scholarService.getAllScholars();
        return new ResponseEntity<>(res, status);
    }

    @GetMapping("/{batch}/")
    public HttpEntity<List<Scholar>> getScholarByBatch (@PathVariable String batch) {
          HttpStatus status = HttpStatus.OK;
          List<Scholar> res = scholarService.getScholarByBatch(batch);
          return new ResponseEntity<>(res, status);
    }
}
