package br.com.alura.leilao.acceptance.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PropondoLanceSteps {

	private Lance lance;
	
	private Leilao leilao;
	
	@Dado("um lance valido")
	public void dado_um_lance_valido() {
		Usuario usuario = new Usuario("teste");
		lance = new Lance(usuario, BigDecimal.TEN);
	}

	@Quando("propoe o lance")
	public void quando_propoe_o_lance() {
		leilao = new Leilao("Tablet teste");
		leilao.propoe(lance);
	}
	
	@Entao("o lance e aceito")
	public void entao_o_lance_e_aceito() {
		assertEquals(1, leilao.getLances().size());
		assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
	}
}
