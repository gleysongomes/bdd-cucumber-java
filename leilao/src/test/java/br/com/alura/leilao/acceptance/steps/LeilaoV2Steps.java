package br.com.alura.leilao.acceptance.steps;

import static org.junit.Assert.assertTrue;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import br.com.alura.leilao.e2e.pages.NovoLeilaoPage;

public class LeilaoV2Steps implements io.cucumber.java8.Pt {

	private LoginPage loginPage;

	private LeiloesPage leiloesPage;

	private NovoLeilaoPage novoLeilaoPage;

	private Browser browser;

	/*public LeilaoV2Steps() {
		Dado("um usuario logado", () -> {
			this.browser = new Browser();
			browser.seed();
			loginPage = browser.getLoginPage();
			leiloesPage = loginPage.realizaLoginComoFulano();
		});

		Quando("acessa a pagina de novo leilao", () -> {
			novoLeilaoPage = leiloesPage.visitaPaginaParaCriarUmNovoLeilao();
		});

		Quando("preeche o formulario com dados validos", () -> {
			leiloesPage = novoLeilaoPage.preencheForm("PC Novo", "1500", "01/11/2020");
		});

		Entao("volta para a pagina de leiloes", () -> {
			assertTrue(leiloesPage.estaNaPaginaDeLeiloes());
		});

		Entao("o novo leilao aparece na tabela", () -> {
			assertTrue(leiloesPage.existe("PC Novo", "1500", "01/11/2020"));
			browser.clean();
		});
	}*/
}
