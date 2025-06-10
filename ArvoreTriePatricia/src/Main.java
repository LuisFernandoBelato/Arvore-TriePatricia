public class Main {
    public static void main(String[] args) {
        ArvorePatricia P = new ArvorePatricia();

        P.Insere("galo");
        P.Insere("sola");
        P.Insere("gelo");
        P.Insere("solo");
        P.Insere("sol");
        P.Insere("sapato");
        P.Insere("solado");
        P.Insere("sopado");
        P.Insere("cama");
        P.Insere("cachaca");
        P.Insere("chamado");
        P.Insere("fazendo");
        P.Insere("fazer");

        String PalavraBusca = "sol";
        System.out.println("\n###  RETORNO DA BUSCA = " + P.Busca(PalavraBusca) + " / DA PALAVRA = " + PalavraBusca + "  ###");
        P.ExibeTodasAsInformacoesNivelANivel();
        System.out.println("\n\n\n");
        P.ExibeTodasAsPalavras();
    }
}