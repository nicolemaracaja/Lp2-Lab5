package br.edu.ufcg.computacao.complementaccc;

import java.util.*;

/**
 * Fachada do sistema ComplementaCCC, que manipula todas as funções.
 * @author Nicole Brito Maracajá - 123111413.
 */
public class ComplementaCCCFacade {
	
	/**
	 * Controller de Usuário, para manipular as funções dos usuários.
	 */
	private UsuarioController uc;
	
	/**
	 * Controller de FAQ, para manipular as funções do FAQ.
	 */
	private FAQController fc;
	
	/**
	 * Controller de Atividade, para manipular as funções da Atividade.
	 */
	private AtividadeController ac;
	
	/**
	 * Controller de Relatório, para manipular as funções do Relatório.
	 */
	private RelatorioController rc;
	
	/**
	 * Administrador do sistema, que será instanciado em UsuárioController.
	 */
	private Admin admin = uc.getAdmin();
	
	/**
	 * Constrói a fachada ComplementaCCC.
	 */
	public ComplementaCCCFacade() {
		this.uc = new UsuarioController();
		this.fc = new FAQController(admin);
		this.ac = new AtividadeController(uc.getEstudantes());
	}
	
	/**
     * Cria um estudante com base em seu nome, seu cpf, sua senha e sua matrícula.
     * @param nome Nome do estudante.
     * @param cpf CPF do estudante.
     * @param senha Senha do estudante.
     * @param matricula Matrícula do estudante.
     * @return true se a alteração foi bem sucedida, se não, false.
     */
    public boolean criarEstudante(String nome, String cpf, String senha, String matricula) {
        return uc.criarEstudante(nome, cpf, senha, matricula);
    }

    /**
     * Exibe todos os estudantes se autenticado com admin.
     * @param cpfAdmin CPF do admin.
     * @param senhaAdmin Senha do admin.
     * @return Array de strings com informações dos estudantes, ou null se a autenticação falhar.
     */
    public String[] exibirEstudantes(String cpfAdmin, String senhaAdmin) {
        return uc.exibirEstudantes(admin.getCpf(), admin.getSenha());
    }

    /**
     * Altera dados de um estudante.
     * @param cpf CPF do estudante.
     * @param senha Senha do estudante.
     * @param tipoAlteracao Tipo de alteração ("nome", "matricula", "senha").
     * @param novoValor Novo valor para a alteração.
     * @return true se a alteração foi bem-sucedida, se não, false.
     */
    public boolean alterarEstudante(String cpf, String senha, String tipoAlteracao, String novoValor) {
        return uc.alterarEstudante(cpf, senha, tipoAlteracao, novoValor);
    }

    /**
     * Exibe informações do admin se autenticado.
     * @param cpfAdmin CPF do admin.
     * @param senhaAdmin Senha do admin.
     * @return String com informações do admin, ou null se a autenticação falhar.
     */
    public String exibirAdmin(String cpfAdmin, String senhaAdmin) {
        return uc.exibirAdmin(admin.getCpf(), admin.getSenha());
    }

    /**
     * Configura ou reconfigura o admin com autenticação.
     * @param cpfAdmin CPF do admin.
     * @param senhaAtual Senha atual do admin.
     * @param nomeNovo Novo nome do admin.
     * @param cpfNovo Novo CPF do admin.
     * @param senhaNova Nova senha do admin.
     * @return true se a configuração foi bem sucedida, se não, false.
     */
    public boolean configurarNovoADMIN(String cpfAdmin, String senhaAtual, String nomeNovo, String cpfNovo, String senhaNova) {
        return uc.configurarNovoADMIN(admin.getCpf(), admin.getSenha(), nomeNovo, cpfNovo, senhaNova);
    }

    /**
     * Altera a senha do admin se autenticado.
     * @param cpfAdmin CPF do admin.
     * @param senhaAtual Senha atual do admin.
     * @param senhaNova Nova senha do admin.
     * @return true se a alteração foi bem sucedida, se não, false.
     */
    public boolean configurarSenhaADMIN(String cpfAdmin, String senhaAtual, String senhaNova) {
        return uc.configurarSenhaADMIN(admin.getCpf(), admin.getSenha(), senhaNova);
    }

