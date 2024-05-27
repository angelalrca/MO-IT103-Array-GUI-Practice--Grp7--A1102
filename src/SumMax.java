

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SumMax {

    public static void main(String[] args) {
        JFrame frame = new JFrame("SumMax Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 5, 5, 5));

        JLabel arrayLabel = new JLabel("Enter integers (should be separated by comma):");
        JTextField arrayInput = new JTextField();
        panel.add(arrayLabel);
        panel.add(arrayInput);

        JLabel maxLabel = new JLabel("Max: ");
        JLabel maxOutput = new JLabel();
        panel.add(maxLabel);
        panel.add(maxOutput);
        
        JLabel sumLabel = new JLabel("Sum: ");
        JLabel sumOutput = new JLabel();
        panel.add(sumLabel);
        panel.add(sumOutput);
        
        JButton calculateButton = new JButton("Calculate for Sum and Max Value");
        calculateButton.setBackground(Color.PINK);

        panel.add(new JLabel());
        panel.add(calculateButton);


        frame.getContentPane().add(panel, BorderLayout.CENTER);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String input = arrayInput.getText();
                    String[] parts = input.split(",");
                    int[] myArray = new int[parts.length];

                    for (int i = 0; i < parts.length; i++) {
                        myArray[i] = Integer.parseInt(parts[i].trim());
                    }

                    
                    int sum = 0;
                    int max = myArray[0];
                    for (int i = 0; i < myArray.length; i++) {
                        sum += myArray[i];
                        if (myArray[i] > max) {
                            max = myArray[i];
                        }
                    }

                    sumOutput.setText(String.valueOf(sum));
                    maxOutput.setText(String.valueOf(max));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid integers separated by commas.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.setVisible(true);
    }
}