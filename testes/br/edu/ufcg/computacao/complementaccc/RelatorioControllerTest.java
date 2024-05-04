package br.edu.ufcg.computacao.complementaccc;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 * Classe que testa as funcionalidades de RelatorioController.
 * @author Nicole Brito Maracajá - 123111413.
 */
public class RelatorioControllerTest {
    private RelatorioController rcBase;
    private UsuarioController ucBase;;
    private AtividadeController acBase;

    @BeforeEach
    public void setUp() {
        this.ucBase = new UsuarioController();
        this.acBase = new AtividadeController(ucBase.getEstudantes());
        ucBase.criarEstudante("Nicole", "000.000.000-00", "00000000", "123111413");
        this.rcBase = new RelatorioController(ucBase);
    }

    /**
     * CASO 1
     * Autenticação com falha da criação do relatório.
     */
    @Test
    public void testAutenticacaoFalha() {
        try {
            rcBase.criarRelatorioCompleto("000.000.000-00", "00000001");
            fail();
        }catch (IllegalArgumentException iae) {
        	assertEquals("FALHA NA AUTENTICAÇÃO!", iae.getMessage());
        }
    }

    /**
     * CASO 2
     * Criar relatório detalhado.
     */
    @Test
    public void testCriarRelatorioDetalhado() {
    	acBase.criarAtividadeMonitoria("000.000.000-00", "00000000", "MONITORIA", 2, "LP2"); //8 créditos
    	acBase.criarAtividadeEstagio("000.000.000-00", "00000000", "ESTAGIO", 300, "LP2"); //1 créditos

        // Cria relatório detalhado
        int indice = rcBase.criarRelatorioCompleto("000.000.000-00", "00000000");
        assertEquals(1, indice);

        // Exibe o relatório
        String relatorioTexto = rcBase.exibirRelatorio("000.000.000-00", "00000000", indice - 1);

        assertTrue(relatorioTexto.contains("Relatório Completo"));
        assertTrue(relatorioTexto.contains("ESTAGIO"));
        assertTrue(relatorioTexto.contains("MONITORIA"));
        assertTrue(relatorioTexto.contains("Créditos: 8.0")); //créditos da monitoria
        assertTrue(relatorioTexto.contains("Créditos: 5.0")); //créditos do estágio       
    }
    
    /**
     * CASO 3
     * Criar relatório detalhado com créditos insuficientes.
     */
    public void testCriarRelatorioDetalhadoCreditosInsuficientes() {
    	acBase.criarAtividadeMonitoria("000.000.000-00", "00000000", "MONITORIA", 2, "LP2"); //8 créditos
    	acBase.criarAtividadeEstagio("000.000.000-00", "00000000", "ESTAGIO", 120, "LP2"); //1 créditos

        // Cria relatório detalhado
        int indice = rcBase.criarRelatorioCompleto("000.000.000-00", "00000000");
        assertEquals(1, indice);

        // Exibe o relatório
        String relatorioTexto = rcBase.exibirRelatorio("000.000.000-00", "00000000", indice - 1);

        assertTrue(relatorioTexto.contains("Relatório Completo"));
        assertTrue(relatorioTexto.contains("ESTAGIO"));
        assertTrue(relatorioTexto.contains("MONITORIA"));
        assertTrue(relatorioTexto.contains("Créditos: 8.0")); //créditos da monitoria
        assertEquals(true, relatorioTexto.contains("Créditos: NÃO ATINGIU AINDA O VALOR MÍNIMO!")); //créditos do estágio  
    }

    /**
     * CASO 4
     * Criar relatório resumido.
     */
    @Test
    public void testCriarRelatorioResumido() {
    	// Adiciona algumas atividades para verificar sumarização
        acBase.criarAtividadeEstagio("000.000.000-00", "00000000", "ESTAGIO", 240, "LP2"); // Deve gerar créditos
        acBase.criarAtividadeEstagio("000.000.000-00", "00000000", "ESTAGIO", 120, "LP2"); // Deve ser insuficiente

        // Cria relatório resumido
        int indice = rcBase.criarRelatorioResumido("000.000.000-00", "00000000");
        assertEquals(1, indice);

        // Exibe o relatório resumido
        String relatorioTexto = rcBase.exibirRelatorio("000.000.000-00", "00000000", indice - 1);

        assertTrue(relatorioTexto.contains("Relatório Resumido"));
        assertTrue(relatorioTexto.contains("ESTAGIO")); // Atividades de estágio
        assertTrue(relatorioTexto.contains("Créditos Acumulados: 4.0")); // Créditos gerados para estágio
    }

    /**
     * CASO 5
     * Criar relatório por tipo de atividade.
     */
    @Test
    public void testCriarRelatorioPorAtv() {
    	// Adiciona algumas atividades para verificar relatório por tipo
    	acBase.criarAtividadeEstagio("000.000.000-00", "00000000", "ESTAGIO", 240, "LP2"); // Deve gerar créditos
    	acBase.criarAtividadeEstagio("000.000.000-00", "00000000", "ESTAGIO", 120, "LP2"); // 8 créditos

        // Cria relatório por tipo de atividade
        int indice = rcBase.criarRelatorioPorATV("000.000.000-00", "00000000", "ESTAGIO");
        assertEquals(1, indice);

        // Exibe o relatório por tipo de atividade
        String relatorioTexto = rcBase.exibirRelatorio("000.000.000-00", "00000000", indice - 1);

        assertTrue(relatorioTexto.contains("Relatório por Atividade (ESTAGIO)"));
        assertTrue(relatorioTexto.contains("Créditos Acumulados: 6.0"));
    }

    /**
     * CASO 6
     * Tentar exibir um relatório inválido.
     */
    @Test
    public void testRelatorioInvalido() {
    	// Tenta acessar um índice inválido para relatório
        try {
            rcBase.exibirRelatorio("000.000.000-00", "00000000", 10); // Índice inválido
            fail();
        }catch(IndexOutOfBoundsException iae) {
        	assertEquals("ÍNDICE DO RELATÓRIO INVÁLIDO!", iae.getMessage());
        }
    }
}
