package com.example.Vista;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    public Login() {
        // Configuración del JFrame
        setTitle("Custom JFrame");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel izquierdo (gris)
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.DARK_GRAY);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setPreferredSize(new Dimension(250, 0));

        // Imagen personalizada
        ImageIcon logoIcon = new ImageIcon("C:/Users/oscar/OneDrive/Documentos/ProyectoGames/Wallaport/demo/src/main/java/com/example/Img/fotonduro.png");
        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(new ImageIcon(logoIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Texto bajo la imagen
        JLabel infoLabel = new JLabel("Bienvenido a Wallaport!!");
        infoLabel.setForeground(Color.WHITE);
        infoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        leftPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        leftPanel.add(logoLabel);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        leftPanel.add(infoLabel);

        // Panel derecho (blanco)
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Icono de candado
        JLabel lockIconLabel = new JLabel(new ImageIcon("C:/Users/oscar/OneDrive/Documentos/ProyectoGames/Wallaport/demo/src/main/java/com/example/Img/iniciar.png"));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        rightPanel.add(lockIconLabel, gbc);

        // Etiqueta y campo de texto para correo
        JLabel emailLabel = new JLabel("Correo Electrónico:");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        rightPanel.add(emailLabel, gbc);

        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(2000, 300));
        gbc.gridx = 1;
        gbc.gridy = 1;
        rightPanel.add(emailField, gbc);

        // Etiqueta y campo de texto para contraseña
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        rightPanel.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(2000, 300));
        gbc.gridx = 1;
        gbc.gridy = 2;
        rightPanel.add(passwordField, gbc);

        // Botón de iniciar
        JButton loginButton = new JButton("Iniciar");
        loginButton.setBackground(Color.BLUE);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        rightPanel.add(loginButton, gbc);

        // Acciones del botón
        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            char[] password = passwordField.getPassword();

            try {
                String url = "http://localhost:8080/api/auth/login";
                
                // Crear el cuerpo de la solicitud JSON
                String json = "{\"email\":\"" + email + "\", \"password\":\"" + new String(password) + "\"}";

                // Crear los encabezados HTTP
                HttpHeaders headers = new HttpHeaders();
                headers.set("Content-Type", "application/json");

                // Crear la entidad HTTP con el cuerpo y los encabezados
                HttpEntity<String> entity = new HttpEntity<>(json, headers);

                // Crear una instancia de RestTemplate
                RestTemplate restTemplate = new RestTemplate();

                // Enviar la solicitud POST
                ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

                // Usar el método getStatusCode() y obtener el valor con value()
                if (response.getStatusCode().value() == 200 && response.getBody().contains("Login successful")) {
                    JOptionPane.showMessageDialog(null, "¡Bienvenido!");
                } else {
                    JOptionPane.showMessageDialog(null, "Correo o contraseña incorrectos.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al conectar con el servidor.");
            }
        });

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Login frame = new Login();
            frame.setVisible(true);
        });
    }
}