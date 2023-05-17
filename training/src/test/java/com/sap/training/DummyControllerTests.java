package com.sap.training;

import com.sap.training.web.DummyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DummyControllerTests {

    @Autowired
    private DummyController dummyController;

    @Test
    void testGetHelloWorld() {
        assertThat(dummyController.getHelloWorld()).isEqualTo("Hello World");
    }

    @Test
    void testGetHelloWorldWithParam() {
        String name = "In Java";
        assertThat(dummyController.getHelloWorldWithParam(name)).isEqualTo("Hello World, " + name);
    }

    @Test
    void testGetHelloWorldWithParams() {
        String param = "123";
        assertThat(dummyController.getHelloWorldWithParams(param)).isEqualTo("Hello World, Parameter Value: " + param);
    }

}
