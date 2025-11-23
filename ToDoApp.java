import javax.swing.*;
import java.awt.*;

public class ToDoApp {

    public static void main(String[] args) {

        JFrame frame = new JFrame("To-Do App");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Task Input Field
        JTextField taskField = new JTextField();
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");

        // Task List
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Panel for input controls
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(taskField);
        panel.add(addButton);

        // Adding components to frame
        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(deleteButton, BorderLayout.SOUTH);

        // Add Action Listener
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if(!task.isEmpty()){
                listModel.addElement(task);
                taskField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Enter a task!");
            }
        });

        // Delete Task
        deleteButton.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if(index != -1) {
                listModel.remove(index);
            } else {
                JOptionPane.showMessageDialog(frame, "Select a task to delete!");
            }
        });

        frame.setVisible(true);
    }
}

