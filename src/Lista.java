public class Lista {
    No inicio;
    No fim;
    int qtd;

    public Lista() {
        this.inicio = null;
        this.fim = null;
        this.qtd=0;
    }
    public void inicializar(){
        this.inicio=null;
        this.fim=null;

    }

    public void Mata_lista(){
        this.inicio=null;
        this.fim=null;
        this.qtd=0;
    }
    public void copia_lista(Lista aux){
        No ini=inicio;

        while(ini!=null){
            aux.inserefinal(ini.getInfo());

            ini=ini.getProx();
        }

    }

    public void inserefinal(int info){
        No nova=new No(null,null,info);
        if(inicio==null){
            inicio=nova;
            fim=inicio;
        }
        else{
            fim.setProx(nova);
            nova.setAnt(fim);
            fim=nova;
        }
        this.qtd++;

    }
 /*   public void inserefinal(int num){
        if(this.fim == null)
            this.inicio = this.fim = new No(null,null , num);
        else{
            No caixa = new No(this.fim, null, num);
            this.fim.setProx(caixa);
            this.fim = caixa;
        }
        this.qtd++;
    }*/
    public int pop(){
        No aux = inicio;
        inicio = inicio.getProx();
        if(inicio == null)
            fim = null;
        return aux.getInfo();
    }
    public void exibe(){
        No aux=inicio;
        while(aux!=null){
            System.out.print(aux.getInfo());
            System.out.print(" ");
            aux=aux.getProx();

        }


    }

    public No retornaNoPos(int aux){
        No lista= inicio;
        int i=0;
        while(i!=aux){
            lista=lista.getProx();
            i++;
        }
        return lista;
    }

    public void Shell (){
        int i, j,dist=1;
        int aux;
        No p1;

        while(dist<this.qtd){
            dist=3*dist+1;
        }
        dist=dist/3;

        while(dist>0){
            for(i=dist; i<this.qtd;i++){
                aux=retornaNoPos(i).getInfo();
                j=i;
                while(j-dist>=0 && aux<retornaNoPos(j-dist).getInfo()){
                    retornaNoPos(j).setInfo(retornaNoPos(j-dist).getInfo());
                    j=j-dist;
                }
                retornaNoPos(j).setInfo(aux);
            }
            dist=dist/3;
        }
    }

    public void heap(){
        int pai, fe,fd,maior, aux,tl2=this.qtd;
        while(tl2>1){
            for(pai=tl2/2-1; pai>=0;pai--){
                fe=2*pai+1;
                fd=fe+1;
                maior=fe;
                if(fd<tl2 && retornaNoPos(fd).getInfo()> retornaNoPos(fe).getInfo())
                        maior=fd;
                if(retornaNoPos(maior).getInfo()>retornaNoPos(pai).getInfo()){
                    aux=retornaNoPos(pai).getInfo();
                    retornaNoPos(pai).setInfo(retornaNoPos(maior).getInfo());
                    retornaNoPos(maior).setInfo(aux);

                }
            }
            aux=retornaNoPos(0).getInfo();
            retornaNoPos(0).setInfo(retornaNoPos(tl2-1).getInfo());
            retornaNoPos(tl2-1).setInfo(aux);
            tl2--;
        }

    }


    public void insercaoDireta(){
        ins_direta(inicio,fim);//começa na posição um e pga o da posição 0 e compara com a posição 1 e vai trocando e liberando espaço para que o elemento possa ser alocado

    }

    public void ins_direta (No inicio,No fim){
        No aux= inicio.getProx();
        No aux2;

        int auxint;

        while(aux!=null){
            auxint=aux.getInfo();
            aux2=aux;

            while(aux2!=inicio && auxint<aux2.getAnt().getInfo()){
                aux2.setInfo(aux2.getAnt().getInfo());
                aux2=aux2.getAnt();

            }
            aux2.setInfo(auxint);
            aux=aux.getProx();
        }

    }




    public void bolha(){
        No pi,pfim=fim;
        int aux;
        boolean troca=true;
        while(pfim!=inicio && troca){
            troca=false;
            pi=inicio;
            while(pi!=pfim){
                if(pi.getInfo()<pi.getProx().getInfo()){
                    troca = true;
                    aux=pi.getInfo();
                    pi.setInfo(pi.getProx().getInfo());
                    pi.getProx().setInfo(aux);
                }
                pi=pi.getProx();
            }
        }
    }


    public int retornaPos(No aux){
        int cont=0;
        No inicio=this.inicio;
        while(inicio!=aux){
            cont++;
            inicio=inicio.getProx();
        }
       // System.out.println(cont);
        return cont;
    }

    public void quickspivo(){
        quicksp(inicio,fim);

    }
    private void quicksp(No ini, No fim){
        boolean flag=true;
        int aux;
        No i=ini;
        No j=fim;

        while(retornaPos(i)<retornaPos(j)){
            if(flag){

                while(retornaPos(i)<retornaPos(j) && i.getInfo()<=j.getInfo()){
                    i=i.getProx();
                }

            }
            else{
                while(retornaPos(i)<retornaPos(j) && j.getInfo()>=i.getInfo()){
                    j=j.getAnt();
                }

            }
            if(j!=null & i!=null){
                aux= i.getInfo();
                i.setInfo(j.getInfo());
                j.setInfo(aux);
                flag=!flag;

            }

           // System.out.println("entrei");
        }

        if(retornaPos(ini) < retornaPos(i)-1){
            quicksp(ini,i.getAnt());
        }
        if(retornaPos(j)+1 < retornaPos(fim)){
            quicksp(j.getProx(),fim);
        }
    }


    private int busca(int chave, int TL){
        int inicio = 0, fim = TL- 1, meio = fim / 2;
        No no;
        no = retornaNoPos(inicio);
        while (fim != inicio && no.getInfo() != chave)
        {
            no = retornaNoPos(meio);
            if (chave > no.getInfo())
                inicio = meio + 1;
            else
                fim = meio;
            meio = (inicio + fim) / 2;
            no = retornaNoPos(inicio);
        }
        no = retornaNoPos(meio);
        if (chave > no.getInfo())
            return meio + 1;
        return meio;
    }

    public void insercaobinaria(){
        int i, aux, pos, TL = this.qtd;
        No no;
        for (i = 1; i < TL; i++)
        {
            no = retornaNoPos(i);
            aux = no.getInfo();
            pos = busca(aux, i);
            for (int j = i; j > pos; j--)
            {
                no.setInfo(no.getAnt().getInfo());
                no = no.getAnt();
            }
            no = retornaNoPos(pos);
            no.setInfo(aux);
        }
    }

    public void quickCpivo(){
        quickcompivo(retornaPos(inicio),retornaPos(fim));
    }
    public void quickcompivo(int inicio,int fim){
        int pivo=(inicio+fim)/2;
        int i=inicio,j=fim,aux;
        while (i<j){
            while (retornaNoPos(i).getInfo()<retornaNoPos(pivo).getInfo()){
                i++;
            }

            while(retornaNoPos(j).getInfo()>retornaNoPos(pivo).getInfo()){
                j--;
            }
            if(i<=j){

                aux=retornaNoPos(i).getInfo();
                retornaNoPos(i).setInfo(retornaNoPos(j).getInfo());
                retornaNoPos(j).setInfo(aux);
                i++;
                j--;

            }
        }

        if(inicio<j){
            quickcompivo(inicio,j);
        }
        if(i<fim){
            quickcompivo(i,fim);
        }
    }



    public No buscamenor(No aux){
        No menor=aux.getProx();
        No salva;

        while (menor!=null){
            if(aux.getInfo()>menor.getInfo()){
                aux=menor;
            }
            menor=menor.getProx();
        }
        return aux;

    }

    public void sele(){
        No pinicio=inicio;
        No menor;
        int aux;


        while(pinicio!=null){
            menor=buscamenor(pinicio);
            aux= pinicio.getInfo();
            pinicio.setInfo(menor.getInfo());
            menor.setInfo(aux);
            pinicio=pinicio.getProx();


        }
    }
    private int RetornaIntMaior()
    {
        No aux = inicio;
        int maior = aux.getInfo();
        while(aux != null)
        {
            if(aux.getInfo() > maior)
                maior = aux.getInfo();
            aux = aux.getProx();
        }
        return maior;
    }

    private int RetornaIntMenor()
    {
        No aux = inicio;
        int menor = aux.getInfo();
        while(aux != null)
        {
            if(aux.getInfo() < menor)
                menor = aux.getInfo();
            aux = aux.getProx();
        }
        return menor;
    }

    public void Bucket(int qtde)
    {
        int TL = this.qtd, cod;
        int maior = RetornaIntMaior(), menor = RetornaIntMenor();
        int dist = ((maior - menor)/qtde)+1;
        Lista aux[] = new Lista[qtde];
        for(int i=0; i < qtde; i++)
            aux[i] = new Lista();
        for(int i=0; i < TL; i++)
        {
            cod = this.retornaNoPos(i).getInfo();
            aux[(cod-menor)/dist].inserefinal(cod);

        }
        for(int i=0, j=0; i < qtde; i++)
        {
            if(aux[i].inicio != null)
            {
                aux[i].quickCpivo();
                while(aux[i].inicio != null)
                {
                    this.retornaNoPos(j++).setInfo(aux[i].pop());

                }
            }
        }
    }

    public No retornaNo_intervalo(No aux, int ini, int fim) {
        if (ini > fim) {
            while (aux != null && ini > fim ) {
                aux = aux.getAnt();
                ini--;
            }
        } else {
            while (aux != null && ini < fim ) {
                aux = aux.getProx();
                ini++;
            }
        }
        return aux;
    }


    private void insere_(int ini, int fim) {
        for (int i = ini + 1; i <= fim; i++) {
            No reg = retornaNo_intervalo(inicio, 0, i);
            int reg_cod = reg.getInfo();
            No aux = reg.getAnt();

            while (aux != null && aux.getInfo() > reg_cod) {
                aux.getProx().setInfo(aux.getInfo());
                aux = aux.getAnt();
            }
            if (aux != null) {
                aux.getProx().setInfo(reg_cod);
            } else {
                inicio.setInfo(reg_cod);
            }
        }
    }
    private void merge_TIM(int ini1, int fim1, int ini2, int fim2) {

        No reg1 = retornaNo_intervalo(inicio, 0, ini1);
        No reg2 = retornaNo_intervalo(inicio, 0, ini2);
        No pinicio = inicio;
        int i = ini1, j = ini2;

        Lista aux = new Lista();

        while (i <= fim1 && j <= fim2) {
            if (reg1.getInfo() <= reg2.getInfo()) {
                aux.inserefinal(reg1.getInfo());
                reg1 = reg1.getProx();
                i++;
            } else {
                aux.inserefinal(reg2.getInfo());
                reg2 = reg2.getProx();
                j++;
            }
        }

        while (i <= fim1) {
            aux.inserefinal(reg1.getInfo());
            reg1 = reg1.getProx();
            i++;
        }
        while (j <= fim2) {
            aux.inserefinal(reg2.getInfo());
            reg2 = reg2.getProx();
            j++;
        }

        pinicio = inicio;
        No Reg_aux = aux.inicio;
        while (Reg_aux != null) {
            pinicio.setInfo(Reg_aux.getInfo());
            pinicio = pinicio.getProx();
            Reg_aux = Reg_aux.getProx();
        }
    }

    public void timSort() {
        int meio, direita;
        for (int i = 0;i < this.qtd; i += 32) {
            if (i+32 >= this.qtd)
                insere_(i, this.qtd - 1);
            else
                insere_(i, i + 32);
        }
        for (int tam = 32; tam < this.qtd; tam *= 2) {

            for (int esq = 0; esq < this.qtd; esq += 2 * tam) {
                meio = esq + tam - 1;
                if (esq + 2 * tam - 1 < this.qtd - 1)
                    direita = esq + 2 * tam - 1;
                else
                    direita = this.qtd - 1;
                if (meio < direita)
                    merge_TIM(esq, meio, esq + 1, direita);
            }
        }
    }




    public void particao(Lista lista1,Lista lista2){
        int meio=this.qtd/2;
        No aux=inicio;
        lista1.inicializar();
        lista2.inicializar();

        for(int i=0;i<meio;i++){
            lista1.inserefinal(retornaNoPos(i).getInfo());
            lista2.inserefinal(retornaNoPos(i+meio).getInfo());
        }
    }

    public void fusao(Lista lista1,Lista lista2,int seq){
        int i=0, j=0,aux=seq,k=0;
        while(k<this.qtd){

            while(i<seq && j<seq){
                if(lista1.retornaNoPos(i).getInfo()<lista2.retornaNoPos(j).getInfo()){
                    retornaNoPos(k).setInfo(lista1.retornaNoPos(i).getInfo());
                    i++;
                    k++;
                }
                else{
                    retornaNoPos(k).setInfo(lista2.retornaNoPos(j).getInfo());
                    j++;
                    k++;

                }

            }

            while (i<seq){
                retornaNoPos(k).setInfo(lista1.retornaNoPos(i).getInfo());
                i++;
                k++;
            }
            while (j<seq){
                retornaNoPos(k).setInfo(lista2.retornaNoPos(j).getInfo());
                j++;
                k++;
            }
            seq=seq+aux;

        }
    }

    public boolean isempty(){
        return this.inicio == null;
    }

    public void Radix()
    {
        int maior = RetornaIntMaior();
        int exp = 1;
        No no;
        Lista aux[] = new Lista[10];
        for(int i=0; i < 10; i++)
            aux[i] = new Lista();
        while(maior/exp > 0)
        {
            no = inicio;
            while(no != null)
            {
                aux[no.getInfo() / exp % 10].inserefinal(no.getInfo());
                no = no.getProx();

            }
            no = inicio;
            for(int i=0; i < 10; i++)
            {
                while(!aux[i].isempty())
                {
                    no.setInfo(aux[i].pop());
                    no = no.getProx();

                }
            }
            exp *= 10;
        }
    }


    public void merge_1(){
        int seq=1;
        Lista lista1 = new Lista();
        Lista lista2 = new Lista();

        while(seq<this.qtd){
            particao(lista1,lista2);
            fusao(lista1,lista2,seq);
            seq=seq*2;
        }
    }

    public void fusao_2(Lista aux,int ini1,int fim1,int ini2,int fim2){
        int i=ini1,j=ini2,k=0;
        while(i<=fim1 && j<=fim2){
            if(retornaNoPos(i).getInfo()<retornaNoPos(j).getInfo()){
                aux.retornaNoPos(k).setInfo(retornaNoPos(i).getInfo());
                k++;
                i++;
            }
            else{
                aux.retornaNoPos(k).setInfo(retornaNoPos(j).getInfo());
                k++;
                j++;
            }
        }

        while(i<=fim1){
            aux.retornaNoPos(k).setInfo(retornaNoPos(i).getInfo());
            k++;
            i++;

        }
        while(j<=fim2){
            aux.retornaNoPos(k).setInfo(retornaNoPos(j).getInfo());
            k++;
            j++;
        }

        for(i=0;i<k;i++){
            retornaNoPos(i+ini1).setInfo(aux.retornaNoPos(i).getInfo());
        }

    }
    public void Shake(){
        int aux, inicio = 0, fim = this.qtd - 1;
        No no1 , no2;
        while (inicio < fim)
        {

            for (int i = 0; i < fim; i++)
            {
                no1 = retornaNoPos(i);
                no2 = no1.getProx();

                if (no1.getInfo() > no2.getInfo())
                {
                    aux = no1.getInfo();
                    no1.setInfo(no2.getInfo());
                    no2.setInfo(aux);

                }
            }
            fim--;
            for (int i = fim; i > inicio; i--)
            {
                no1 = retornaNoPos(i);
                no2 = no1.getAnt();

                if (no1.getInfo() < no2.getInfo())
                {
                    aux = no1.getInfo();
                    no1.setInfo(no2.getInfo());
                    no2.setInfo(aux);
                }
            }
            inicio++;
        }
    }

    public void Counting()
    {
        int TL = this.qtd, cod;
        int maior = RetornaIntMaior();
        int vet[] = new int[maior+1];
        Lista aux = new Lista();
        for(int i=0; i < TL; i++)
        {
            aux.inserefinal(this.retornaNoPos(i).getInfo());

        }

        for(int i=0; i < TL; i++)
        {
            vet[aux.retornaNoPos(i).getInfo()]++;

        }
        for(int i=0; i < maior; i++)
            vet[i+1] = vet[i] + vet[i+1];
        for(int i=0; i < TL; i++)
        {
            cod = aux.retornaNoPos(i).getInfo();
            this.retornaNoPos(vet[cod]-1).setInfo(cod);

        }
    }
    public void mergesort(){
        Lista listaAux = new Lista();
        int i=0;
        while(i<this.qtd){
            listaAux.inserefinal(0);
            i++;
        }
        merge_2(listaAux,0,this.qtd-1);
    }
    public void merge_2(Lista aux,int esq,int dir){
        int meio;
        if(esq<dir){
            meio=(esq+dir)/2;
            merge_2(aux,esq,meio);
            merge_2(aux,meio+1,dir);
            fusao_2(aux,esq,meio,meio+1,dir);
        }
    }

    public void Gnome()
    {
        int TL = this.qtd, j, aux;
        No no1, no2;
        boolean flag;
        for(int i=1; i < TL; i++)
        {
            no1 = retornaNoPos(i);
            no2 = retornaNoPos(i-1);
            if(no1.getInfo() < no2.getInfo())
            {
                aux = no1.getInfo();
                no1.setInfo(no2.getInfo());
                no2.setInfo(aux);
                flag = true;
                j = i-1;
                while(j > 0 && flag)
                {
                    no1 = retornaNoPos(j);
                    no2 = retornaNoPos(j-1);

                    if(no1.getInfo() < no2.getInfo())
                    {
                        aux = no1.getInfo();
                        no1.setInfo(no2.getInfo());
                        no2.setInfo(aux);

                    }
                    else
                        flag = false;
                    j--;
                }
            }
        }
    }








    private void fusao_tim(Lista aux,int inicio1, int fim1, int inicio2, int fim2){
        int i = inicio1, j = inicio2;
        while(i<=fim1 && j<=fim2)
        {

            if(this.retornaNoPos(i).getInfo() < this.retornaNoPos(j).getInfo())
                aux.inserefinal(this.retornaNoPos(i++).getInfo());
            else
                aux.inserefinal(this.retornaNoPos(j++).getInfo());
        }
        while(i<=fim1)
        {
            aux.inserefinal(this.retornaNoPos(i++).getInfo());

        }

        while(j<=fim2)
        {
            aux.inserefinal(this.retornaNoPos(j++).getInfo());

        }
        int TL = aux.qtd;
        for(i=0; i<TL; i++)
            this.retornaNoPos(inicio1 + i).setInfo(aux.pop());
    }

    public void Tim()
    {
        Lista aux = new Lista();
        No pinicio, pfim;
        int dist = 32, TL = this.qtd;
        for(int i=0; i < TL; i+=dist)
        {

            pinicio = inicio;
            pfim = retornaNoPos(i + dist-1);
            if(pfim != null)
            {
                ins_direta(pinicio, pfim);
                pinicio = pfim.getProx();
            }
            else
                ins_direta(pinicio, fim);
        }

        while(dist < TL)
        {

            pinicio = pfim = inicio;
            for(int i=0; i < TL; i+= dist*2)
            {

                pfim = retornaNoPos(i+dist-1);
                if(pfim != null)
                {
                    fusao_tim(aux,i, i+dist-1, i+dist, Math.min(i+dist*2-1, TL-1));
                    pinicio = pfim.getProx();
                }
                else
                    fusao_tim(aux,i, i+dist-1, i+dist, retornaPos(fim));
            }
            dist *= 2;
        }
    }

    public void comb()
    {
        No no, noo;
        int aux, dist = this.qtd, TL = this.qtd;

        dist /= 1.3;

        while(dist > 0)
        {

            for(int i=0; i<TL-dist; i++)
            {
                no = retornaNoPos(i);
                noo = retornaNoPos(i+dist);

                if(no.getInfo() > noo.getInfo())
                {
                    aux = no.getInfo();
                    no.setInfo(noo.getInfo());
                    noo.setInfo(aux);

                }
            }
            dist /= 1.3;
        }
    }




    /* GET AND SETTERS*/

    public No getIncio() {
        return inicio;
    }

    public void setIncio(No incio) {
        this.inicio = incio;
    }

    public No getFim() {
        return fim;
    }

    public void setFim(No fim) {
        this.fim = fim;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
