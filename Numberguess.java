import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class Numberguess extends JFrame implements ActionListener {

    JLabel titleLabel;
    JLabel messageLabel;
    JTextField guessField;
    JButton guessButton;
    JButton restartButton;

    int numberToGuess;
    int attempts;

    Random random = new Random();

    Numberguess() {

        setTitle("Number Guessing Game");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(30, 30, 30));

        titleLabel = new JLabel("Number Guessing Game");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        messageLabel = new JLabel("Guess a number between 1 and 100");
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        messageLabel.setForeground(Color.CYAN);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        guessField = new JTextField();
        guessField.setFont(new Font("Arial", Font.PLAIN, 20));
        guessField.setHorizontalAlignment(JTextField.CENTER);

        guessButton = new JButton("Guess");
        guessButton.setFont(new Font("Arial", Font.BOLD, 18));
        guessButton.setBackground(Color.GREEN);
        guessButton.addActionListener(this);

        restartButton = new JButton("Restart");
        restartButton.setFont(new Font("Arial", Font.BOLD, 18));
        restartButton.setBackground(Color.ORANGE);
        restartButton.addActionListener(e -> restartGame());

        setLayout(new GridLayout(5, 1, 10, 10));

        add(titleLabel);
        add(messageLabel);
        add(guessField);
        add(guessButton);
        add(restartButton);

        startGame();

        setVisible(true);
    }

    void startGame() {
        numberToGuess = random.nextInt(100) + 1;
        attempts = 0;
    }

    void restartGame() {
        startGame();
        guessField.setText("");
        messageLabel.setText("New Game Started! Guess again.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String input = guessField.getText();

        if (input.isEmpty()) {
            messageLabel.setText("Please enter a number!");
            return;
        }

        int guess = Integer.parseInt(input);

        attempts++;

        if (guess < numberToGuess) {
            messageLabel.setText("Too Low! Try Again.");
        } else if (guess > numberToGuess) {
            messageLabel.setText("Too High! Try Again.");
        } else {
            messageLabel.setText("🎉 Correct! Attempts: " + attempts);
        }

        guessField.setText("");
    }

    public static void main(String[] args) {
        new Numberguess();
    }
}