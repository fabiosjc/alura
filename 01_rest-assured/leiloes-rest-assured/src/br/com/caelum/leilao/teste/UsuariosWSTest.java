package br.com.caelum.leilao.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.path.xml.XmlPath;

import br.com.caelum.leilao.modelo.Usuario;

import static com.jayway.restassured.RestAssured.*;
import static org.junit.Assert.assertNull;

public class UsuariosWSTest {

    private Usuario mauricio;
    private Usuario guilherme;

    @Before
    public void setUp() {
        mauricio =  new Usuario(1L, "Mauricio Aniche", "mauricio.aniche@caelum.com.br");
        guilherme =  new Usuario(2L, "Guilherme Silveira", "guilherme.silveira@caelum.com.br");
    }

    @Test
    public void deveRetornarListaUsuarios() {
        XmlPath path = given().header("Accept", "application/xml").get("/usuarios").andReturn().xmlPath();

        List<Usuario> usuarios = path.getList("list.usuario", Usuario.class);

        assertEquals(mauricio, usuarios.get(0));
        assertEquals(guilherme, usuarios.get(1));
    }

    @Test
    public void deveRetornarUsuarioPeloId() {
        JsonPath path = given()
            .header("Accept", "application/json")
            .parameter("usuario.id", 1)
            .get("/usuarios/show")
            .andReturn()
            .jsonPath();

        Usuario usuario = path.getObject("usuario", Usuario.class);

        assertEquals(mauricio, usuario);

        // mostrando como usar o getString
        assertEquals(path.getString("usuario.nome"), "Mauricio Aniche");
    }

    @Test
    public void deveAdicionarUmUsuario() {
        Usuario joao = new Usuario("João da Silva", "joao@dasilva.com");

        XmlPath path = given()
                    .header("Accept", "application/xml")
                    .contentType("application/xml")
                    .body(joao)
                .expect()
                    .statusCode(200)
                .when()
                    .post("/usuarios")
                .andReturn()
                    .xmlPath();

        Usuario resposta = path.getObject("usuario", Usuario.class);

        assertEquals("João da Silva", resposta.getNome());
        assertEquals("joao@dasilva.com", resposta.getEmail());

        // deleta usuário recem criado
        given()
            .contentType("application/xml")
            .body(resposta)
        .expect()
            .statusCode(200)
        .when()
            .delete("/usuarios/deleta")
        .andReturn()
            .asString();
    }

}
