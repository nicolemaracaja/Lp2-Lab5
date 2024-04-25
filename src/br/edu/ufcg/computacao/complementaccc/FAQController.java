package br.edu.ufcg.computacao.complementaccc;

import java.util.*;

/**
 * Classe FAQController, que manipula as funções do FAQ.
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
     * Construtor de FAQController.
     * @param admin Administrador do sistema.
     */
    public FAQController(Admin admin) {
        this.faq = new ArrayList<>();
        this.admin = admin;
    }

    /**
     * Método que permite o administrador realizar as operações de sua responsabilidade.
     * @param cpf CPF do admin.
     * @param senha Senha do admin.
     * @return True, se o admin for autenticado, se não, false.
     */
    public boolean autenticar(String cpf, int senha) {
        return admin.getCpf().equals(cpf) && admin.autenticar(senha);
    }

    /**
     * 
     * @param cpf
     * @param senha
     * @param pergunta
     * @param resposta
     * @return
     */
    public boolean adicionarItemFAQ(String cpf, int senha, String pergunta, String resposta) {
        if (autenticar(cpf, senha)) {
            for (ItemFAQ item : faq) {
                if (item.getPergunta().equalsIgnoreCase(pergunta)) {
                    throw new IllegalArgumentException("PERGUNTA JÁ EXISTE!"); // Pergunta já existe
                }
            }
            faq.add(new ItemFAQ(pergunta, resposta));
            return true;
        }
        return false; // Não autenticado
    }

    /**
     * 
     * @param cpf
     * @param senha
     * @param pergunta
     * @return
     */
    public boolean adicionarItemFAQ(String cpf, int senha, String pergunta) {
        return adicionarItemFAQ(cpf, senha, pergunta, null); // Permite adicionar uma pergunta sem resposta inicial
    }

    /**
     * 
     * @param cpf
     * @param senha
     * @param itemIndex
     * @param resposta
     * @return
     */
    public boolean alteraRespostaItem(String cpf, int senha, int itemIndex, String resposta) {
        if (autenticar(cpf, senha)) {
            if (itemIndex >= 0 && itemIndex < faq.size()) {
                faq.get(itemIndex).setResposta(resposta);
                return true;
            }
        }
        return false; // Não autenticado ou índice inválido
    }

    /**
     * 
     * @param itemIndex
     * @return
     */
    public boolean destacarItem(int itemIndex) {
        if (itemIndex >= 0 && itemIndex < faq.size()) {
            faq.get(itemIndex).incrementarDestaque();
            return true;
        }
        return false; // Índice inválido
    }

    /**
     * 
     * @param cpf
     * @param senha
     * @param itemIndex
     * @param tags
     * @return
     */
    public boolean atribuirTagsItemFAQ(String cpf, int senha, int itemIndex, String[] tags) {
        if (autenticar(cpf, senha)) {
            if (itemIndex >= 0 && itemIndex < faq.size()) {
                faq.get(itemIndex).adicionarTags(tags);
                return true;
            }
        }
        return false; // Não autenticado ou índice inválido
    }

    /**
     * 
     * @return
     */
    public String[] listarFAQ() {
        String[] resultado = new String[faq.size()];
        for (int i = 0; i < faq.size(); i++) {
            resultado[i] = faq.get(i).toString();
        }
        return resultado;
    }

    /**
     * 
     * @return
     */
    public String[] listarFAQPorDestaque() {
        List<ItemFAQ> ordenadosPorDestaque = new ArrayList<>(faq);
        Collections.sort(ordenadosPorDestaque, Comparator.comparingInt(ItemFAQ::getDestaque).reversed()); //maior destaque primeiro
        String[] resultado = new String[ordenadosPorDestaque.size()];
        for (int i = 0; i < ordenadosPorDestaque.size(); i++) {
            resultado[i] = ordenadosPorDestaque.get(i).toString();
        }
        return resultado;
    }

    /**
     * 
     * @param tags
     * @return
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
