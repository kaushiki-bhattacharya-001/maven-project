 package com.sap.training;

 import com.sap.training.dto.ScholarDto;
 import com.sap.training.model.Scholar;
 import com.sap.training.service.ScholarService;
 import com.sap.training.web.ScholarController;
 import org.junit.jupiter.api.Test;
 import org.mockito.Mock;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.test.context.SpringBootTest;
 import org.springframework.boot.test.mock.mockito.MockBean;
 import org.springframework.http.HttpStatus;

 import java.util.ArrayList;

 import static org.assertj.core.api.Assertions.assertThat;
 import static org.mockito.ArgumentMatchers.any;
 import static org.mockito.Mockito.when;

 @SpringBootTest
 class ScholarControllerTests {
     @Autowired
     private ScholarController scholarController;
     @MockBean
     private ScholarService scholarService;
     HttpStatus httpStatus = HttpStatus.CREATED;
     @MockBean
     private ScholarDto scholarDto;
     private final Scholar scholar = new Scholar();

     @Test
     void testAddScholar() {
         when(scholarDto.getFull_name()).thenReturn("ABC");
         when(scholarDto.getBatch()).thenReturn("2022-X");
         when(scholarService.addScholar(scholar)).thenReturn(Boolean.TRUE);
         assertThat(scholarController.addScholar(scholarDto)).isNotNull();
     }

     @Test
     void testListAllScholar() {
         when(scholarService.getAllScholars()).thenReturn(new ArrayList<Scholar>());
         assertThat(scholarController.listAllScholar()).isNotNull();
     }

     @Test
     void testGetScholarByBatch() {
         String batch = "2022-X";
         when(scholarService.getScholarByBatch(batch)).thenReturn(new ArrayList<Scholar>());
         assertThat(scholarController.getScholarByBatch(batch)).isNotNull();
     }

 }
