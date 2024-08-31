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

	private Lance lance10;

	private Lance lance15;

	@Dado("um lance valido")
	public void dado_um_lance_valido() {
		Usuario usuario = new Usuario("teste");
		lance = new Lance(usuario, BigDecimal.TEN);
		leilao = new Leilao("Tablet teste");
	}

	@Quando("propoe ao leilao")
	public void quando_propoe_ao_leilao() {
		leilao.propoe(lance);
	}

	@Entao("o lance e aceito")
	public void entao_o_lance_e_aceito() {
		assertEquals(1, leilao.getLances().size());
		assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
	}

	@Dado("varios lances validos")
	public void varios_lances_validos() {
		Usuario usuario1 = new Usuario("Teste1");
		lance10 = new Lance(usuario1, BigDecimal.TEN);

		Usuario usuario2 = new Usuario("Teste2");
		lance15 = new Lance(usuario2, new BigDecimal("15.0"));

		leilao = new Leilao("Tablet teste");
	}

	@Quando("propoe varios lances ao leilao")
	public void propoe_varios_lances_ao_leilao() {
		leilao.propoe(lance10);
		leilao.propoe(lance15);
	}

	@Entao("os lances sao aceitos")
	public void os_lances_sao_aceitos() {
		assertEquals(2, leilao.getLances().size());
		assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
		assertEquals(new BigDecimal("15.0"), leilao.getLances().get(1).getValor());
	}
}
