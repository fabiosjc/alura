package br.com.caelum.leilao.teste;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.jayway.restassured.path.json.JsonPath;

import br.com.caelum.leilao.modelo.Leilao;
import br.com.caelum.leilao.modelo.Usuario;

public class LeilaoWSTest {
	
	@Test
	public void deveRetornarLeilaoPeloId() {
		JsonPath path = given()
				.parameter("leilao.id", 1)
				.header("Accept", "application/json")
				.get("leiloes/show")
				.andReturn().jsonPath();
		
		Leilao leilao = path.getObject("leilao", Leilao.class);
		
        Usuario mauricio = new Usuario(1l, "Mauricio Aniche", "mauricio.aniche@caelum.com.br");
		Leilao esperado = new Leilao(1l, "Geladeira", 800.0, mauricio, false);
		
		assertEquals(esperado, leilao);
		
	}
	
	@Test
	public void deveRetornarTotalDeLeiloesCadastrados() {
		JsonPath path = given()
				.header("Accept", "application/json")
				.get("leiloes/total")
				.andReturn().jsonPath();
		
		assertEquals(path.getInt("int"), 2);		
	} 

}
