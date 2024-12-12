// Login.java
package com.example.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.example.services.UserService;

public class Login extends JFrame {

    private final UserService userService;

    public Login(ApplicationContext context) {
        // Inicializar el servicio desde el contexto de Spring
        this.userService = context.getBean(UserService.class);

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
        ImageIcon logoIcon = new ImageIcon(
                "C:/Users/oscar/OneDrive/Documentos/ProyectoGames/Wallaport/demo/src/main/java/com/example/Img/fotonduro.png");
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
        JLabel passwordLabel = new JLabel("Contraseña:");
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

        // Acción del botón
        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            char[] password = passwordField.getPassword();

            if (email.isEmpty() || password.length == 0) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el correo y la contraseña.");
                return;
            }

            try {
                boolean isAuthenticated = userService.authenticateUser(email, new String(password));

                if (isAuthenticated) {
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
        // Inicializa Spring Boot y su contexto
        ApplicationContext context = SpringApplication.run(Application.class, args);
    
        // Obtén el UserService directamente del contexto de Spring
        UserService userService = context.getBean(UserService.class);
    
        // Ejecuta el JFrame utilizando SwingUtilities
        SwingUtilities.invokeLater(() -> {
            Login frame = new Login(userService);
            frame.setVisible(true);
        });
    }
