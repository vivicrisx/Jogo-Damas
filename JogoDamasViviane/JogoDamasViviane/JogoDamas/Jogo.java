        
/**
* Armazena o tabuleiro e responsavel por posicionar as pecas.
* 
* @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
* @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
*/
public class Jogo {
        
    private Tabuleiro tabuleiro;
    private int turno = 0;
    private boolean obrigarAjogar;
    private Peca pecaObrigatoria;
    
    public Jogo() {
        tabuleiro = new Tabuleiro();
        criarPecas();
    }
        
    /**
     * Posiciona pe�as no tabuleiro.
     * Utilizado na inicializa�ao do jogo.
     */
    private void criarPecas() {
        for(int coluna = 0; coluna < 8; coluna++){
                if(coluna % 2 == 0){
                    Casa casa2 = tabuleiro.getCasa(coluna,0);
                    Peca peca2 = new Peca(casa2, Peca.PEDRA_BRANCA);
        }
        }
        for(int coluna = 0; coluna < 8; coluna++){
                if(coluna % 2 == 0){
                    Casa casa2 = tabuleiro.getCasa(coluna,2);
                    Peca peca2 = new Peca(casa2, Peca.PEDRA_BRANCA);
        }
        }
        for(int coluna = 0; coluna < 8; coluna++){
                if(coluna % 2 != 0){
                    Casa casa2 = tabuleiro.getCasa(coluna,1);
                    Peca peca2 = new Peca(casa2, Peca.PEDRA_BRANCA);
        }
        }
        
        for(int linha = 0; linha < 8; linha++){
                if(linha % 2 == 0){
                    Casa casa2 = tabuleiro.getCasa(linha,6);
                    Peca peca2 = new Peca(casa2, Peca.PEDRA_VERMELHA);
        }
        }
        for(int linha = 0; linha < 8; linha++){
                if(linha % 2 != 0){
                    Casa casa2 = tabuleiro.getCasa(linha,7);
                    Peca peca2 = new Peca(casa2, Peca.PEDRA_VERMELHA);
        }
        }
        for(int linha = 0; linha < 8; linha++){
                if(linha % 2 != 0){
                    Casa casa2 = tabuleiro.getCasa(linha,5);
                    Peca peca2 = new Peca(casa2, Peca.PEDRA_VERMELHA);
        }
        }
        
    }
    
    /**
     * Comanda uma Pe�a na posicao (origemX, origemY) fazer um movimento 
     * para (destinoX, destinoY).
     * 
     * @param origemX linha da Casa de origem.
     * @param origemY coluna da Casa de origem.
     * @param destinoX linha da Casa de destino.
     * @param destinoY coluna da Casa de destino.
     */
    public void moverPeca(int origemX, int origemY, int destinoX, int destinoY) {
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();
        int pedraTipo = origem.getPeca().getTipo(); //pega a peça e o seu tipo
        Peca pedraDest = destino.getPeca(); //verifica se o destino é uma casa vazia
        
        if(!obrigarAjogar){
            peca.moverAsPeca(origemX, origemY, destinoX, destinoY, this);
        } 
        else if(obrigarAjogar){
            if(this.pecaObrigatoria == origem.getPeca()){
                peca.moverAsPeca(origemX, origemY, destinoX, destinoY, this);
            } 
        }
    }
    
    
    /**
     * @return o Tabuleiro em jogo.
     */
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }   
    
    /**
     * return o turno
     */
    public int getTurno(){
        return turno;
    }
    
    /**
     * 
     * método turno, no qual, é chamado nos métodos de movimentos em Peca
     */
    public void setTurno(int turno){
        this.turno = turno;
    }
    
    /**
     * mudar o estado da variavel PecaObrigatoria
     */
    public void setPecaObrigatoria(int destinoX, int destinoY){
        this.pecaObrigatoria = tabuleiro.getCasa(destinoX, destinoY).getPeca();
    }
    
    /**
     * mudar o estado da variavel PecaObrigatoria
     */
    public void resetPecaObrigatoria(){
        this.pecaObrigatoria = null;
    }
    
    /**
     * mudar o estado da variavel ObrigarAjogar
     */
    public void setObrigarAjogar(){
        this.obrigarAjogar = true;
    }
    
    /**
     * mudar o estado da variavel ObrigarAjogar
     */
    public void resetObrigarAjogar(){
        this.obrigarAjogar = false;
    }
}  