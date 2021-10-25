package br.hypeflame.acceptance;

import org.openqa.selenium.By;

import br.hypeflame.util.Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Blog {

	@Given("que estou acessando o blog HypeFlame")
	public void que_estou_acessando_o_blog_hype_flame() throws Exception {
		Util.selectBrowser(Util.getPropertyValue("browser"));
		Util.driver.get(Util.getPropertyValue("url"));
	}

	@When("clico na lupa para pesquisa")
	public void clico_na_lupa_para_pesquisa() {
		Util.driver.findElement(By.id("header-search")).click();

	}

	@When("digito {string}")
	public void digito(String string) {
		Util.digitar("//input[contains(@placeholder,'Pesquise aqui...')]", "BPM - Camunda");

	}
	
	@When("digito artigo inexistente {string}")
	public void digitoArtigoInexistente(String string) {
		Util.digitar("//input[contains(@placeholder,'Pesquise aqui...')]", "ABC");
	}

	@When("clico em pesquisar")
	public void clico_em_pesquisar() {
		Util.click("//button[contains(@type,'submit')]");

	}

	@Then("sistema exibe apenas o arquivo pesquisado")
	public void sistema_exibe_apenas_o_arquivo_pesquisado() {
		Util.driver.findElement(By.xpath("//*[@id=\"post-1411\"]/header/h2/a")).getText()
				.equalsIgnoreCase("BPM â€“ Camunda");
		Util.driver.close();

	}
	

	@Then("sistema exibe mensagem {string}")
	public void sistema_exibe_mensagem(String string) {

		Util.driver.findElement(By.xpath("//*[@id=\"main\"]/section/header/div/p")).getText().equalsIgnoreCase(
				"Não encontramos nada para estes termos de busca. Tente novamente com palavras-chave diferentes.");
		Util.driver.close();

	}

}
