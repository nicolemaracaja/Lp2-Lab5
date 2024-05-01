package br.edu.ufcg.computacao.complementaccc;

import java.util.*;

/**
 * Classe FAQController, que manipula as funções do FAQ.
 * @author Nicole Brito Maracajá - 123111413.
 */
public class FAQController {

	/**
	 * Lista que representa o FAQ do sistema.
	 */
	private List<ItemFAQ> faq;
	
	/**
	 * Administrador do sistema ComplementaCCC.
	 */
    private Admin admin;
    
    /**
     * índice o item.
     */
    private int itemIndex;

    /**
     * Construtor de FAQController.
     * @param admin Administrador do sistema.
     */
    public FAQController() {
        this.faq = new ArrayList<>();
        this.admin = new Admin("admin", "000.000.000-00", "00000000");
        this.itemIndex = 0;

    }

    /**
     * Método que permite o administrador realizar as operações de sua responsabilidade.
     * @param cpf CPF do admin.
     * @param senha Senha do admin.
     * @return True, se o admin for autenticado, se não, false.
     */
    public boolean autenticar(String cpf, String senha) {
        return admin.getCpf().equals(cpf) && admin.autenticar(senha);
    }

    /**
     * Adiciona um item com resposta à FAQ.
     * @param cpf CPF do admin.
     * @param senha Senha do admin;
     * @param pergunta Pergunta do item.
     * @param resposta Resposta do item.
     * @return true, se adicionar, se não, false.
     */
    public boolean adicionarItemFAQ(String cpf, String senha, String pergunta, String resposta) {
        if (autenticar(cpf, senha)) {
            for (ItemFAQ item : faq) {
                if (item.getPergunta().equalsIgnoreCase(pergunta)) {
                    throw new IllegalArgumentException("PERGUNTA JÁ EXISTE!"); // Pergunta já existe
                }
            }
            faq.add(new ItemFAQ(pergunta, resposta));
            this.itemIndex++;
            return true;
        }
        throw new IllegalArgumentException("FALHA NA AUTENTICAÇÃO!"); // Não autenticado ou índice inválido
    }

    /**
     * Adiciona um item sem resposta à FAQ.
     * @param cpf CPF do admin.
     * @param senha Senha do admin.
     * @param pergunta Pergunta do item.
     * @return true, se tiver adicionado, se não, false.
     */
    public boolean adicionarItemFAQ(String cpf, String senha, String pergunta) {
        return adicionarItemFAQ(cpf, senha, pergunta, null); // Permite adicionar uma pergunta sem resposta inicial
    }

    /**
     * Altera a resposta de um item da FAQ.
     * @param cpf CPF do admin.
     * @param senha Senha do admin.
     * @param itemIndex índice do item.
     * @param resposta Nova resposta do item.
     * @return true, se tiver alterado, se não, false.
     */
    public boolean alteraRespostaItem(String cpf, String senha, int itemIndex, String resposta) {
        if (autenticar(cpf, senha)) {
            if (itemIndex >= 0 && itemIndex < faq.size()) {
                faq.get(itemIndex).setResposta(resposta);
                return true;
            }
        }
        throw new IllegalArgumentException("FALHA NA AUTENTICAÇÃO!"); // Não autenticado ou índice inválido
    }

    /**
     * Destaca um item da FAQ.
     * @param itemIndex índice do item que vai receber destaque.
     * @return true, se tiver destacado, se não, false.
     */
    public boolean destacarItem(int itemIndex) {
        if (itemIndex >= 0 && itemIndex < faq.size()) {
            faq.get(itemIndex).incrementarDestaque();
            return true;
        }
        throw new IllegalArgumentException("ÍNDICE INVÁLIDO!"); //índice inválido
    }

    /**
     * Atribui tags a um determinado item da FAQ.
     * @param cpf CPF do admin.
     * @param senha Senha do admin.
     * @param itemIndex índice o item.
     * @param tags Tags que serão atribuidas.
     * @return true, se tiver adicionado, se não, false.
     */
    public boolean atribuirTagsItemFAQ(String cpf, String senha, int itemIndex, List<String> tags) {
        if (autenticar(cpf, senha)) {
            if (itemIndex >= 0 && itemIndex < faq.size()) {
                faq.get(itemIndex).adicionarTags(tags);
                return true;
            }
        }
        throw new IllegalArgumentException("FALHA NA AUTENTICAÇÃO!"); // Não autenticado ou índice inválido
    }

    /**
     * Lista os items da FAQ.
     * @return resultado Representação textual dos itens.
     */
    public String[] listarFAQ() {
        String[] resultado = new String[faq.size()];
        for (int i = 0; i < faq.size(); i++) {
            resultado[i] = faq.get(i).toString();
        }
        return resultado;
    }

    /**
     * Lista os itens da FAQ por ordem de destaque.
     * @return resultado Representação textual dos itens ordenados.
     */
    public String[] listarFAQPorDestaque() {
        List<ItemFAQ> ordenadosPorDestaque = new ArrayList<>(faq);
        Collections.sort(ordenadosPorDestaque, new ComparadorFAQ()); //maior destaque primeiro
        String[] resultado = new String[ordenadosPorDestaque.size()];
        for (int i = 0; i < ordenadosPorDestaque.size(); i++) {
            resultado[i] = ordenadosPorDestaque.get(i).toString();
        }
        return resultado;
    }

    /**
     * Procura os itens a partir das tags.
     * @param tags Tags de busca.
     * @return resultado Representação textual dos itens.
     */
    public String[] buscarItemFAQ(String[] tags) {
        List<String> resultado = new ArrayList<>();
        List<String> buscaTags = List.of(tags);

        for (ItemFAQ item : faq) {
            if (item.contemAlgumaTag(buscaTags)) {
                resultado.add(item.toString());
            }
        }

        return resultado.toArray(new String[0]);
    }
}
