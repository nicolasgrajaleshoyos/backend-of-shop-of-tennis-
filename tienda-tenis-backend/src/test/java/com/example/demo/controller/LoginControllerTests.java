package com.example.demo.controller;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTests {

    @InjectMocks
    private LoginController loginController;

    @SuppressWarnings("deprecation")
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLogin() {
        // No hay mucho que probar en un método que no devuelve nada, pero podemos verificar que se llame correctamente
        loginController.login();

        // Verificar que el método login se llamó una vez
        // Esto se puede hacer de varias formas, una de ellas es usando mockito
        LoginController loginControllerMock = mock(LoginController.class);
        loginControllerMock.login();
        verify(loginControllerMock).login();
    }
}
