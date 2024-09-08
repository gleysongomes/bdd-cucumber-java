package br.com.alura.leilao.acceptance.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PropondoLanceSteps {

	private Lance lance;

	private Leilao leilao;

	private List<Lance> lances;

	@Before
	public void setUp() {
		this.lances = new ArrayList<>();
		leilao = new Leilao("Tablet teste");
	}

	@Dado("um lance valido")
	public void dado_um_lance_valido() {
		Usuario usuario = new Usuario("teste");
		lance = new Lance(usuario, BigDecimal.TEN);
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

	@Dado("um lance de {double} reais do usuario {string}")
	public void um_lance_de_reais_do_usuario(Double valor, String nomeUsuario) {
		Lance lance = new Lance(new Usuario(nomeUsuario), new BigDecimal(valor));
		lances.add(lance);
	}

	@Quando("propoe varios lances ao leilao")
	public void propoe_varios_lances_ao_leilao() {
		this.lances.forEach(lance -> leilao.propoe(lance));
	}

	@Entao("os lances sao aceitos")
	public void os_lances_sao_aceitos() {
		assertEquals(this.lances.size(), leilao.getLances().size());
		assertEquals(this.lances.get(0).getValor(), leilao.getLances().get(0).getValor());
		assertEquals(this.lances.get(1).getValor(), leilao.getLances().get(1).getValor());
	}

	@Dado("um lance invalido de {double} reais do usuario {string}")
	public void um_lance_invalido_de_reais_do_usuario(Double valor, String nomeUsuario) {
		lance = new Lance(new BigDecimal(valor));
	}

	@Entao("o lance nao e aceito")
	public void o_lance_nao_e_aceito() {
		assertEquals(0, leilao.getLances().size());
	}

	@Entao("o segundo lance nao e aceito")
	public void o_segundo_lance_nao_e_aceito() {
		assertEquals(1, leilao.getLances().size());
		assertEquals(this.lances.get(0).getValor(), leilao.getLances().get(0).getValor());
	}

	@Dado("dois lances")
	public void dois_lances(DataTable dataTable) {
		List<Map<String, String>> valores = dataTable.asMaps();
		for (Map<String, String> mapa : valores) {
			String valor = mapa.get("valor");
			String nome = mapa.get("nomeUsuario");
			Lance lance = new Lance(new Usuario(nome), new BigDecimal(valor));
			lances.add(lance);
		}
	}

	@Dado("varios lances validos")
	public void varios_lances_validos(List<String> valores) {
		Usuario usuario = new Usuario("teste");
		for (String valor : valores) {
			Lance lance = new Lance(usuario, new BigDecimal(valor));
			lances.add(lance);
		}
	}
}
