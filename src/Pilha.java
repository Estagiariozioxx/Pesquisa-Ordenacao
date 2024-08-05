public class Pilha {
    private No inicio;


    public Pilha() {
        this.inicio = null;
    }
    public void push(int info){
        No aux=new No(null,null,info);
        if(inicio==null){
            inicio=aux;
        }
        else{
            aux.setProx(inicio);
            inicio=aux;
        }
    }

    public int pop(){
        int aux=inicio.getInfo();
        inicio=inicio.getProx();
        return aux;
    }
    public boolean pilhaVazia(){
        if(inicio==null)
            return true;
        return false;
    }
}
