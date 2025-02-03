import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Automation {
    public static void main(String[] args ){

        System.out.println("Example order process...");
        ExecutorService executor = Executors.newFixedThreadPool(4); //crea un pool de 4 hilos
        CountDownLatch latch= new CountDownLatch(4); // etapas de un proceso
//1 : VALIDAR PEDIDO
        executor.submit(() -> {
        try {
            System.out.println("Validate order 1/4");
            Thread.sleep(1000);
            System.out.println("Order validated 1/4");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            latch.countDown(); //finaliza la etapa y puedes pasar al siguiente paso
        }
    });
//2 : PROCESAR PAGO
        executor.submit(() -> {
            try {
                latch.await(); // espera que termine la etapa anterior
                System.out.println("Payment processing 2/4");
                Thread.sleep(1000);
                System.out.println("Payment processed 2/4");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                latch.countDown(); //finaliza la etapa y puedes pasar al siguiente paso
            }
        });
//3 : CREAR FACTURA
        executor.submit(() -> {
            try {
                latch.await(); // espera que termine la etapa anterior
                System.out.println("Bill creating 3/4");
                Thread.sleep(1000);
                System.out.println("Bill created 3/4");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                latch.countDown(); //finaliza la etapa y puedes pasar al siguiente paso
            }
        });
//4 : ENVIAR PEDIDO
        executor.submit(() -> {
            try {
                latch.await(); // espera que termine la etapa anterior
                System.out.println("Send order 4/4");
                Thread.sleep(1000);
                System.out.println("Order sent 4/4");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                latch.countDown(); //finaliza la etapa y puedes pasar al siguiente paso
            }
        });
        //cerrar el pool de hilos - Executorservice
        executor.shutdown();
        try {
            latch.await(); // espera que termine la etapa anterior
            executor.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println("Order processing finished");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
