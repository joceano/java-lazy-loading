package com.joceano.javalazyloading.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PedidoControllerTest {

    private static final Long ID_PEDIDO_EXISTENTE = 1L;
    private static final Long ID_PEDIDO_INEXISTENTE = -1L;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = port;
    }

    @Test
    public void deveRetornarStatus200_QuandoConsultaPedidoExistente() {
        RestAssured
            .given()
                .basePath("/pedido/{id}")
                .pathParam("id", ID_PEDIDO_EXISTENTE)
                .accept(ContentType.JSON)
            .when()
                .get()
            .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void deveRetornarStatus404_QuandoConsultaPedidoInexistente() {
        RestAssured
            .given()
                .basePath("/pedido/{id}")
                .pathParam("id", ID_PEDIDO_INEXISTENTE)
                .accept(ContentType.JSON)
            .when()
                .get()
            .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void deveRetornarStatus200_QuandoConsultaTodosOsPedidos() {
        RestAssured
            .given()
                .basePath("/pedido")
                .accept(ContentType.JSON)
            .when()
                .get()
            .then()
                .statusCode(HttpStatus.OK.value());
    }
}