    /**
     * Adiciona um item ao FAQ, contendo apenas uma pergunta.
     * @param cpf CPF do admin para autenticação.
     * @param senha Senha do admin para autenticação.
     * @param pergunta Pergunta do item.
     * @return True se foi adicionado, se não, false.
     */
	boolean adicionarItemFAQ(String cpf, String senha, String pergunta) {
		return fc.adicionarItemFAQ(admin.getCpf(), admin.getSenha(), pergunta);
		//ADMIN
	}
	
	/**
	 * Adiciona um item ao FAQ, contendo uma pergunta e uma resposta.
	 * @param cpf CPF do amdmin, para autenticação.
	 * @param senha Senha do admin, para autenticação.
	 * @param pergunta Pergunta do item.
	 * @param resposta Resposta do item.
	 * @return True se foi adicionado, se não, false.
	 */
	boolean adicionarItemFAQ(String cpf, String senha, String pergunta, String resposta) {
		return fc.adicionarItemFAQ(admin.getCpf(), admin.getSenha(), pergunta, resposta);
		//ADMIN
	}
	
	/**
	 * Altera a resposta de um item do FAQ.
	 * @param cpf CPF do admin, para autenticação.
	 * @param senha Senha do admin, para autenticação.
	 * @param itemIndex índice do item que quer alterar.
	 * @param resposta Resposta nova.
	 * @return True se foi alterado, se não, false.
	 */
	boolean alteraRespostaItem(String cpf, String senha, int itemIndex, String resposta) {
		return fc.alteraRespostaItem(admin.getCpf(), admin.getSenha(), itemIndex, resposta);
		//ADMIN
	}
	
	/**
	 * Lista os itens do FAQ.
	 * @return Uma representação textual do FAQ.
	 */
	String[] listarFAQ() {
		return fc.listarFAQ();
	}
	
	/**
	 * Lista os itens do FAQ, por ordem de popularidade.
	 * @return Uma representação textual ordenada do FAQ.
	 */
	String[] listarFAQPorDestaque() {
		return fc.listarFAQPorDestaque();
	}
	
	/**
	 * 
	 * @param itemIndex Índice do item que o usuário quer destacar.
	 * @return True, se tiver incrementado a popularidade, se não, false.
	 */
	boolean destacarItem(int itemIndex) {
		return fc.destacarItem(itemIndex);
	}
	
	/**
	 * 
	 * @param cpf CPF do admin, para autenticação.
	 * @param senha Senha do admin, para autenticação.
	 * @param itemIndex índice do item que se quer atribuir a tag.
	 * @param tags Array de tags que o item possui.
	 * @return True, se atribuiu alguma tag, se tiver tido algum problema, false.
	 */
	boolean atribuirTagsItemFAQ(String cpf, String senha,int itemIndex, List<String> tags) {
		return fc.atribuirTagsItemFAQ(admin.getCpf(), admin.getSenha(), itemIndex, tags);
		//ADMIN
	}
	
	/**
	 * Procura um item pelas tags dele.
	 * @param tags Tags de busca.
	 * @return Um array com os itens que possuem aquelas tags.
	 */
	String[] buscarItemFAQ(String[] tags) {
		return fc.buscarItemFAQ(tags);
	}
	
	/**
	 * Cria atividade do tipo monitoria.
	 * @param cpf CPF do estudante.
	 * @param senha Senha do estudante.
	 * @param tipo Tipo da atividade.
	 * @param unidadeAcumulada Quantidade de semestres de monitoria.
	 * @param disciplina Disciplina que o estudante aplica monitoria.
	 * @return codigoATV Código da atividade.
	 */
	String criarAtividadeMonitoriaEmEstudante(String cpf, String senha, String tipo, int unidadeAcumulada, String disciplina) {
		return ac.criarAtividadeMonitoria(cpf, senha, tipo, unidadeAcumulada, disciplina);		
	}
	
	/**
	 * Altera a descrição da atividade.
	 * @param cpf CPF do estudante.
	 * @param senha Senha do estudante.
	 * @param codigoAtividade Código da atividade.
	 * @param descricao Nova descrição da atividade.
	 * @return true, se alterar, se não, false.
	 */
	boolean alterarDescricaoAtividade(String cpf, String senha, String codigoAtividade, String descricao) {
		return ac.alterarDescricaoAtividade(cpf, senha, codigoAtividade, descricao);
	}
	
