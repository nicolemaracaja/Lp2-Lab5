package br.edu.ufcg.computacao.complementaccc;

public class ComplementaCCCFacade {
	
	private ComplementaCCCController cont;
	
	boolean criarEstudante(String nome, String cpf, int senha, String matricula) {
		return cont.criarEstudante(nome, cpf, senha, matricula);
	}
	String[] exibirEstudantes(String cpf, int senha){
		//ADMIN
		return new String[1];
	}
	boolean alterarEstudante(String cpf, int senha, String tipoAlteracao, String novoValor) {
		return true;
	}
	String exibirAdmin(String cpf, int senha){
		return "";
		//ADMIN
	}
	boolean configurarNovoADMIN(String cpf, int senhaAtual, String cpfNovo, int senhaNova){
		return true;
		//ADMIN
	}
	boolean configurarSenhaADMIN(String cpf, int senhaAtual, int senhaNova){
		return true;
		//ADMIN
	}
	
	boolean adicionarItemFAQ(String cpf, int senha, String pergunta) {
		return true;
		//ADMIN
	}
	boolean adicionarItemFAQ(String cpf, int senha, String pergunta, String resposta) {
		return true;
		//ADMIN
	}
	boolean alteraRespostaItem(String cpf, int senha, int itemIndex, String resposta) {
		return true;
		//ADMIN
	}
	String[] listarFAQ() {
		return new String[1];
	}
	String[] listarFAQPorDestaque() {
		return new String[1];
	}
	boolean destacarItem(int itemIndex) {
		return true;
	}
	boolean atribuirTagsItemFAQ(String cpf, int senha,int itemIndex, String[] tags) {
		return true;
		//ADMIN
	}
	String[] buscarItemFAQ(String[] tags) {
		return new String[1];
	}
	
	String criarAtividadeMonitoriaEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		return "";
	}
	boolean alterarDescricaoAtividade(String cpf, int senha, String codigoAtividade, String descricao) {
		return true;
	}
	boolean alterarComprovacaoAtividade(String cpf, int senha, String codigoAtividade, String linkComprovacao) {
		return true;
	}
	String criarAtividadePesquisaExtensaoEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		return "";
	}
	String criarAtividadeEstagioEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		return "";
	}
	String criarAtividadePublicacaoEmEstudante(String cpf, int senha, String tipo, String tituloArtigo, String doi, String qualis) {
		return "";
	}
	double creditosAtividade(String cpf, int senha, String codigoAtividade) {
		return 0;
	}
	int criarRelatorioCompleto(String cpf, String senha) {
		return 0;
	}
	int criarRelatorioResumido(String cpf, String senha) {
		return 0;
	}
	int criarRelatorioPorATV(String cpf, String senha, String tipoAtividade) {
		return 0;
	}
	String exibirRelatorio(String cpf, String senha, int indexRelatorio) {
		return "";
	}

}
