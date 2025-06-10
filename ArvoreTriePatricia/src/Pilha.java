public class Pilha
{
    private No P;

    public Pilha()
    {
        this.P = null;
    }

    public void Push (NoPatricia no, int nivel)
    {
        No nova = new No(no,nivel,P);

        if (P == null)
            P = nova;
        else
        {
            nova.setProx(P);
            P = nova;
        }
    }

    public NoPatricia Pop ()
    {
        NoPatricia aux = P.getInfo();
        if (P != null)
            P = P.getProx();
        return aux;
    }

    public boolean IsEmpty ()
    {
        return P == null;
    }
}
