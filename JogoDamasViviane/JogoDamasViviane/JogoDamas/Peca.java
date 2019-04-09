                              
/**
* Representa uma Pe�a do jogo.
* Possui uma casa e um tipo associado.
* 
* @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
* @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
*/
public class Peca {
                            
    public static final int PEDRA_BRANCA = 0;
    public static final int DAMA_BRANCA = 2;
    public static final int PEDRA_VERMELHA = 1;
    public static final int DAMA_VERMELHA = 3;
    
    private Casa casa;
    private int tipo;
    private int turno = 0;
    public Peca(Casa casa, int tipo) {
        this.casa = casa;
        this.tipo = tipo;
        casa.colocarPeca(this);
        
    }
        
    /**
    * Movimenta a peca para uma nova casa.
    * @param destino nova casa que ira conter esta peca.
    */
        
        
    public void mover(Casa destino) {        
        casa.removerPeca();
        destino.colocarPeca(this);
        casa = destino;
    }   
        
                 
    /** 
    * MÉTODO PARA AS PEÇAS VERMELHA COMEREM AS PEÇAS BRANCAS */
        
    public void movComerPecaVerm(int origemX, int origemY, int destinoX, int destinoY, Jogo jogo){
        Tabuleiro tabuleiro = jogo.getTabuleiro();
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();
        //direçao 1
        if((destinoX == origemX - 2) && (destinoY == origemY - 2 )){
            Casa casaQUEPULA = tabuleiro.getCasa(origemX - 1, origemY - 1);
            if(casaQUEPULA.getPeca().getTipo() == PEDRA_BRANCA || casaQUEPULA.getPeca().getTipo() == DAMA_BRANCA){
                casaQUEPULA.removerPeca(); 
                peca.mover(destino);
                if(verificarAlvos(destinoX,destinoY,jogo) == true ){
                   jogo.setPecaObrigatoria(destinoX,destinoY);
                   jogo.setObrigarAjogar();
                }
                else if(verificarAlvos(destinoX,destinoY,jogo) == false){
                   jogo.resetPecaObrigatoria();
                   jogo.resetObrigarAjogar();
                   jogo.setTurno(0);
                }
            }
            if(destinoY == 0){
               Casa casa2 = tabuleiro.getCasa(destinoX, destinoY);
               Peca peca2 = new Peca(casa2, Peca.DAMA_VERMELHA);
               if(verificarAlvos(destinoX,destinoY,jogo) == true ){
                   jogo.setPecaObrigatoria(destinoX,destinoY);
                   jogo.setObrigarAjogar();
               }
               else if(verificarAlvos(destinoX,destinoY,jogo) == false){
                   jogo.resetPecaObrigatoria();
                   jogo.resetObrigarAjogar();
                   jogo.setTurno(0);
               }
            }
        }
        //direçao 2
        if((destinoX == origemX + 2) && (destinoY == origemY - 2 )){
            Casa casaQUEPULA = tabuleiro.getCasa(origemX + 1, origemY - 1);
            if(casaQUEPULA.getPeca().getTipo() == PEDRA_BRANCA || casaQUEPULA.getPeca().getTipo() == DAMA_BRANCA){
                casaQUEPULA.removerPeca(); 
                peca.mover(destino);
                if(verificarAlvos(destinoX,destinoY,jogo) == true ){
                   jogo.setPecaObrigatoria(destinoX,destinoY);
                   jogo.setObrigarAjogar();
                }
                 else if(verificarAlvos(destinoX,destinoY,jogo) == false){
                   jogo.resetPecaObrigatoria();
                   jogo.resetObrigarAjogar();
                   jogo.setTurno(0);
                }
            }
            if(destinoY == 0){
                Casa casa2 = tabuleiro.getCasa(destinoX, destinoY);
                Peca peca2 = new Peca(casa2, Peca.DAMA_VERMELHA);
                if(verificarAlvos(destinoX,destinoY,jogo) == true ){
                   jogo.setPecaObrigatoria(destinoX,destinoY);
                   jogo.setObrigarAjogar();
                }
                else if(verificarAlvos(destinoX,destinoY,jogo) == false){
                   jogo.resetPecaObrigatoria();
                   jogo.resetObrigarAjogar();
                   jogo.setTurno(0);
                }
            }
        }
        //movimento comer voltando em uma direçao
        if((destinoX == origemX + 2) && (destinoY == origemY + 2 )){
            Casa casaQUEPULA = tabuleiro.getCasa(origemX + 1, origemY + 1);  
            if(casaQUEPULA.getPeca().getTipo() == PEDRA_BRANCA || casaQUEPULA.getPeca().getTipo() == DAMA_BRANCA){
                casaQUEPULA.removerPeca(); 
                peca.mover(destino);
                if(verificarAlvos(destinoX,destinoY,jogo) == true ){
                   jogo.setPecaObrigatoria(destinoX,destinoY);
                   jogo.setObrigarAjogar();
                }
                else if(verificarAlvos(destinoX,destinoY,jogo) == false){
                   jogo.resetPecaObrigatoria();
                   jogo.resetObrigarAjogar();
                   jogo.setTurno(0);
                } 
            }
        }  
        //movimento comer voltando em outra direçao
        if((destinoX == origemX - 2) && (destinoY == origemY + 2 )){
            Casa casaQUEPULA = tabuleiro.getCasa(origemX - 1, origemY + 1);
            if(casaQUEPULA.getPeca().getTipo() == PEDRA_BRANCA || casaQUEPULA.getPeca().getTipo() == DAMA_BRANCA){
                casaQUEPULA.removerPeca(); 
                peca.mover(destino);
                if(verificarAlvos(destinoX,destinoY,jogo) == true ){
                   jogo.setPecaObrigatoria(destinoX,destinoY);
                   jogo.setObrigarAjogar();
                }
                else if(verificarAlvos(destinoX,destinoY,jogo) == false){
                   jogo.resetPecaObrigatoria();
                   jogo.resetObrigarAjogar();
                   jogo.setTurno(0);
                }
            }
        }
    }   
            
