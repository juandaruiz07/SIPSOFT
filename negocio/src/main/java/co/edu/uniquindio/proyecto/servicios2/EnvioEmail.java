package co.edu.uniquindio.proyecto.servicios2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EnvioEmail {


    //Importante hacer la inyección de dependencia de JavaMailSender:
    private final JavaMailSender javaMailSender;

    public EnvioEmail(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    //Pasamos por parametro: destinatario, asunto y el mensaje
    public void enviarCorreoCompra(String to, String subject, String productosComprados, float subtotal, String formaPago, String nombreCliente) {

        SimpleMailMessage email = new SimpleMailMessage();

        email.setTo(to);
        email.setSubject(subject);

        email.setText("Hola " + nombreCliente + "! \nTu compra por " + productosComprados + " se realizo con exito \nEsta tuvo un costo total de $" + subtotal + " \nSe registro el pago por medio de " + formaPago +
                " \nGracias por comprar en Unishop Tienda virtual");


        javaMailSender.send(email);
    }

    public void enviarCorreoPassword(String to, String subject, String nombreCliente, String password) {

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(to);
        email.setSubject(subject);
        email.setText("¡Hola " + nombreCliente + "! \n\nSomos el equipo de soporte de SIPSOFT, tu contraseña de acceso es " + password + ". \n\nEstamos para brindarte el mejor servicio.");
        javaMailSender.send(email);
    }


    public void enviarCorreoLow(String to, String subject, String nombreCliente,String productosLow) {
        System.out.println("Entro a enviarCorreoLow en EnvioEmail, Para : "+to+ "Asunto: "+ subject+ " Nombre gerencial"+ nombreCliente+" ProductosLow: "+ productosLow );
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(to);
        email.setSubject(subject);
        email.setText("¡Hola " + nombreCliente + "! \n\nSomos el equipo de soporte de SIPSOFT, en tu inventario cuentas con unidades bajas de los siguientes productos" + productosLow +". \n\nEstamos para brindarte el mejor servicio.");
        javaMailSender.send(email);

    }
}
