//15.Write a program to create a registration form with different controls, menus and demonstrate event handling. 
import java.awt.*;
import java.awt.event.*;

public class prg15 extends Frame implements ActionListener {
    Label lblTitle, lblName, lblCity, lblGender;
    TextField txtName;
    Choice cityChoice;
    CheckboxGroup genderGroup;
    Checkbox male, female;
    Button btnSubmit;

    public prg15() {
        setTitle("AWT Registration Form");
        setSize(300, 400);
        setLayout(new FlowLayout());
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        lblName = new Label("Full Name:");
        txtName = new TextField(20);
        lblCity = new Label("City:");
        cityChoice = new Choice();
        cityChoice.add("Delhi");
        cityChoice.add("Telangana");
        cityChoice.add("Andhra Pradesh");
        lblGender = new Label("Gender:");
        genderGroup = new CheckboxGroup();
        male = new Checkbox("Male", genderGroup, true);
        female = new Checkbox("Female", genderGroup, false);

        btnSubmit = new Button("Submit");
        
        btnSubmit.addActionListener(this);

        add(lblName); add(txtName);
        add(lblGender); add(male); add(female);
        add(lblCity); add(cityChoice);
        add(btnSubmit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String name = txtName.getText();
        String city = cityChoice.getSelectedItem();
        String gender = genderGroup.getSelectedCheckbox().getLabel();

        System.out.println("Data Received:");
        System.out.println("Name: " + name + " | Gender: " + gender + " | City: " + city);
    }

    public static void main(String[] args) {
        new prg15();
    }
}