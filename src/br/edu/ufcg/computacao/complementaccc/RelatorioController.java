package br.edu.ufcg.computacao.complementaccc;

import java.util.List;

/**
 * Classe RelatórioController, que implementa as funções relacionadas a relatório.
 * @author Nicole Brito Maracajá - 123111413.
 */
public class RelatorioController {
	
	/**
	 * UsuarioController.
	 */
    private UsuarioController usuarioController;

    /**
     * Constrói o RelatorioController.
     * @param usuarioController O controller de usuário.
     */
    public RelatorioController(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    /**
     * Cria um relatório do tipo COMPLETO.
     * @param cpf CPF do estudante.
     * @param senha Senha do estudante.
     * @return indice índice do relatório recém-criado.
     */
    public int criarRelatorioCompleto(String cpf, String senha) {
        Estudante estudante = usuarioController.getEstudantes().get(cpf);
        if (estudante == null|| !estudante.autenticar(senha)) {
            throw new IllegalArgumentException("FALHA NA AUTENTICAÇÃO!");
        }

        RelatorioDetalhado relatorio = new RelatorioDetalhado(estudante.getNome(), estudante.getCpf(), estudante.getMatricula());
        estudante.getAtividades().values().forEach(relatorio::adicionarAtividade); // Adicionar todas as atividades ao relatório

        estudante.adicionarRelatorio(relatorio);
        return estudante.getRelatorios().size(); // Retorna o índice do relatório recém-criado
    }

    /**
     * Cria um relatório do tipo RESUMIDO.
     * @param cpf CPF do estudante.
     * @param senha Senha do estudante.
     * @return indice Índice do relatório recém-criado.
     */
    public int criarRelatorioResumido(String cpf, String senha) {
        Estudante estudante = usuarioController.getEstudantes().get(cpf);
        if (estudante == null || !estudante.autenticar(senha)) {
            throw new IllegalArgumentException("FALHA NA AUTENTICAÇÃO!");
        }

        RelatorioResumido relatorio = new RelatorioResumido(estudante.getNome(), estudante.getCpf(), estudante.getMatricula());
        estudante.getAtividades().values().forEach(relatorio::adicionarAtividade); // Adicionar todas as atividades ao relatório resumido

        estudante.adicionarRelatorio(relatorio);
        return estudante.getRelatorios().size(); // Retorna o índice do relatório recém-criado
    }

    /**
     * Cria um relatório do tipo RESUMIDO POR TIPO.
     * @param cpf CPF do estudante.
     * @param senha Senha do estudante.
     * @param tipoAtividade Tipo da atividade.
     * @return índice Índice do relatório recém-criado.
     */
    public int criarRelatorioPorATV(String cpf, String senha, String tipoAtividade) {
        Estudante estudante = usuarioController.getEstudantes().get(cpf);
        if (estudante == null || !estudante.autenticar(senha)) {
            throw new IllegalArgumentException("FALHA NA AUTENTICAÇÃO!");
        }

        RelatorioResumidoPorTipo relatorio = new RelatorioResumidoPorTipo(estudante.getNome(), estudante.getCpf(), estudante.getMatricula(), tipoAtividade);
        estudante.getAtividades().values().forEach(atividade -> {
            if (atividade.getTipo().equals(tipoAtividade)) {
                relatorio.adicionarAtividade(atividade); // Adicionar atividades do tipo correto
            }
        });

        estudante.adicionarRelatorio(relatorio);
        return estudante.getRelatorios().size(); // Retorna o índice do relatório recém-criado
    }

    /**
     * Exibe o relatório.
     * @param cpf CPF do estudante.
     * @param senha Senha do estudante.
     * @param indexRelatorio Índice do relatório.
     * @return índice Índice do relatório recém-criado.
     */
    public String exibirRelatorio(String cpf, String senha, int indexRelatorio) {
        Estudante estudante = usuarioController.getEstudantes().get(cpf);
        if (estudante == null || !estudante.autenticar(senha)) {
            throw new IllegalArgumentException("FALHA NA AUTENTICAÇÃO!");
        }

        List<Relatorio> relatorios = estudante.getRelatorios();
        if (indexRelatorio < 0 || indexRelatorio >= relatorios.size()) {
            throw new IndexOutOfBoundsException("Índice do relatório inválido");
        }

        Relatorio relatorio = relatorios.get(indexRelatorio); // Obter relatório pelo índice
        return relatorio.toString(); // Retorna a representação textual do relatório
    }
}

