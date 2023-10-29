/**GameUI sirve para mostrar una interfaz grafica con la cual el usuario puede
 interactuar y donde se muestran los progresos de la partida**/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class GameUI extends javax.swing.JFrame {
    
    private JButton[][] buttons;
    private final TicTacToe game;

    public GameUI(TicTacToe game) {
        this.game = game;
        initializeUI();
    }
    
    private void initializeUI() {
        setTitle("Tic-Tac-Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new GridLayout(3, 3));

        buttons = new JButton[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].setFont(new Font("Arial", Font.PLAIN,
                        60));
                add(buttons[row][col]);

                final int finalRow = row;
                final int finalCol = col;
                buttons[row][col].addActionListener((ActionEvent e) -> {
                    onButtonClick(finalRow, finalCol);
                });
            }
        }

        setVisible(true);
    }

    private void onButtonClick(int row, int col) {
    if (game.realizarMovimiento(row, col)) {
        JButton button = buttons[row][col];
        button.setText(game.getCurrentPlayerSymbol());

        Jugador ganador = game.comprobarGanador();
        if (ganador != null) {
            JOptionPane.showMessageDialog(this, "Ganador: " + 
                    ganador.getNombre());
            resetGame();
        } else if (game.comprobarEmpate()) {
            JOptionPane.showMessageDialog(this, "Empate");
            resetGame();
        } else {
            // Cambiar el color de fondo de acuerdo al turno
            if (game.getCurrentPlayerSymbol().equals("X")) {
                button.setBackground(Color.BLUE); 
            } else {
                button.setBackground(Color.RED); 
            }
        }
    }
}

    private void resetGame() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
            }
        }
        game.reset();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
