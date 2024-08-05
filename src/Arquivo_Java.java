import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class Arquivo_Java {

    private String nomearquivo;
    private RandomAccessFile arquivo;
    private int compProg;
    private int movProg;
    private int TF=1024;
    public void init_zera_tudo() {
        movProg=0;
        compProg=0;
    }

    public void replicaArq(Arquivo_Java arq){
        Registro reg = new Registro();
        arq.init_zera_tudo();
        arq.truncate(0);
        seekArq(0);
        while(!eof()){
            reg.leDoArq(arquivo);
            reg.gravaNoArq(arq.arquivo);
        }
    }

    public int getCompProg() {
        return compProg;
    }

    public int getTF() {
        return TF;
    }

    public Arquivo_Java(String nomearquivo)
    {
        // Exclui o arquivo existente, se houver
        File file = new File(nomearquivo);
        if (file.exists()) {
            file.delete();
        }
        try
        {
            arquivo = new RandomAccessFile(nomearquivo, "rw");
        } catch (IOException e)
        { }
    }

    public void popularandom(){
        Random random = new Random();

        Registro reg=new Registro();
        for (int i = 0; i < TF; i++) {
            int numero = random.nextInt(1024);
            reg.setCodigo((int)(Math.random()*1025));// Números aleatórios entre 0 e 99
            seekArq(i);
            reg.gravaNoArq(arquivo);

            //inserirRegNoFinal(new Registro(numero));
        }

    }
    public void populaordenado(){
        Random random = new Random();

        Registro reg=new Registro();
        for (int i = 0; i < TF; i++) {
            int numero = i; // Números aleatórios entre 0 e 99
            reg.setCodigo(numero);
            seekArq(i);
            reg.gravaNoArq(arquivo);
        }
    }
    public void populadecre(){
        Random random = new Random();

        Registro reg=new Registro();
        for (int i = TF,j=0; i > 0; i--,j++) {
            int numero = i;
            reg.setCodigo(numero);
            seekArq(j);
            reg.gravaNoArq(arquivo);

        }
    }

    public void truncate(long pos) //desloca eof
    {
        try
        {
            arquivo.setLength(pos * Registro.length());
        } catch (IOException exc)
        { }
    }


    public boolean eof()
    {
        boolean retorno = false;
        try
        {
            if (arquivo.getFilePointer() == arquivo.length())
                retorno = true;
        } catch (IOException e)
        { }
        return (retorno);
    }

    //insere um Registro no final do arquivo, passado por par�metro
    public void inserirRegNoFinal(Registro reg)
    {
        seekArq(filesize());//ultimo byte
        reg.gravaNoArq(arquivo);
    }

    private int filesize() {
        try {
            return (int)arquivo.length()/Registro.length();

        }catch (IOException e){

        }
        return 0;
    }

    public void exibirArq()
    {
        int i;
        Registro aux = new Registro();
        seekArq(0);
        i = 0;
        while (!this.eof())
        {
           // System.out.println("Posicao " + i);
            aux.leDoArq(arquivo);
            aux.exibirReg();
            i++;
        }
        System.out.println();
    }

    public void exibirUmRegistro(int pos)
    {
        Registro aux = new Registro();
        seekArq(pos);
        System.out.println("Posicao " + pos);
        aux.leDoArq(arquivo);
        aux.exibirReg();
    }

    public void seekArq(int pos)
    {
        try
        {
            arquivo.seek(pos * Registro.length());
        } catch (IOException e)
        { }
    }

    public void leArq()
    {
        int codigo, idade;
        String nome;
        codigo = Entrada.leInteger("Digite o c�digo");
        while (codigo != 0)
        {
            inserirRegNoFinal(new Registro(codigo));
            codigo = Entrada.leInteger("Digite o c�digo");
        }
    }

    //.............................................................................
    /*

    insira aqui os m�todos de Ordena��o;

    */
    public void executa()
    {
        leArq();
        exibirArq();
    }
    Registro reg1= new Registro();
    Registro reg2= new Registro();


    public void bolha(){
        int tl2=filesize();
        Registro aux;
        boolean troca = true;
        while(tl2>1 && troca){
            troca=false;
            for(int i=0; i<tl2-1;i++){
                seekArq(i);
                reg1.leDoArq(arquivo);
                seekArq(i+1);
                reg2.leDoArq(arquivo);
                compProg++;
                if(reg1.getCodigo()>reg2.getCodigo()){
                    troca=true;
                    seekArq(i);
                    reg2.gravaNoArq(arquivo);
                    seekArq(i+1);
                    reg1.gravaNoArq(arquivo);
                    movProg+=2;
                }


            }
            tl2--;
        }
    }

    private int busca(int chave, int TL) {
        int inicio = 0, fim = TL - 1, meio = (inicio+fim) / 2;
        Registro reg = new Registro();
        seekArq(meio);
        reg.leDoArq(arquivo);
        while (inicio < fim)
        {
            compProg++;
            if (chave > reg.getCodigo())
                inicio = meio + 1;
            else
                fim = meio - 1;
            meio = (inicio + fim) / 2;
            seekArq(meio);
            reg.leDoArq(arquivo);
        }
        compProg++;
        if (chave > reg.getCodigo())
            return meio + 1;
        return meio;
    }

    public void insercaobinaria(){
        int i, pos, TL = filesize();
        Registro regi = new Registro();
        Registro regj = new Registro();
        for (i = 1; i < TL; i++)
        {
            seekArq(i);
            regi.leDoArq(arquivo);
            pos = busca(regi.getCodigo(), i);
            for (int j = i; j > pos;)
            {
                seekArq(j-1);
                regj.leDoArq(arquivo);
                regj.gravaNoArq(arquivo);
                movProg++;
                j--;
            }
            if(pos != i)
            {
                seekArq(pos);
                regi.gravaNoArq(arquivo);
                movProg++;
            }
        }
    }

    public void ins_direta_intervalo(int esq, int dir) {
        int pos;
        Registro reg = new Registro(), reg2 = new Registro();
        for (int i = esq+1; i < dir; i++)
        {
            pos = i;
            seekArq(pos-1);
            reg2.leDoArq(arquivo);
            reg.leDoArq(arquivo);
            while (pos > esq && reg.getCodigo() < reg2.getCodigo())
            {
                seekArq(pos);
                reg2.gravaNoArq(arquivo);
                pos--;
                seekArq(pos-1);
                reg2.leDoArq(arquivo);
            }
            if(pos != i){
                seekArq(pos);
                reg.gravaNoArq(arquivo);
            }
        }
    }

    public void inser_direta(){
        int pos,tl=filesize();
        Registro reg1=new Registro();
        Registro aux=new Registro();
        for (int i=1;i<tl;i++){
            seekArq(i);
            aux.leDoArq(arquivo);
            pos=i;
            seekArq(pos-1);
            reg1.leDoArq(arquivo);
            compProg++;
            while(pos>0 && aux.getCodigo()<reg1.getCodigo()){
                seekArq(pos-1);
                reg2.leDoArq(arquivo);

                seekArq(pos);
                reg2.gravaNoArq(arquivo);
                movProg++;

                compProg++;
                pos--;
                if(pos>=0){
                    seekArq(pos-1);
                    reg1.leDoArq(arquivo);
                }
            }
            seekArq(pos);
            aux.gravaNoArq(arquivo);
            movProg++;


        }
    }
    public int RetornaIntMaior(){
        Registro reg = new Registro();
        int maior, TL = filesize();
        seekArq(0);
        reg.leDoArq(arquivo);
        maior = reg.getCodigo();
        for(int i = 0; i < TL; i++)
        {
            reg.leDoArq(arquivo);
            if(reg.getCodigo()> maior)
                maior = reg.getCodigo();
        }
        return maior;
    }

    public int RetornaIntMenor(){
        Registro reg = new Registro();
        int menor, TL = filesize();
        this.seekArq(0);
        reg.leDoArq(arquivo);
        menor = reg.getCodigo();
        for(int i = 1; i < TL; i++)
        {
            reg.leDoArq(this.arquivo);
            if(reg.getCodigo() < menor)
                menor = reg.getCodigo();
        }
        return menor;
    }

    public void Bucket(int qtde){

        Registro reg = new Registro();
        int maior = RetornaIntMaior(), menor = RetornaIntMenor(), TL = filesize();
        int dist = ((maior - menor)/qtde)+1;
        Lista aux[] = new Lista[qtde];

        for(int i=0; i < qtde; i++)
            aux[i] = new Lista();

        for(int i=0; i < TL; i++)
        {
            movProg++;
            seekArq(i);
            reg.leDoArq(arquivo);
            aux[(reg.getCodigo()-menor)/dist].inserefinal(reg.getCodigo());
        }

        seekArq(0);
        for(int i=0; i < qtde; i++)
        {
            compProg++;
            if(aux[i] != null)
            {
                aux[i].insercaobinaria();
                while(!aux[i].isempty())
                {
                    reg.setCodigo(aux[i].pop());
                    reg.gravaNoArq(arquivo);
                    movProg++;
                }
            }
        }
    }
    public void selecao_direta(){
        int posmenor,aux,tl=filesize();
        Registro reg1=new Registro();
        Registro reg2=new Registro();
        for (int i=0; i<tl-1;i++){
            posmenor=i;
            for(int j=i+1;j<tl;j++){
                seekArq(j);
                reg1.leDoArq(arquivo);
                seekArq(posmenor);
                reg2.leDoArq(arquivo);
                compProg++;
                if(reg1.getCodigo()<reg2.getCodigo()){
                    posmenor=j;
                }

            }
            seekArq(i);
            reg1.leDoArq(arquivo);
            seekArq(posmenor);
            reg2.leDoArq(arquivo);

            seekArq(posmenor);
            reg1.gravaNoArq(arquivo);
            seekArq(i);
            reg2.gravaNoArq(arquivo);
            movProg++;
            movProg++;
        }

    }

    private void fusao_tim(int inicio1, int fim1, int inicio2, int fim2, Arquivo_Java arq){
        int i = inicio1, j = inicio2;
        Registro reg1 = new Registro();
        Registro reg2 = new Registro();
        arq.seekArq(0);
        arq.truncate(0);
        compProg+=2;
        while(i<=fim1 && j<=fim2)
        {
            seekArq(i);
            reg1.leDoArq(arquivo);
            seekArq(j);
            reg2.leDoArq(arquivo);
            compProg+=3;
            if(reg1.getCodigo() < reg2.getCodigo())
            {
                reg1.gravaNoArq(arq.arquivo);
                i++;
            }
            else
            {
                reg2.gravaNoArq(arq.arquivo);
                j++;
            }
            movProg++;
        }
        compProg++;
        while(i<=fim1)
        {
            compProg++;
            seekArq(i++);
            reg1.leDoArq(arquivo);
            reg1.gravaNoArq(arq.arquivo);
            movProg++;
        }
        compProg++;
        while(j<=fim2)
        {
            compProg++;
            seekArq(j++);
            reg2.leDoArq(arquivo);
            reg2.gravaNoArq(arq.arquivo);
            movProg++;
        }
        compProg++;
        for(i=0; i<arq.filesize(); i++)
        {
            compProg++;
            arq.seekArq(i);
            reg1.leDoArq(arq.arquivo);
            seekArq(inicio1+i);
            reg1.gravaNoArq(arquivo);
            movProg++;
        }
    }
    public void Tim() throws IOException
    {
        Arquivo_Java Aux = new Arquivo_Java("auxaux.dat");
        int dist = 32, TL = filesize();
        for(int i=0; i < TL; i+=dist)
            ins_direta_intervalo(i, Math.min(i+dist, TL)); //mínimo número entre dois intervalos
        while(dist < TL)
        {
            for(int i=0; i < TL; i+= dist*2)
                fusao_tim(i, i+dist-1, i+dist, Math.min(i+dist*2-1, TL-1), Aux);
            dist *= 2;
        }
        Aux.arquivo.close();
        File fechar = new File("auxaux.dat");
        fechar.delete();
    }


    public void comb()
    {
        int dist, TL;
        dist = TL = filesize();
        Registro reg = new Registro();
        Registro reg2 = new Registro();
        compProg++;
        while(dist > 0)
        {
            compProg+=2;
            dist /= 1.3;
            for(int i=0; i < TL - dist; i++)
            {
                seekArq(i);
                reg.leDoArq(arquivo);
                seekArq(i + dist);
                reg2.leDoArq(arquivo);
                compProg+=2;
                if(reg.getCodigo() > reg2.getCodigo())
                {
                    seekArq(i);
                    reg2.gravaNoArq(arquivo);
                    seekArq(i + dist);
                    reg.gravaNoArq(arquivo);
                    compProg++;
                    movProg+=2;
                }
            }
        }
    }

    public void Radix() throws IOException
    {
        int maior = RetornaIntMaior(), TL = filesize();
        int x = 1;
        Registro reg = new Registro();
        Lista aux[] = new Lista[10];

        for(int i=0; i < 10; i++)
            aux[i] = new Lista();

        while(maior/x > 0)
        {
            compProg++;
            for(int i=0; i < TL; i++)
            {
                compProg++;
                seekArq(i);
                reg.leDoArq(arquivo);
                aux[reg.getCodigo() / x % 10].inserefinal(reg.getCodigo());
                movProg++;
            }

            seekArq(0);
            for(int i=0; i < 10; i++)
            {
                compProg++;
                while(!aux[i].isempty())
                {
                    reg.setCodigo(aux[i].pop());
                    reg.gravaNoArq(arquivo);
                    movProg++;
                }
            }
            x *= 10;
        }
    }

    public void shell(){
        int i, j, dist=1;
        int aux;
        Registro reg = new Registro();
        Registro reg2= new Registro();
        Registro auxreg= new Registro();

        while(dist<filesize()){
            dist=3*dist+1;
        }
        dist=dist/3;
        while(dist > 0){

            for (i=dist ; i<filesize(); i++){
                seekArq(i);
                reg.leDoArq(arquivo);
                aux=reg.getCodigo();
                auxreg=new Registro(aux);

                    j=i;

                    seekArq(j-dist);
                    reg2.leDoArq(arquivo);
                compProg++;
                    while(j-dist>=0 && aux<reg2.getCodigo()){
                       // seekArq(j-dist);
                       // reg2.leDoArq(arquivo);
                        seekArq(j);
                        reg2.gravaNoArq(arquivo);
                        movProg++;
                        compProg++;

                            j=j-dist;
                            if(j-dist>=0){
                                seekArq(j-dist);
                                reg2.leDoArq(arquivo);

                            }
                    }
                    seekArq(j);
                    auxreg.gravaNoArq(arquivo);
                movProg++;
            }
            dist=dist/3;
        }
    }

    public void heap(){
        int tl2=filesize(),pai,fe,fd,maior;
        Registro reE = new Registro();
        Registro reD = new Registro();
        Registro rePai = new Registro();
        Registro reMaior = new Registro();

        while(tl2>1){
            for(pai=tl2/2-1; pai>=0 ; pai--){
                fe=2*pai+1;
                fd=fe+1;
                maior=fe;
                seekArq(fd);
                reD.leDoArq(arquivo);
                seekArq(fe);
                reE.leDoArq(arquivo);
                compProg++;
                if(fd<tl2 && reD.getCodigo()> reE.getCodigo())
                    maior=fd;
                seekArq(maior);
                reMaior.leDoArq(arquivo);

                seekArq(pai);
                rePai.leDoArq(arquivo);
                compProg++;
                if(reMaior.getCodigo()>rePai.getCodigo()){
                    seekArq(pai);
                    reMaior.gravaNoArq(arquivo);
                    seekArq(maior);
                    rePai.gravaNoArq(arquivo);
                    movProg++;
                    movProg++;
                }

            }

            seekArq(0);
            reE.leDoArq(arquivo);
            seekArq(tl2-1);
            reD.leDoArq(arquivo);

            seekArq(0);
            reD.gravaNoArq(arquivo);
            seekArq(tl2-1);
            reE.gravaNoArq(arquivo);
            movProg++;
            movProg++;
            tl2--;


        }
    }

    public void quicksp(){
        quicksempivo(0,filesize()-1);
    }
    public void quicksempivo(int inicio,int fim){
        Registro regI=new Registro();
        Registro regJ=new Registro();
        int i,j;
        boolean flag =true;
        i=inicio;
        j=fim;

        while (i<j){
            seekArq(i);
            regI.leDoArq(arquivo);
            seekArq(j);
            regJ.leDoArq(arquivo);
            if(flag){
                compProg++;

                while(i<j && regI.getCodigo()<= regJ.getCodigo()){
                    i++;
                    seekArq(i);
                    compProg++;
                    regI.leDoArq(arquivo);
                }


            }
            else{
                compProg++;

                while(i<j && regJ.getCodigo()>=regI.getCodigo()){
                    j--;
                    compProg++;
                    seekArq(j);
                    regI.leDoArq(arquivo);
                }

            }

            seekArq(i);
            regI.leDoArq(arquivo);
            seekArq(j);
            regJ.leDoArq(arquivo);

            seekArq(i);
            regJ.gravaNoArq(arquivo);
            seekArq(j);
            regI.gravaNoArq(arquivo);
            movProg++;
            movProg++;
        }

        if(inicio<i-1){
            quicksempivo(inicio,i-1);
        }
        if(j+1<fim){
            quicksempivo(j+1,fim);
        }
    }

    public void quickcpivo(){
        quickcompivo(0,filesize()-1);
    }
    public void quickcompivo(int inicio,int fim){
        int pivo= (inicio+fim)/2;
        int i=inicio, j=fim;

        Registro regI = new Registro();
        Registro regJ = new Registro();
        Registro regPivo = new Registro();

        seekArq(pivo);
        regPivo.leDoArq(arquivo);

        while (i<j){
            seekArq(i);
            regI.leDoArq(arquivo);
            seekArq(j);
            regJ.leDoArq(arquivo);
            compProg++;
            while(regI.getCodigo()<regPivo.getCodigo()){
                compProg++;
                i++;
                seekArq(i);
                regI.leDoArq(arquivo);
            }
            compProg++;
            while(regJ.getCodigo()>regPivo.getCodigo()){
                compProg++;
                j--;
                seekArq(j);
                regJ.leDoArq(arquivo);
            }

            if(i<=j){
                seekArq(i);
                regI.leDoArq(arquivo);

                seekArq(j);
                regJ.leDoArq(arquivo);

                seekArq(i);
                regJ.gravaNoArq(arquivo);

                seekArq(j);
                regI.gravaNoArq(arquivo);
                movProg++;
                movProg++;
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

    public void particao (Arquivo_Java arq1,Arquivo_Java arq2){
        int meio=filesize()/2;
        Registro reg=new Registro();

        for(int i=0 ;i<meio;i++){
            seekArq(i);
            reg.leDoArq(arquivo);
            arq1.seekArq(i);
            reg.gravaNoArq(arq1.arquivo);

            seekArq(i+meio);
            reg.leDoArq(arquivo);
            arq2.seekArq(i);
            reg.gravaNoArq(arq2.arquivo);
            movProg++;
            movProg++;
        }
      /*  System.out.println("arquivo 1");
        arq1.exibirArq();
        System.out.println("arquivo 2");
        arq2.exibirArq();
        System.out.println("------------------");*/
    }

    public void fusao_1(Arquivo_Java arq1, Arquivo_Java arq2,int seq){
        Registro regI = new Registro();
        Registro regJ = new Registro();

        int i=0,j=0,aux=seq, k=0;

        while(k<filesize()){

            while(i<seq && j<seq){

                arq1.seekArq(i);
                regI.leDoArq(arq1.arquivo);
                arq2.seekArq(j);
                regJ.leDoArq(arq2.arquivo);

                seekArq(k);
                compProg++;
                if(regI.getCodigo()< regJ.getCodigo()){

                    regI.gravaNoArq(arquivo);
                    movProg++;
                    i++;
                    k++;

                }
                else{
                    regJ.gravaNoArq(arquivo);
                    movProg++;
                    j++;
                    k++;
                }
            }

            arq1.seekArq(i);
            regI.leDoArq(arq1.arquivo);
            arq2.seekArq(j);
            regJ.leDoArq(arq2.arquivo);

            seekArq(k);

            while(i<seq){
                regI.gravaNoArq(arquivo);
                movProg++;
                i++;
                k++;
                arq1.seekArq(i);
                regI.leDoArq(arq1.arquivo);
                seekArq(k);
            }
            while(j<seq){
                regJ.gravaNoArq(arquivo);
                movProg++;
                j++;
                k++;
                arq2.seekArq(j);
                regJ.leDoArq(arq2.arquivo);
                seekArq(k);
            }
            seq=seq+aux;
        }




    }

    public void merge_1(){
        File file1 = new File("arq1");
        File file2 = new File("arq2");
        if (file1.exists()) {
            file1.delete();
        }
        if (file2.exists()) {
            file2.delete();
        }

        Arquivo_Java arq1=new Arquivo_Java("arq1.dat");
        Arquivo_Java arq2=new Arquivo_Java("arq2.dat");

        int seq=1;

        while(seq<filesize()){
            particao(arq1,arq2);
            fusao_1(arq1,arq2,seq);
            seq=seq*2;
        }
       // System.exit(0);
    }

    public void fusao_2(Arquivo_Java aux,int ini1,int fim1,int ini2,int fim2){
        int i=ini1,j=ini2,k=0;
        Registro regI=new Registro();
        Registro regJ = new Registro();

        while(i<=fim1 && j<=fim2){

            seekArq(i);
            regI.leDoArq(arquivo);
            seekArq(j);
            regJ.leDoArq(arquivo);
            compProg++;
            if(regI.getCodigo()< regJ.getCodigo()){
                aux.seekArq(k);
                regI.gravaNoArq(aux.arquivo);
                movProg++;
                k++;
                i++;
            }
            else{
                aux.seekArq(k);
                regJ.gravaNoArq(aux.arquivo);
                movProg++;
                k++;
                j++;

            }
        }

        seekArq(i);
        regI.leDoArq(arquivo);
        seekArq(j);
        regJ.leDoArq(arquivo);

        aux.seekArq(k);
        while(i<=fim1){
            regI.gravaNoArq(aux.arquivo);
            movProg++;
            i++;
            k++;
            aux.seekArq(k);
            seekArq(i);
            regI.leDoArq(arquivo);
        }
        while(j<=fim2){
            regJ.gravaNoArq(aux.arquivo);
            movProg++;
            j++;
            k++;
            aux.seekArq(k);
            seekArq(j);
            regJ.leDoArq(arquivo);
        }
        for(i=0;i<k;i++){
            aux.seekArq(i);
            regI.leDoArq(aux.arquivo);

            seekArq(i+ini1);
            regI.gravaNoArq(arquivo);
            movProg++;
        }


    }

    public void mergeSort(){
        Arquivo_Java aux= new Arquivo_Java("arq2.dat");
        merge_2(aux,0,filesize()-1);
    }
    public void merge_2(Arquivo_Java aux,int esq,int dir){
        int meio;

        if(esq<dir){
            meio=(esq+dir)/2;
           // System.out.println("esq="+esq+"dir="+dir);
            merge_2(aux,esq,meio);
            merge_2(aux,meio+1,dir);

            fusao_2(aux,esq,meio,meio+1,dir);

        }

    }

    public void Gnome(){
        Registro reg=new Registro();
        Registro reg2=new Registro();
        int i=1;

        seekArq(i);
        reg.leDoArq(arquivo);
        seekArq(i-1);
        reg2.leDoArq(arquivo);
        while(i<filesize()){
            compProg++;
            if(i==0 || reg2.getCodigo()<reg.getCodigo()){
                i++;
            }
            else{
                seekArq(i);
                reg.leDoArq(arquivo);
                seekArq(i-1);
                reg2.leDoArq(arquivo);

                seekArq(i);
                reg2.gravaNoArq(arquivo);

                seekArq(i-1);
                reg.gravaNoArq(arquivo);
                movProg++;
                movProg++;
                i--;

            }

            seekArq(i);
            reg.leDoArq(arquivo);
            seekArq(i-1);
            reg2.leDoArq(arquivo);

        }

    }

    public void couting(){
        Arquivo_Java arq2 = new Arquivo_Java("arq.dat");
        int pos,j,k,i;
        Registro reg=new Registro();
        Registro aux=new Registro();


        int tl=filesize(),maior=0;
        seekArq(0);
        reg.leDoArq(arquivo);
        for(i=0; i<tl; i++){
            compProg++;
            if(reg.getCodigo()>maior){
                maior=reg.getCodigo();
            }
            seekArq(i);
            reg.leDoArq(arquivo);
        }
        maior++;

       reg.setCodigo(0);
       // reg=new Registro(0);
        for(i=0; i<maior; i++){
            arq2.seekArq(i);
            reg.gravaNoArq(arq2.arquivo);
            movProg++;
        }



        for(i=0; i<tl; i++){
            seekArq(i);
            reg.leDoArq(arquivo);

            arq2.seekArq(reg.getCodigo());
            aux.leDoArq(arq2.arquivo);

            aux.setCodigo(aux.getCodigo()+1);
            arq2.seekArq(reg.getCodigo());
            aux.gravaNoArq(arq2.arquivo);
            movProg++;
        }

        for(i=0,j=0; i<tl; j++){
            arq2.seekArq(j);
            aux.leDoArq(arq2.arquivo);

            for(k= aux.getCodigo();k>0;k--,i++){
                seekArq(i);
                aux.setCodigo(j);
                aux.gravaNoArq(arquivo);
                movProg++;
            }



        }



    }

    public int getMovProg() {
        return movProg;
    }

    public void ShakeSort ()
    {
        int i,j,inicio=0, fim=filesize()-1;
        boolean flag = true;
        Registro r1 = new Registro();
        Registro r2 = new Registro();


        while (inicio < fim && flag)
        {
            flag = false;
            for (i=inicio; i < fim;i++)
            {
                seekArq(i);
                r1.leDoArq(arquivo);
                seekArq(i+1);
                r2.leDoArq(arquivo);
                compProg++;
                if (r1.getCodigo() > r2.getCodigo())
                {
                    seekArq(i);
                    r2.gravaNoArq(arquivo);
                    seekArq(i+1);
                    r1.gravaNoArq(arquivo);
                    flag = true;
                }
            }
            fim--;
            for (i=fim; i > inicio;i--)
            {
                seekArq(i);
                r1.leDoArq(arquivo);
                seekArq(i-1);
                r2.leDoArq(arquivo);
                compProg++;
                if (r1.getCodigo() < r2.getCodigo())
                {
                    seekArq(i);
                    r2.gravaNoArq(arquivo);
                    seekArq(i-1);
                    r1.gravaNoArq(arquivo);
                    movProg++;
                    movProg++;
                    flag = true;
                }
            }
            inicio++;
        }
    }



}
