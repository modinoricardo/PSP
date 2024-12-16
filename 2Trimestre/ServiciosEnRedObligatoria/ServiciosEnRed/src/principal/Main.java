package principal;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce tu destinatario:");
        String destinatario = sc.nextLine();

        System.out.println("Introduce el asunto:");
        String asunto = sc.nextLine();

        System.out.println("Introduce el mensaje de texto:");
        String mensaje = sc.nextLine();

        boolean conAdjunto = false;
        String stringAdjunto;

        do {
            System.out.println("¿Desea incluir un adjunto? (SI/NO):");
            stringAdjunto = sc.nextLine();

            if (stringAdjunto.equalsIgnoreCase("SI")) {
                conAdjunto = true;
                break;
            } else if (stringAdjunto.equalsIgnoreCase("NO")) {
                conAdjunto = false;
                break;
            } else {
                System.out.println("Debe ser un SI o un NO.");
            }
        } while (true);

        String usuario = "da2d1e.2024@gmail.com";
        String password = "nuzw uevk dwym pxbu";

        GestorCorreo gestor = new GestorCorreo();
        gestor.setPropiedadesServidorSMTP(usuario, password);

        try {
            if (conAdjunto) {
                System.out.println("Introduce la ruta del archivo adjunto:");
                String rutaArchivo = sc.nextLine();
                File archivo = new File(rutaArchivo);

                if (archivo.exists() && archivo.isFile()) {
                    gestor.enviarMensajeTextoConAdjunto(usuario, destinatario, asunto, mensaje, archivo);
                    System.out.println("Correo enviado con adjunto.");
                } else {
                    System.out.println("El archivo especificado no existe o no es válido.");
                }
            } else {
                gestor.enviarMensajeTexto(usuario, destinatario, asunto, mensaje);
                System.out.println("Correo enviado sin adjunto.");
            }
        } catch (Exception e) {
            System.out.println("Error al enviar el correo: " + e.getMessage());
        }
        
            sc.close();
    }
}
