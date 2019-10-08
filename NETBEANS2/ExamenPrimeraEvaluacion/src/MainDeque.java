public class MainDeque {
    public static void main(String[] args) {
      Deque deque=new Deque(10);
      deque.insertaIzquierda(4);
      deque.insertaIzquierda(5);
      //deque.insertaDerecha(6);
      //deque.insertaDerecha(9);
      //deque.borraDerecha();
      deque.borraIzquierda();
      deque.visualiza();
    }
}
