import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Login {
    private JTextArea textArea;
    private JTextField nameText;

    public void createAndDisplayGui() {
        JFrame frame = new JFrame("Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(createHeading(), BorderLayout.PAGE_START);
        frame.add(createForm(), BorderLayout.CENTER);
        frame.add(createButtonsPanel(), BorderLayout.PAGE_END);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private JButton createButton(String text, int mnemonic, ActionListener listener) {
        JButton button = new JButton(text);
        button.setMnemonic(mnemonic);
        button.addActionListener(listener);
        return button;
    }

    private JPanel createButtonsPanel() {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(createButton("Submit", KeyEvent.VK_S, this::submit));
        return buttonsPanel;
    }

    private JPanel createForm() {
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets.bottom = 5;
        gbc.insets.left = 10;
        gbc.insets.right = 10;
        gbc.insets.top = 0;
        JLabel inputLabel = new JLabel("Input");
        form.add(inputLabel, gbc);
        gbc.gridx = 1;
        nameText = new JTextField(16);
        form.add(nameText, gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel outputLabel = new JLabel("Output");
        form.add(outputLabel, gbc);
        gbc.gridx = 1;
        textArea = new JTextArea(2, 30);
        textArea.setEditable(false);
        textArea.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        form.add(scrollPane, gbc);
        return form;      
    }

    private JPanel createHeading() {
        JPanel heading = new JPanel();
        JLabel label = new JLabel("TRANSLATER");
        label.setFont(label.getFont().deriveFont(Font.BOLD, 14.0f));
        heading.add(label);
        return heading;
    }

    private void submit(ActionEvent event) {
        textArea.setText("");
        String name = nameText.getText();
        Properties p = new Properties();
        try {
            FileReader reader = new FileReader("translate.properties");
            p.load(reader);
        }
        catch (Exception e){
        }
        GoogleTranslate t = new GoogleTranslate(p.getProperty("google.apikey"));
        try {
            String tt = t.translate(name, "de");
            textArea.append(tt);
        }
        catch(Exception e) {
        } 
    }
}