	/**
	 * Altera o link do documento comprobatório da atividade.
	 * @param cpf CPF do estudante.
	 * @param senha Senha do estudante.
	 * @param codigoAtividade Código da atividade.
	 * @param linkComprovacao Novo link de comprovação da atividade.
	 * @return true, se alterar, se não, false.
	 */
	boolean alterarComprovacaoAtividade(String cpf, String senha, String codigoAtividade, String linkComprovacao) {
		return ac.alterarComprovacaoAtividade(cpf, senha, codigoAtividade, linkComprovacao);
	}
	
	/**
	 * Cria atividade do tipo pesquisa de extensão.
	 * @param cpf CPF do estudante.
	 * @param senha Senha do estudante.
	 * @param tipo Tipo da atividade.
	 * @param unidadeAcumulada Quantidade de meses que a pesquisa de extensão dura.
	 * @param disciplina Disciplina.
	 * @return codigoATV Código da atividade.
	 */
	String criarAtividadePesquisaExtensaoEmEstudante(String cpf, String senha, String tipo, int unidadeAcumulada, String disciplina) {
		return ac.criarAtividadePesquisaExtensao(cpf, senha, tipo, unidadeAcumulada, disciplina);
	}
	
	/**
	 * Cria atividade do tipo estágio.
	 * @param cpf CPF do estudante.
	 * @param senha Senha do estudante.
	 * @param tipo Tipo da atividade.
	 * @param unidadeAcumulada Quantidade de horas do estágio.
	 * @param disciplina Disciplina.
	 * @return codigoATV Código da atividade.
	 */
	String criarAtividadeEstagioEmEstudante(String cpf, String senha, String tipo, int unidadeAcumulada, String disciplina) {
		return ac.criarAtividadeEstagio(cpf, senha, tipo, unidadeAcumulada, disciplina);
	}
	
	/**
	 * Cria atividade do tipo publicação.
	 * @param cpf CPF do estudante.
	 * @param senha Senha do estudante.
	 * @param tipo Tipo da atividade.
	 * @param tituloArtigo Título do artigo.
	 * @param doi DOI.
	 * @param qualis Qualis
	 * @return codigoATV Código da atividade.
	 */
	String criarAtividadePublicacaoEmEstudante(String cpf, String senha, String tipo, String tituloArtigo, String doi, String qualis) {
		return ac.criarAtividadePublicacao(cpf, senha, tipo, 0, tituloArtigo, doi, qualis);
	}
	
	/**
	 * Cálcula os créditos da atividade.
	 * @param cpf CPF do estudante.
	 * @param senha Senha do estudante.
	 * @param codigoAtividade Código da atividade.
	 * @return creditos Quantidade de créditos.
	 */
	double creditosAtividade(String cpf, String senha, String codigoAtividade) {
		return ac.calcularCreditos(cpf, senha, codigoAtividade);
	}
	
	/**
	 * Cria um relatório completo.
	 * @param cpf CPF do estudante.
	 * @param senha Senha do estudante.
	 * @return índice Índice do relatório recém-criado.
	 */
	int criarRelatorioCompleto(String cpf, String senha) {
		return rc.criarRelatorioCompleto(cpf, senha);
	}
	
	/**
	 * Cria um relatório resumido.
	 * @param cpf CPF do estudante.
	 * @param senha Senha do estudante.
	 * @return índice Índice do relatório recém-criado.
	 */
	int criarRelatorioResumido(String cpf, String senha) {
		return rc.criarRelatorioResumido(cpf, senha);
	}
	
	/**
	 * Crie um relatório por atividades.
	 * @param cpf CPF do estudante.
	 * @param senha Senha do estudante.
	 * @param tipoAtividade Tipo da atividade.
	 * @return indice Índice do relatório recém-criado.
	 */
	int criarRelatorioPorATV(String cpf, String senha, String tipoAtividade) {
		return rc.criarRelatorioPorATV(cpf, senha, tipoAtividade);
	}
	
	/**
	 * Exibe o relatório.
	 * @param cpf CPF do estudante.
	 * @param senha Senha do estudante.
	 * @param indexRelatorio Índice do relatório.
	 * @return índice Índice do relatório recém-criado.
	 */
	String exibirRelatorio(String cpf, String senha, int indexRelatorio) {
		return rc.exibirRelatorio(cpf, senha, indexRelatorio);
	}

}