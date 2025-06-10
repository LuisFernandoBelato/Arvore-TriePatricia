public class ArvorePatricia
{
    private NoPatricia Raiz;

    public ArvorePatricia ()
    {
        this.Raiz = null;
    }

    public void Insere (String palavra)
    {
        palavra = palavra.toLowerCase();
        NoPatricia CaixaCriadaNoMeio = null;

        int pos;
        int pos_ant;
        int pos_palavra;
        int pos_str;

        pos = palavra.charAt(0) - 'a';
        NoPatricia nova = new NoPatricia(palavra);

        if (Raiz == null)
        {
            NoPatricia ligacao = new NoPatricia();
            ligacao.setNumero(1);
            ligacao.setvLetras(pos,palavra.charAt(0));
            ligacao.setvLig(pos,nova);
            Raiz = ligacao;
        }
        else
        {
            if (Raiz.getvLig(pos) == null)
            {
                Raiz.setvLetras(pos, palavra.charAt(0));
                Raiz.setvLig(pos, nova);
            }
            else
            {
                NoPatricia Ant = Raiz;
                NoPatricia Prox = Ant.getvLig(pos);

                NoPatricia Aux;

                boolean inseriu = false;
                String str;
                int i;

                while (!inseriu)
                {
                    // PERGUNTA SE O NÚMERO É ZERO = TEM PALAVRA

                    if (Prox != null && Prox.getNumero() == 0)
                    {
                        str = Prox.getPalavra();
                        i = 0;
                        while (i < str.length() && i < palavra.length() && str.charAt(i) == palavra.charAt(i))
                            i++;

                        // TEM QUE CRIAR NO MEIO - DE UMA LIGAÇÃO E UMA PALAVRA

                        if (i < str.length() && i < palavra.length())
                        {
                            pos_palavra = (palavra.charAt(i) - 'a');
                            pos_str = (str.charAt(i) - 'a');
                            pos_ant = (palavra.charAt(Ant.getNumero()-1) - 'a');

                            CaixaCriadaNoMeio = new NoPatricia();
                            CaixaCriadaNoMeio.setNumero(i+1);
                            CaixaCriadaNoMeio.setvLetras( pos_str  , str.charAt(i));
                            CaixaCriadaNoMeio.setvLetras( pos_palavra , palavra.charAt(i));
                            CaixaCriadaNoMeio.setvLig( pos_str , Prox);
                            CaixaCriadaNoMeio.setvLig( pos_palavra , nova);
                            Ant.setvLig( pos_ant , CaixaCriadaNoMeio);

                            inseriu = true;
                        }
                        else // SE IR PRA CÁ QUER DIZER QUE O I É IGUAL A UM TAMANHO DE PALAVRA
                        {
                            if (i == str.length())
                            {

                                pos_ant = (palavra.charAt(i) - 'a');
                                pos_palavra = (palavra.charAt(i) - 'a');

                                nova = new NoPatricia(palavra);
                                Prox.setNumero(i+1);
                                Prox.setvLetras( pos_palavra , palavra.charAt(i));
                                Prox.setvLig( pos_ant , nova);

                                inseriu = true;
                            }

                        }

                    }
                    else
                    {
                        // QUER DIZER QUE É POSSÍVEL TER CAIXAS INTERMEDIÁRIAS ENTRE ANT E PROX
                        if (Prox != null && Prox.getNumero() != Ant.getNumero() + 1)
                        {
                            Aux = Prox;
                            boolean Parar;

                            while (Aux.getPalavra() == null)
                            {
                                i = 0;
                                Parar = false;
                                while (i < 26 && !Parar)
                                {
                                    if (Aux.getvLig(i) != null)
                                    {
                                        Aux = Aux.getvLig(i);
                                        Parar = true;
                                    }
                                    i++;
                                }
                            }

                            i = 0;
                            while (i < palavra.length() && Aux.getPalavra() != null && i < Aux.getPalavra().length() && Aux.getPalavra().charAt(i) == palavra.charAt(i))
                                i++;

                            // TEM QUE INSERIR ENTRE OS NÓS - ANT E PROX
                            if (i+1 < Prox.getNumero() && Aux.getPalavra() != null)
                            {
                                pos_ant = (palavra.charAt(Ant.getNumero()-1) - 'a');
                                pos_str = (Aux.getPalavra().charAt(i) - 'a');
                                pos_palavra = (palavra.charAt(i) - 'a');

                                nova = new NoPatricia(palavra);
                                CaixaCriadaNoMeio = new NoPatricia();
                                CaixaCriadaNoMeio.setNumero(i+1);
                                CaixaCriadaNoMeio.setvLetras( pos_str , Aux.getPalavra().charAt(i));
                                CaixaCriadaNoMeio.setvLetras( pos_palavra , palavra.charAt(i));
                                CaixaCriadaNoMeio.setvLig( pos_str , Prox);
                                CaixaCriadaNoMeio.setvLig( pos_palavra , nova);
                                Ant.setvLig( pos_ant , CaixaCriadaNoMeio);

                                inseriu = true;
                            }
                        }
                    }

                    // PALAVRA INSERIDA É MENOR QUE O NÚMERO GUARDADO NO NÓ

                    if (Prox != null && palavra.length() < Prox.getNumero())
                    {
                        pos_palavra = (palavra.charAt(palavra.length()-1) - 'a');
                        pos_ant = (palavra.charAt(Ant.getNumero() - 1) - 'a');

                        Prox.setPalavra(palavra);
                        CaixaCriadaNoMeio = new NoPatricia();
                        CaixaCriadaNoMeio.setNumero(palavra.length());
                        CaixaCriadaNoMeio.setvLetras( pos_palavra , palavra.charAt(palavra.length()-1));
                        CaixaCriadaNoMeio.setvLig( pos_palavra , Prox);
                        Ant.setvLig( pos_ant , CaixaCriadaNoMeio);

                        inseriu = true;
                    }

                    // ANDA DE DOIS EM DOIS

                    if (!inseriu && Prox != null)
                    {
                        Ant = Prox;
                        Prox = Prox.getvLig( ((palavra.charAt(Prox.getNumero()-1)) - 'a') );

                        // PROX É NULO, TEM QUE CRIAR LIGANDO A NOVA NO ANT
                        if (Prox == null)
                        {
                            pos_ant = (palavra.charAt(Ant.getNumero()-1) - 'a');
                            pos_palavra = (palavra.charAt(Ant.getNumero()-1) - 'a');

                            CaixaCriadaNoMeio = new NoPatricia(palavra);
                            Ant.setvLetras( pos_palavra , palavra.charAt(Ant.getNumero()-1));
                            Ant.setvLig( pos_ant , CaixaCriadaNoMeio);

                            inseriu = true;
                        }
                    }

                }
            }
        }
    }

    public void ExibeTodasAsPalavras ()
    {
        Fila F = new Fila();
        No aux; int i;

        F.enqueue(Raiz,1);
        while (!F.IsEmpty())
        {
            aux = F.dequeue();
            if (aux.getInfo().getPalavra() != null)
                System.out.printf(" PALAVRA DO NÓ = %s - NIVEL = %d \n",aux.getInfo().getPalavra(), aux.getNivel());

            i = 0;
            while (i < 26)
            {
                if (aux.getInfo().getvLetras(i) >= 'a' && aux.getInfo().getvLetras(i) <= 'z')
                    F.enqueue(aux.getInfo().getvLig(i), aux.getNivel() + 1);
                i++;
            }

        }
    }


    public void ExibeTodasAsInformacoesNivelANivel ()
    {
        Fila F = new Fila();
        No aux; int i, j, statico = 1;

        System.out.println("\n\n\t### NIVEL 1 ###\t\n");
        F.enqueue(Raiz,1);
        while (!F.IsEmpty())
        {
            aux = F.dequeue();

            if (aux.getNivel() != statico)
            {
                System.out.printf("\n\n\t### NIVEL %d ###\t\n\n",aux.getNivel());
                statico = aux.getNivel();
            }

            System.out.printf("| -");
            i = 0;
            j = 0;

            while (i < 26)
            {

                if (aux.getInfo().getvLetras(i) >= 'a' && aux.getInfo().getvLetras(i) <= 'z')
                {
                    System.out.printf(" %c -", aux.getInfo().getvLetras(i));
                    j = i;
                }
                i++;
            }

            if (aux.getInfo().getPalavra() == null)
                System.out.printf(" // Não Possui // INDICE = %d", aux.getInfo().getNumero());
            else
                System.out.printf(" // %s // INDICE = %d",aux.getInfo().getPalavra(), aux.getInfo().getNumero());
            System.out.printf(" |    ");
            i = 0;
            while (i < 26)
            {
                if (aux.getInfo().getvLetras(i) >= 'a' && aux.getInfo().getvLetras(i) <= 'z')
                    F.enqueue(aux.getInfo().getvLig(i), aux.getNivel() + 1);
                i++;
            }

        }
    }


    public boolean Busca (String palavra)
    {
        int pos, i;
        boolean flag = false;
        NoPatricia Ptr;

        Ptr = Raiz;

        while (!flag)
        {
            if (Ptr == null)
                flag = true;
            else
                if (Ptr.getPalavra() != null && Ptr.getPalavra() == palavra)
                    flag = true;
                else
                {
                    if (Ptr.getNumero() != 0)
                    {
                        pos = (palavra.charAt(Ptr.getNumero()-1) - 'a');
                        if (Ptr.getvLig(pos) != null)
                            Ptr = Ptr.getvLig( pos );
                        else
                            flag = true;
                    }
                    else
                        flag = true;
                }
        }

        if (Ptr != null && Ptr.getPalavra() == palavra)
            return true;
        else
            return false;
    }


}
