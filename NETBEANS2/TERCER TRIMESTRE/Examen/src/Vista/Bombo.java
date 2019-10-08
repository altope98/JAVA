package Vista;
public class Bombo {
    private int n;
    private boolean bombo[];
    public Bombo(int n){
        this.n=n;
        bombo=new boolean[n];
    }
    public Bombo(){
        n=10;
        bombo=new boolean[n];
    }
    public int sacaBola(){
        int bola;
        do{
            bola =(int) (Math.random()*n);
        }while(bombo[bola]==true);
        bombo[bola]=true;
        return bola;
    }
    public void meteBola(int bola){
        bombo[bola]=false;
    }
    public boolean quedanBolas(){
        for (int i=0; i < n; i++){
            if (bombo[i]==false){
                return false;
            }
        }
        return true;
    }
}