    /** 
    MÉTODO PARA AS PEÇAS BRANCAS COMEREM AS VERMELHAS */
    public void movComerPecaBranca(int origemX, int origemY, int destinoX, int destinoY, Jogo jogo){
        Tabuleiro tabuleiro = jogo.getTabuleiro();
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();
        
        //direçao 1 e criaçao da dama quando come
        if((destinoX == origemX + 2) && (destinoY == origemY + 2 )){
            Casa casaQUEPULA = tabuleiro.getCasa(origemX + 1, origemY + 1);  
            if(casaQUEPULA.getPeca().getTipo() == PEDRA_VERMELHA || casaQUEPULA.getPeca().getTipo() == DAMA_VERMELHA){
                casaQUEPULA.removerPeca(); 
                peca.mover(destino);
                if(verificarAlvos(destinoX,destinoY,jogo) == true ){
                    jogo.setPecaObrigatoria(destinoX,destinoY);
                    jogo.setObrigarAjogar();
                }
                else if(verificarAlvos(destinoX,destinoY,jogo) == false){
                    jogo.resetPecaObrigatoria();
                    jogo.resetObrigarAjogar();
                    jogo.setTurno(1);
                }
            }    
            if(destinoY == 7){
                Casa casa2 = tabuleiro.getCasa(destinoX, destinoY);
                Peca peca2 = new Peca(casa2, Peca.DAMA_BRANCA);
                if(verificarAlvos(destinoX,destinoY,jogo) == true ){
                    jogo.setPecaObrigatoria(destinoX,destinoY);
                    jogo.setObrigarAjogar();
                }
                else if(verificarAlvos(destinoX,destinoY,jogo) == false){
                    jogo.resetPecaObrigatoria();
                    jogo.resetObrigarAjogar();
                    jogo.setTurno(1);
                }
            }
        }

        //direçao 2 e criaçao da dama quando come
        if((destinoX == origemX - 2) && (destinoY == origemY + 2 )){
            Casa casaQUEPULA = tabuleiro.getCasa(origemX - 1, origemY + 1); // recebe as coordenadas de uma casa, no caso, a frente
            if(casaQUEPULA.getPeca().getTipo() == PEDRA_VERMELHA || casaQUEPULA.getPeca().getTipo() == DAMA_VERMELHA){
                casaQUEPULA.removerPeca(); 
                peca.mover(destino);
                if(verificarAlvos(destinoX,destinoY,jogo) == true ){
                    jogo.setPecaObrigatoria(destinoX,destinoY);
                    jogo.setObrigarAjogar();
                }
                else if(verificarAlvos(destinoX,destinoY,jogo) == false){
                    jogo.resetPecaObrigatoria();
                    jogo.resetObrigarAjogar();
                    jogo.setTurno(1);
                }
            }
            if(destinoY == 7){
                Casa casa2 = tabuleiro.getCasa(destinoX, destinoY);
                Peca peca2 = new Peca(casa2, Peca.DAMA_BRANCA);
                if(verificarAlvos(destinoX,destinoY,jogo) == true ){
                    jogo.setPecaObrigatoria(destinoX,destinoY);
                    jogo.setObrigarAjogar();
                }
                else if(verificarAlvos(destinoX,destinoY,jogo) == false){
                    jogo.resetPecaObrigatoria();
                    jogo.resetObrigarAjogar();
                    jogo.setTurno(1);
                }
            }
        }
        //comendo voltando direçao 1
        if((destinoX == origemX - 2) && (destinoY == origemY - 2)){
            Casa casaQUEPULA = tabuleiro.getCasa(origemX - 1, origemY - 1);
            if(casaQUEPULA.getPeca().getTipo() == PEDRA_VERMELHA || casaQUEPULA.getPeca().getTipo() == DAMA_VERMELHA){
                casaQUEPULA.removerPeca(); 
                peca.mover(destino);
                if(verificarAlvos(destinoX,destinoY,jogo) == true ){
                    jogo.setPecaObrigatoria(destinoX,destinoY);
                    jogo.setObrigarAjogar();
                }
                else if(verificarAlvos(destinoX,destinoY,jogo) == false){
                    jogo.resetPecaObrigatoria();
                    jogo.resetObrigarAjogar();
                    jogo.setTurno(1);
                }
            }
        }
        //comendo voltando direçao 2
        if((destinoX == origemX + 2) && (destinoY == origemY - 2 )){
            Casa casaQUEPULA = tabuleiro.getCasa(origemX + 1, origemY - 1);   
            if(casaQUEPULA.getPeca().getTipo() == PEDRA_VERMELHA || casaQUEPULA.getPeca().getTipo() == DAMA_VERMELHA){
                casaQUEPULA.removerPeca(); 
                peca.mover(destino);
                if(verificarAlvos(destinoX,destinoY,jogo) == true ){
                    jogo.setPecaObrigatoria(destinoX,destinoY);
                    jogo.setObrigarAjogar();
                }
                else if(verificarAlvos(destinoX,destinoY,jogo) == false){
                    jogo.resetPecaObrigatoria();
                    jogo.resetObrigarAjogar();
                    jogo.setTurno(1);
                }
            }
        }
    }
       
