
package examen1;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


  
public class Examen1 extends JFrame {

    private JTextField nombreField, apellidoPaternoField, apellidoMaternoField, estadoField;
    private JButton generarButton;

    public Examen1() {
        super("Generador de CURP y RFC");

        nombreField = new JTextField(20);
        apellidoPaternoField = new JTextField(20);
        apellidoMaternoField = new JTextField(20);
        estadoField = new JTextField(20);
        generarButton = new JButton("Generar CURP y RFC");

        generarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarCurpYRfc();
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Apellido Paterno:"));
        panel.add(apellidoPaternoField);
        panel.add(new JLabel("Apellido Materno:"));
        panel.add(apellidoMaternoField);
        panel.add(new JLabel("Estado de Nacimiento:"));
        panel.add(estadoField);
        panel.add(generarButton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(panel);
        this.pack();
        this.setVisible(true);
    }

    private void generarCurpYRfc() {
        String nombre = nombreField.getText().toUpperCase();
        String apellidoPaterno = apellidoPaternoField.getText().toUpperCase();
        String apellidoMaterno = apellidoMaternoField.getText().toUpperCase();
        String estado = estadoField.getText().toUpperCase();

        

        String curp = generarCurp(nombre, apellidoPaterno, apellidoMaterno, estado);
        String rfc = generarRfc(nombre, apellidoPaterno, apellidoMaterno);

        JOptionPane.showMessageDialog(this, "CURP: " + curp + "\nRFC: " + rfc);
    }

    private String generarCurp(String nombre, String apellidoPaterno, String apellidoMaterno, String estado) {
        
        return apellidoPaterno.substring(0, 2) + apellidoMaterno.charAt(0) + nombre.charAt(0) + estado.substring(0, 2);
    }

    private String generarRfc(String nombre, String apellidoPaterno, String apellidoMaterno) {
        
        return apellidoPaterno.substring(0, 2) + apellidoMaterno.charAt(0) + nombre.charAt(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Examen1();
            }
        });
    }
}  

