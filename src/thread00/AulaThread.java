package cursojava.thread;

import javax.swing.JOptionPane;

public class AulaThread {

  public static void main(String[] args) throws InterruptedException {

    /* TREAD RODANDO EM PARALELO DO EMAIL */
    Thread threadEmail = new Thread(thread1);
    threadEmail.start();

    /* |********************DIVISÃO DAS TREADS********************| */

    /* TREAD RODANDO EM PARALELO DO NFE */
    Thread threadNFE = new Thread(thread2);
    threadNFE.start();


    System.out.println("CHEGOU AO FIM DO CÓDIGO DE TESTE DE THREAD");
    JOptionPane.showMessageDialog(null, "Sistema continua executando para o usuário");

  }

  private static Runnable thread2 = new Runnable() {

    @Override
    public void run() {

      /* CODIGO DE ENVIO DE EMAIL EXECUTANDO EM PARALELO ENVIO DE NOTA FISCAL */
      for (int pos = 0; pos < 10; pos++) {

        /** EXECUTAR ENVIO COM TEMPO DE PARADA, OU TEMPO DETERMINADO **/
        System.out.println("Executando algo rotina, por exemplo envio de nfe");

        try {
          Thread.sleep(4000);/** DÁ UM TEMPO **/
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      } /* Fim do codigo paralelo */

    }
  };

  private static Runnable thread1 = new Runnable() {

    @Override
    public void run() {

      /* CODIGO DE ENVIO DE EMAIL EXECUTANDO EM PARALELO */
      for (int pos = 0; pos < 10; pos++) {

        /** EXECUTAR ENVIO COM TEMPO DE PARADA, OU TEMPO DETERMINADO **/
        System.out.println("Executando algo rotina, por exemplo envio de email");

        try {
          Thread.sleep(1000);/** DÁ UM TEMPO **/
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      } /* Fim do codigo paralelo */

    }

  };
}
