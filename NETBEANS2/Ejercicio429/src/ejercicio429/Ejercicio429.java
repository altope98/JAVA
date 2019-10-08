package ejercicio429;
public class Ejercicio429 {
    public static void main(String[] args) {
        System.out.println("Q U I N I E L A");
	System.out.println("_________");
            for (int i=1;i<=15 ;i++ ){
                int n=(int)(Math.random()*10+1);
                switch (n)
                {
                    case 1:
                    case 3:
                    case 4:
                    case 5:System.out.println("Partido "+i+" : 1");break;
                    case 6:
                    case 7:
                    case 8:System.out.println("Partido "+i+" : X");break;
                    case 9:
                    case 10:System.out.println("Partido "+i+" : 2");break;
                }
            }
    }
}
