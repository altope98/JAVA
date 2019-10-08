public class Bombo {
	protected boolean bombo[];
	public Bombo(int n){
		bombo = new boolean[n];
		for(int i=0; i<n;i++){
			bombo[i] = true;
		}
	}

    Bombo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	public int totalBolas(){
		int total = 0;
		for (int i=0;i<bombo.length ;i++ ){
			if (bombo[i]){
				total++;
			}
		}
		return total;
	}

	public boolean quedanBolas(){
		if (totalBolas()>0){
			return true;
		}
		return false;
	}

	public void meteBolas(int bola){
		if(bola >=0 && bola<bombo.length){
			bombo[bola] = true;
		}else{
			System.out.println("No se pudo introducir la bola");
		}
	}

	public int sacaBola(){
		int bola =-1;
		if (quedanBolas()){
			do{
				bola =(int) (Math.random()*bombo.length);
			
			}while(!bombo[bola]); //significa que si es falso
			bombo[bola] = false;
		}else{
			System.out.println("El bombo esta vacio");
		}
		return bola;
	}
}
