import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginRegistration {
    static Student s1 = new Student();

    // method for login form
    static void LoginForm(){
        JFrame loginFrame = new JFrame("LoginRegistration");// generating new form for the login form

        // username label
        JLabel usernameLabel, passwordLabel;
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(20,30, 100,30);

        // username textfield
        JTextField usernameField;
        usernameField = new JTextField();
        usernameField.setBounds(100,30, 200,30);

        // password label
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(20,80, 100,30);

        // password textfield
        JPasswordField passwordField;
        passwordField = new JPasswordField();
        passwordField.setBounds(100,80, 200,30);

        // login button
        JButton loginButton = new JButton("LoginRegistration");//creating instance of JButton
        loginButton.setBounds(20,130,280, 40);//x axis, y axis, width, height
        loginButton.setBackground(Color.gray);
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);
        loginButton.setForeground(Color.WHITE);

        // new account label
        JLabel newAccountLabel = new JLabel("Don't have an account? ");
        newAccountLabel.setBounds(50, 190, 135, 30);

        // new account button
        JButton newAccountButton = new JButton("Create one.");
        newAccountButton.setBounds(175, 190, 100, 30);
        newAccountButton.setOpaque(false);
        newAccountButton.setContentAreaFilled(false);
        newAccountButton.setBorderPainted(false);
        newAccountButton.setForeground(Color.BLUE);

        // if user don't have an account then onclick close the login frame and open register form frame
        newAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame.dispose();
                RegistrationForm();
            }
        });

        // adding components to frame
        loginFrame.add(loginButton);
        loginFrame.add(usernameLabel);
        loginFrame.add(passwordLabel);
        loginFrame.add(usernameField);
        loginFrame.add(passwordField);
        loginFrame.add(newAccountLabel);
        loginFrame.add(newAccountButton);

        // frame components
        loginFrame.setSize(340,280);//width and height
        loginFrame.setLayout(null);//using no layout managers
        loginFrame.setVisible(true);//making the frame visible
        loginFrame.setLocationRelativeTo(null);//make the JFrame appear to center of screen
        loginFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//close the program on close
    }

    // method for registration form
    static void RegistrationForm(){
        JFrame registerForm = new JFrame("Register");//this is new registration form

        // Student name label
        JLabel studentNameLabel, studentIdLabel;
        studentNameLabel = new JLabel("Student Name");
        studentNameLabel.setBounds(20,30, 100,30);

        // student name textfield
        JTextField studentNameField;
        studentNameField = new JTextField();
        studentNameField.setBounds(110,30, 200,30);

        // student id label
        studentIdLabel = new JLabel("Student ID");
        studentIdLabel.setBounds(20,80, 100,30);

        // student id textfield
        JTextField studentIdField;
        studentIdField = new JTextField();
        studentIdField.setBounds(110,80, 200,30);

        // username label
        JLabel usernameLabel, passwordLabel;

        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(20,130, 100,30);

        // student name textfield
        JTextField usernameField;
        usernameField = new JTextField();
        usernameField.setBounds(110,130, 200,30);

        // student id label
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(20,180, 100,30);

        // student id textfield
        JPasswordField passwordField;
        passwordField = new JPasswordField();
        passwordField.setBounds(110,180, 200,30);

        // submit button
        JButton registerButton = new JButton("Register");//creating instance of JButton
        registerButton.setBounds(20,230,290, 40);//x axis, y axis, width, height
        registerButton.setBackground(Color.gray);
        registerButton.setOpaque(true);
        registerButton.setBorderPainted(false);
        registerButton.setForeground(Color.WHITE);

        registerButton.addActionListener(new ActionListener() {// when user enters the data and hits submit
            @Override
            public void actionPerformed(ActionEvent e) {

                // getting the data from the input fields
                String studentName = studentNameField.getText();
                String studentID = studentIdField.getText();
                int id;

                // here the try catch is used to handle the number exception while converting the string to number
                try {
                    id = Integer.parseInt(studentID);
                }
                catch (NumberFormatException ex)
                {
                    id = 0;
                }
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // check if username or id is already registered in the List
                int count = 0;
                while (s1.students.size() > count) {
                    String errorMsg;

                    // if the input field is empty
                    if(studentName.isEmpty() || studentID.isEmpty() || username.isEmpty() || password.isEmpty()){
                        errorMsg = "Fields can't be empty";
//                        generating dialogbox
                        JFrame errorDialog = new JFrame("Error");

                        JLabel messageLabel = new JLabel(errorMsg);
                        messageLabel.setBounds(20, 20, 300, 40);

                        JButton errorButton = new JButton("OK");
                        errorButton.setBounds(100, 75, 100, 40);
                        errorButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                errorDialog.dispose();
                                studentNameField.setText("");
                                studentIdField.setText("");
                                usernameField.setText("");
                                passwordField.setText("");;
                            }
                        });

//                        adding components to frame
                        errorDialog.add(messageLabel);
                        errorDialog.add(errorButton);

                        errorDialog.setSize(320,170);//width and height
                        errorDialog.setLayout(null);//using no layout managers
                        errorDialog.setVisible(true);//making the frame visible
                        errorDialog.setLocationRelativeTo(null);//make the JFrame appear to center of screen
                        errorDialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//close frame on close
                        break;
                    }

                    // if the user already exists
                    if(s1.students.get(count).userName == username || s1.students.get(count).studentID == id){
                            errorMsg = "Username or Student ID is already registered.";
                        //  generating error dialogbox
                        JFrame errorDialog = new JFrame("Error");

                        JLabel messageLabel = new JLabel(errorMsg);
                        messageLabel.setBounds(20, 20, 300, 40);

                        JButton errorButton = new JButton("OK");
                        errorButton.setBounds(100, 75, 100, 40);
                        errorButton.addActionListener(new ActionListener() {//when user is knowledgeable to his message clear the registration form
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                errorDialog.dispose();
                                studentNameField.setText("");
                                studentIdField.setText("");
                                usernameField.setText("");
                                passwordField.setText("");;
                            }
                        });

                        // adding components to frame
                        errorDialog.add(messageLabel);
                        errorDialog.add(errorButton);

                        // Setting the error dialog frame
                        errorDialog.setSize(320,170);//width and height
                        errorDialog.setLayout(null);//using no layout managers
                        errorDialog.setVisible(true);//making the frame visible
                        errorDialog.setLocationRelativeTo(null);//make the JFrame appear to center of screen
                        errorDialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//close frame on close
                        break;//break the loop once the error is found
                    }
                    count++;
                }

                // if there are none problems then create new student
                Student s2 = new Student();
                s2.setNewStudent(studentName, id, false, new int[]{},username, password);
                s1.students.add(s2);// add the student data to students array pool

            }
        });

        // old account label
        JLabel oldAccountLabel = new JLabel("Already have an account? ");
        oldAccountLabel.setBounds(60, 290, 150, 30);

        // old account button
        JButton oldAccountButton = new JButton("Login");
        oldAccountButton.setBounds(185, 290, 100, 30);
        oldAccountButton.setOpaque(false);
        oldAccountButton.setContentAreaFilled(false);
        oldAccountButton.setBorderPainted(false);
        oldAccountButton.setForeground(Color.BLUE);

        // if user don't have an account then onclick close the login frame and open register form frame
        oldAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerForm.dispose();
                LoginForm();
            }
        });

        // adding components to the frame
        registerForm.add(studentNameField);
        registerForm.add(studentNameLabel);
        registerForm.add(studentIdLabel);
        registerForm.add(studentIdField);
        registerForm.add(registerButton);
        registerForm.add(usernameField);
        registerForm.add(usernameLabel);
        registerForm.add(passwordLabel);
        registerForm.add(passwordField);
        registerForm.add(oldAccountButton);
        registerForm.add(oldAccountLabel);

        // frame components
        registerForm.setSize(350,380);//width and height
        registerForm.setLayout(null);//using no layout managers
        registerForm.setVisible(true);//making the frame visible
        registerForm.setLocationRelativeTo(null);//make the JFrame appear to center of screen
        registerForm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//close frame on close
    }
    public static void main(String args[]){
        RegistrationForm();
    }
}
