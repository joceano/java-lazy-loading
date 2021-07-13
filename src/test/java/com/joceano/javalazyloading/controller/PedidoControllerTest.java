package com.joceano.javalazyloading.controller;

import com.joceano.javalazyloading.dto.PedidoDto;
import com.joceano.javalazyloading.factory.PedidoFactoryTest;
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
    private static final Long ID_PEDIDO_EXCLUSAO_EXISTENTE = 2L;
    private static final Long ID_PEDIDO_EXCLUSAO_INEXISTENTE = -2L;
    private static final PedidoDto PEDIDO_DTO = new PedidoFactoryTest().getPedidoDto();

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
    public void deveRetornarStatus200_QuandoConsultaPedidoExistenteResumo() {
        RestAssured
            .given()
                .basePath("/pedido/{id}/resumo")
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
    public void deveRetornarStatus404_QuandoConsultaPedidoInexistenteResumo() {
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

    @Test
    public void deveRetornarStatus200_QuandoConsultaTodosOsPedidosResumo() {
        RestAssured
            .given()
                .basePath("/pedido/resumo")
                .accept(ContentType.JSON)
            .when()
                .get()
            .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void deveRetornarStatus204_QuandoExcluiPedidoExistente() {
        RestAssured
            .given()
                .basePath("/pedido/{id}")
                .pathParam("id", ID_PEDIDO_EXCLUSAO_EXISTENTE)
                .accept(ContentType.JSON)
            .when()
                .delete()
            .then()
                .statusCode(HttpStatus.NO_CONTENT.value());
    }

    @Test
    public void deveRetornarStatus404_QuandoExcluiPedidoInexistente() {
        RestAssured
            .given()
                .basePath("/pedido/{id}")
                .pathParam("id", ID_PEDIDO_EXCLUSAO_INEXISTENTE)
                .accept(ContentType.JSON)
            .when()
                .delete()
            .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void deveRetornarStatus201_QuandoIncluirPedido() {
        RestAssured
            .given()
                .basePath("/pedido")
                .body(PEDIDO_DTO)
                .contentType(ContentType.JSON)
            .when()
                .post()
            .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void deveRetornarStatus200_QuandoAlterarPedidoExistente() {
        PEDIDO_DTO.setId(ID_PEDIDO_EXISTENTE);
        RestAssured
            .given()
                .basePath("/pedido")
                .body(PEDIDO_DTO)
                .contentType(ContentType.JSON)
            .when()
                .put()
            .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void deveRetornarStatus404_QuandoAlterarPedidoInexistente() {
        PEDIDO_DTO.setId(ID_PEDIDO_INEXISTENTE);
        RestAssured
            .given()
                .basePath("/pedido")
                .body(PEDIDO_DTO)
                .contentType(ContentType.JSON)
            .when()
                .put()
            .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }
}
