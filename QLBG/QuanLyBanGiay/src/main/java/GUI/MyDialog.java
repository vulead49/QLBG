/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Anh
 */
public class MyDialog extends JDialog {

    public static final int SUCCESS_DIALOG = 1;
    public static final int ERROR_DIALOG = 2;
    public static final int WARNING_DIALOG = 3;

    public MyDialog(String message, int dialogType) {
        setTitle("Thông báo");
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(350, 150);
        setLocationRelativeTo(null);

        JLabel lblMessage = new JLabel(message, SwingConstants.CENTER);
        lblMessage.setFont(lblMessage.getFont().deriveFont(16f));

        switch (dialogType) {
            case SUCCESS_DIALOG -> lblMessage.setIcon(UIManager.getIcon("OptionPane.informationIcon"));
            case ERROR_DIALOG -> lblMessage.setIcon(UIManager.getIcon("OptionPane.errorIcon"));
            case WARNING_DIALOG -> lblMessage.setIcon(UIManager.getIcon("OptionPane.warningIcon"));
        }

        JButton btnOK = new JButton("OK");
        btnOK.addActionListener(e -> dispose());

        JPanel panel = new JPanel();
        panel.add(btnOK);

        add(lblMessage, "Center");
        add(panel, "South");

        setVisible(true);
    }
}