    /** MÉTODO PARA MOVIMENTOS SIMPLES DAS PEÇAS BRANCAS E CRIAÇAO DAS DAMAS BRANCAS
    */
               
    public static void movSimplesECriarDamaB(int origemX, int origemY, int destinoX, int destinoY, Jogo jogo){
        Tabuleiro tabuleiro = jogo.getTabuleiro();
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();
        
        if((destinoX == origemX + 1) && (destinoY == origemY + 1) || (destinoX == origemX - 1) && (destinoY == origemY + 1)){                    
            peca.mover(destino);
            jogo.setTurno(1);
            if((destinoX == 7 && destinoY == 7 ) || (destinoX == 5 && destinoY == 7 ) || (destinoX == 3 && destinoY == 7 ) || (destinoX == 1 && destinoY == 7)) {
                Casa casa2 = tabuleiro.getCasa(destinoX, destinoY);
                Peca peca2 = new Peca(casa2, Peca.DAMA_BRANCA);
                jogo.setTurno(1);
            }
        }         
    }
            
    /** MÉTODO PARA MOVIMENTOS SIMPLES DAS PEÇAS VERMELHAS E CRIAÇAO DAS DAMAS VERMELHAS
    */
    public static void movSimplesECriarDamaV(int origemX, int origemY, int destinoX, int destinoY, Jogo jogo){
        Tabuleiro tabuleiro = jogo.getTabuleiro();
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();
        
        if(((destinoX == origemX + 1) && (destinoY == origemY - 1)) || ((destinoX == origemX - 1) && (destinoY == origemY - 1))){
            peca.mover(destino); 
            jogo.setTurno(0);
            if((destinoX == 0 && destinoY == 0 ) || (destinoX == 2 && destinoY == 0 ) || (destinoX == 4 && destinoY == 0 ) || (destinoX == 6 && destinoY == 0)) {
                Casa casa2 = tabuleiro.getCasa(destinoX, destinoY);
                Peca peca2 = new Peca(casa2, Peca.DAMA_VERMELHA);
                jogo.setTurno(0);
            }
        }
    }

