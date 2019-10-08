public class Lista {
    protected int n;
    protected int v[];
	public Lista(int n)
	{
            this.n=n;
            v=new int[n];
            for (int i=0;i<v.length;i++){
                v[i]=0;                 
            }        
        }               
      public void addElement(int num){
          if(capacity()!=0){
          if(v[0]!=0){
              for(int i=0;i<v.length;i++){
              if(v[i]==0){
                  v[i]=num;
                  return;
              }
          }
          }else{
              v[0]=num;
          }
        }else{System.out.println("La lista esta llena");} 
      }
      public boolean removeElement(int num){
          for(int i=0;i<v.length;i++){
              if(v[i]==num){
                for(int j=i; j<v.length-1; j++){
                   v[j] = v[j+1];  
                }
                return true;
              }
          }return false;
      }
      public int size(){
          int size=0;
          for(int i=0;i<v.length;i++){
              if(v[i]!=0){
                  size++;
              }
          }return size;
      }
      public int capacity(){
          int capacity=0;
          capacity=v.length-size();
          return capacity;
      }
      public boolean isEmpty(){
          for(int i=0;i<v.length;i++){
              if(v[i]!=0){       
                  return false;
              }
          }
          return true;
      }
      public boolean contains(int num){
          for(int i=0;i<v.length;i++){
              if(v[i]==num){
                  return true;
              }
          }
          return false;
      }
      public int elementAt(int pos){
          return v[pos];
      }
      public int firstElement(){
          int aux=0;
          for(int i=0;i<v.length;i++){
              if(v[i]!=0){
                  aux=v[i];
              }
          }
          return aux;
      }
      public int lastElement(){
          int aux=0;
          for(int i=v.length-1;i>0;i--){
              if(v[i]!=0){
                  aux=v[i];
              }
          }
          return aux;
      }
      public void removeElementAt(int pos){
          v[pos]=0;
          for(int j=pos; j<v.length-1; j++){
                   v[j] = v[j+1];  
                }
      }
      public void insertElementAt(int num,int pos){
          if(capacity()!=0){
         for(int i=v.length-1; i>pos; i--){
                v[i] = v[i-1];  
        }
         v[pos]=num;
          }else{System.out.println("La lista esta llena");}
      }
          public void visualiza(){
              for (int i=0;i<v.length;i++){
                  if(v[i]!=0){
                      System.out.print(v[i]+"  ");
                  }
              }
              System.out.println("  ");
          }
           public void visualizaVector(){
              for (int i=0;i<v.length;i++){
                System.out.print(v[i]+"  ");
              }
              System.out.println("  ");
          }
}
