
import java.util.*; //ArrayList

public class Pedido {

    //Array de Acompanhamentos
    public List<Acompanhamento> lista = new ArrayList<Acompanhamento>();

    //atributos
    public static float vRodizio, vServicos, vAcompanhamentos, vTotal, vEstacionamento, vParcial;
    public static int qtdPessoas;
    public static boolean stEstacionamento;

    //Itens bebidas de acordo com os vetores
    public static String sBebidas[] = {"Agua", "Refrigerante", "Suco", "Café",
        "Milk Shake", "Toddynho", "Cerveja", "Vinho"};//Nome

    public static float vBebidas[] = {(float) 5, (float) 8, (float) 9.5, (float) 2.5,
        (float) 12, (float) 4, (float) 9.5, (float) 16};//Valor

    public static String sSobremesas[] = {"Pudim", "Bolo", "Mousse", "Sorvete",
        "Salada de Frutas", "Açaí", "Paçoca", "Petit Gateau"};//Nome

    public static float vSobremesas[] = {(float) 7, (float) 8.5, (float) 6, (float) 8.5,
        (float) 5, (float) 18, (float) 2, (float) 10};//Valor

    //construtor
    public Pedido(float tmpVRodizio) {
        this.vRodizio = tmpVRodizio;
        this.qtdPessoas = 1;
        this.vParcial = 0;
        this.vAcompanhamentos = 0;
        this.vServicos = 0;
        this.vEstacionamento = 0;
        this.vTotal = 0;

    }

    public void adicionarAcompanhamento(int tmpTipo, int indice) {

        //variaveis que auxiliarao no procedimento da busca
        int cod;
        boolean achou = false;

        Acompanhamento novoAcomp = new Acompanhamento();

        if (tmpTipo == 1) {//Bebidas

            vAcompanhamentos += vBebidas[indice];

            cod = indice;

            for (Acompanhamento item : lista) {
                if (cod == item.getId()) {//se contem nalista
                    item.setQuantidade(item.getQuantidade() + 1);// adicionar 1 na quantidade
                    achou = true;
                    break;
                }//fechando if
            }//fechando for

            if (!achou) {//se nao achou
                novoAcomp.setId(indice);
                novoAcomp.setNome(sBebidas[indice]);
                novoAcomp.setValor(vBebidas[indice]);
                novoAcomp.setQuantidade(1);
                lista.add(novoAcomp);
            }//fechando if

        } else if (tmpTipo == 2) {//Sobremesas
            vAcompanhamentos += vSobremesas[indice];

            cod = indice + 8;

            for (Acompanhamento item : lista) {
                if (cod == item.getId()) {//se contem nalista
                    item.setQuantidade(item.getQuantidade() + 1);// adicionar 1 na quantidade
                    achou = true;
                    break;
                }//fechando if
            }//fechando for
            if(!achou){
            novoAcomp.setId(indice + 8);
            novoAcomp.setNome(sSobremesas[indice]);
            novoAcomp.setValor(vSobremesas[indice]);
            novoAcomp.setQuantidade(1);
            lista.add(novoAcomp);
            }
        }//Fechando If - Else
    }

    //Metodos funcionais
    public static float atualizarValores() {
        vParcial = vRodizio * qtdPessoas;
        vServicos = (vParcial + vAcompanhamentos) * (float) 0.1;

        if (stEstacionamento == true) {
            vEstacionamento = 15;
        } else {
            vEstacionamento = 0;
        }

        vTotal = vParcial + vServicos + vEstacionamento + vAcompanhamentos;
        return vTotal;
        
//        for (int i = 0; i < 10; i++) {
//            
//        }
    }//Fechando Atualizar

}//Fechando Classe