    /**  MÉTODO QUE VERIFICA SE HÁ ALVOS PARA CONTINUAR CAPTURANDO
    */
    public boolean verificarAlvos(int destinoX, int destinoY, Jogo jogo){
        boolean verificarAlvos = false;
        Tabuleiro tabuleiro = jogo.getTabuleiro(); 
        Casa destinoAtual = tabuleiro.getCasa(destinoX, destinoY);
          
        if((tabuleiro.getCasa(destinoX - 1, destinoY + 1) != null && tabuleiro.getCasa(destinoX - 2, destinoY + 2) != null )){
            Casa casaQUEPULA = tabuleiro.getCasa(destinoX - 1, destinoY + 1);
            Casa novaCasaDest = tabuleiro.getCasa(destinoX - 2, destinoY + 2);
            if(casaQUEPULA.getPeca() != null && (casaQUEPULA.getPeca().getTipo() % 2 != destinoAtual.getPeca().getTipo() % 2 )  && novaCasaDest.getPeca() == null){
                verificarAlvos = true;                      
            }              
        }                
                
        if((tabuleiro.getCasa(destinoX - 1, destinoY - 1) != null && tabuleiro.getCasa(destinoX - 2, destinoY - 2) != null )){
            Casa casaQUEPULA = tabuleiro.getCasa(destinoX - 1, destinoY - 1);
            Casa novaCasaDest = tabuleiro.getCasa(destinoX - 2, destinoY - 2);
            if(casaQUEPULA.getPeca() != null && (casaQUEPULA.getPeca().getTipo() % 2 != destinoAtual.getPeca().getTipo() % 2 )  && novaCasaDest.getPeca() == null){
                verificarAlvos = true;                      
            }                        
        }
        
        if((tabuleiro.getCasa(destinoX + 1, destinoY + 1) != null && tabuleiro.getCasa(destinoX + 2, destinoY + 2) != null )){
            Casa casaQUEPULA = tabuleiro.getCasa(destinoX + 1, destinoY + 1);
            Casa novaCasaDest = tabuleiro.getCasa(destinoX + 2, destinoY + 2);
            if(casaQUEPULA.getPeca() != null && (casaQUEPULA.getPeca().getTipo() % 2 != destinoAtual.getPeca().getTipo() % 2 )  && novaCasaDest.getPeca() == null){
                verificarAlvos = true;                      
            }                       
        }                            
                
        if((tabuleiro.getCasa(destinoX + 1, destinoY - 1) != null && tabuleiro.getCasa(destinoX + 2, destinoY - 2) != null )){
            Casa casaQUEPULA = tabuleiro.getCasa(destinoX + 1, destinoY - 1);
            Casa novaCasaDest = tabuleiro.getCasa(destinoX + 2, destinoY - 2);
            if( casaQUEPULA.getPeca() != null && (casaQUEPULA.getPeca().getTipo() % 2 != destinoAtual.getPeca().getTipo() % 2 )  && novaCasaDest.getPeca() == null){
                verificarAlvos = true;                      
            }                          
        }                            
        
        return verificarAlvos;
    }
    
