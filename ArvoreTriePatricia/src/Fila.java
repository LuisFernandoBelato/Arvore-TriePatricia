public class Fila
{
    private No inicio;
    private No fim;

    public Fila ()
    {
        inicio = fim = null;
    }

    public void enqueue (NoPatricia no, int nivel)
    {
        No nova = new No(no,nivel,null);
        if (inicio == null)
            inicio = fim = nova;
        else
        {
            fim.setProx(nova);
            fim = fim.getProx();
        }
    }

    public No dequeue ()
    {
        No aux = inicio;
        if (inicio != null)
            inicio = inicio.getProx();
        return aux;
    }

    public boolean IsEmpty ()
    {
        return inicio == null;
    }
}
