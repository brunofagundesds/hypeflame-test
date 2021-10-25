Feature: Blog - Pesquisa
  

@acceptance     
    Scenario: Realizar pesquisa com sucesso
		Given que estou acessando o blog HypeFlame
		When clico na lupa para pesquisa
		And digito "BPM - Camunda"
		And clico em pesquisar
		Then sistema exibe apenas o arquivo pesquisado

@acceptance	
		Scenario: Realizar pesquisa com informacao invalida
		Given que estou acessando o blog HypeFlame
		When clico na lupa para pesquisa
		And digito artigo inexistente "ABC"
		And clico em pesquisar
		Then sistema exibe mensagem "Nenhum resultado"