    /** MÉTODO QUE FAZ O JOGO ACONTECER 
    *   CHAMA OS METODOS REFERENTES AS PEÇAS  */
    public void moverAsPeca(int origemX, int origemY, int destinoX, int destinoY, Jogo jogo) {
           
        Tabuleiro tabuleiro = jogo.getTabuleiro(); //chama o tabuleiro do jogo
        int turno = jogo.getTurno(); //chama o turno
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();
        int pedraTipo = origem.getPeca().getTipo(); //pega a peça e o seu tipo
        Peca pedraDest = destino.getPeca(); //verifica se o destino é uma casa vazia
                   
        /** JOGO DAS DAS PEÇAS BRANCAS */ 
         
        if (pedraTipo == PEDRA_BRANCA || pedraTipo == DAMA_BRANCA){
            if(pedraDest == null && turno == 0){
                movSimplesECriarDamaB(origemX, origemY, destinoX, destinoY, jogo);
                if(pedraTipo == DAMA_BRANCA){
                   //movimentos das damas
                   if((destinoX == origemX - 1 && destinoY == origemY - 1) || (destinoX == origemX + 1 && destinoY == origemY - 1) ){
                        peca.mover(destino);
                        jogo.setTurno(1);
                   }
                   if((destinoX == origemX + 1 && destinoY == origemY + 1) || (destinoX == origemX - 1 && destinoY == origemY + 1) ){
                        peca.mover(destino);
                        jogo.setTurno(1);
                   }
                }
                movComerPecaBranca(origemX, origemY, destinoX, destinoY,jogo);
            }                                    
        }         
           
        /** JOGO DAS PEÇAS VERMELHAS */
        
        if (pedraTipo == PEDRA_VERMELHA || pedraTipo == DAMA_VERMELHA){
            if(pedraDest == null && turno == 1 ){
                movSimplesECriarDamaV(origemX, origemY, destinoX, destinoY, jogo);
                if(pedraTipo == DAMA_VERMELHA){
                   //movimentos das damas 
                   if((destinoX == origemX - 1 && destinoY == origemY - 1) || (destinoX == origemX + 1 && destinoY == origemY - 1) ){
                        peca.mover(destino);
                        jogo.setTurno(0);
                   }
                   if((destinoX == origemX + 1 && destinoY == origemY + 1) || (destinoX == origemX - 1 && destinoY == origemY + 1) ){
                        peca.mover(destino);
                        jogo.setTurno(0);
                   }
                }
                movComerPecaVerm(origemX, origemY, destinoX, destinoY,jogo);        
            }    
        }                                                  
    }       
        
    /**
     * Valor    Tipo
     *   0   Branca (Pedra)
     *   1   Branca (Dama)
     *   2   Vermelha (Pedra)
     *   3   Vermelha (Dama)
     * @return o tipo da peca.
     */
    public int getTipo() {
         return tipo;
    }
    
    public Casa getCasa() {
        return casa;
    }
}