package com.example.raymond.eventfloc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

/**
 * Created by Vanessa on 3/05/2015.
 */
public class RegisterActivity extends ActionBarActivity {
    public static final String EXTRA_REGISTER_CLICKED = "com.example.raymond.eventfloc.registration";

    EditText registerFirstName;
    EditText registerLastName;
    EditText registerEmail;
    EditText registerPassword;
    EditText registerConfirmPassword;
    RadioButton registerSocietyType;
    RadioButton registerStudentType;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerSetButtons();
        final DatabaseQueries dq = new DatabaseQueries(this);

        //-----------CRASHES ON CLICK FOR SOME REASON-------------------
        registerSocietyType.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                registerFirstName.setHint("Society Name");
                registerLastName.setHint("Faculty");
            }
        });

        registerStudentType.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                registerFirstName.setHint("James Name");
                registerLastName.setHint("Last Name");
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(registerPassword == registerConfirmPassword){
                    if(registerStudentType.isSelected()){

                        //IS THIS RIGHT?
                        Student s = null;
                        try {
                            s = fillStudent(v);
                        } catch (InvalidKeySpecException e) {
                            e.printStackTrace();
                        } catch (NoSuchAlgorithmException e) {
                            e.printStackTrace();
                        }
                        dq.insertStudent(s);
                        System.out.println(s.toString());
                    }
                    else if (registerSocietyType.isSelected()){
                        Society s = fillSociety(v);
                        dq.insertSociety(s);
                        System.out.println(s.toString());
                    }
                    passwordToast(true);
                    Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(i);
                }
                else if (registerPassword != registerConfirmPassword){
                    //WHAT HAPPENS IF PASSWORDS ENTERED DON'T MATCH?

                    //-------------DOESN'T WORK. ALWAYS SHOWS NON-MATCHING PASSWORD TOAST-----------
                    passwordToast(false);
                }


            }
        });

    }


    /**
     * Change the toast if some fields are correct/incorrect
     * @param goodPassword
     */
    public void passwordToast(boolean goodPassword){
        int toastMessage = 0;


        if(goodPassword = true){
            toastMessage = R.string.matching_password;

        }
        else if (goodPassword = false){
            toastMessage = R.string.nonmatching_password;
        }

        Toast.makeText(RegisterActivity.this, toastMessage, Toast.LENGTH_SHORT).show();

    }




    /**
     * Set the buttons
     */
    public void registerSetButtons() {
        registerFirstName = (EditText) findViewById(R.id.editFirstname);
        registerLastName = (EditText) findViewById(R.id.editLastname);
        registerEmail = (EditText) findViewById(R.id.editEmail);
        registerPassword = (EditText) findViewById(R.id.editPassword);
        registerConfirmPassword = (EditText) findViewById(R.id.password_confirm);
        registerStudentType = (RadioButton) findViewById(R.id.radioButton2);
        registerSocietyType = (RadioButton) findViewById(R.id.radioButton2);
        registerButton = (Button)findViewById(R.id.registerButton);
    }


    /**
     * Creates a student with the filled in registration form
     *
     * @param view
     * @return
     */
    public Student fillStudent(View view) throws InvalidKeySpecException, NoSuchAlgorithmException {
        DatabaseQueries dq = new DatabaseQueries(this);

        String firstName = registerFirstName.getText().toString();
        String lastName = registerLastName.getText().toString();
        String email = registerEmail.getText().toString();
        String password = registerPassword.getText().toString();
        String confirmPassword = registerConfirmPassword.getText().toString();
        int userType = 0;
        if (registerStudentType.isSelected()) {
            userType = 1;
        } else if (registerSocietyType.isSelected()) {
            userType = 2;
        }

        String hashedPassword;

        Student s = new Student();
        s.setFirstName(firstName);
        s.setLastName(lastName);
        s.setUserEmail(email);
        if (password.equals(confirmPassword)) {
            hashedPassword = PasswordHash.createHash(password);
            s.setPassword(hashedPassword);
        }

        s.setUserType(userType);

        return s;

    }

    /**
     * When Radio button selected, changes fields
     *
     * @param v
     */
    private void radioUserType(View v) {

        if (v == registerSocietyType) {
            registerFirstName.setHint("Society Name");
            registerLastName.setHint("Faculty");

        } else if (v == registerStudentType) {
            registerFirstName.setHint("First Name");
            registerLastName.setHint("Last Name");
       }
    }


    /**
     * Gets societ details from filled out registration form
     *
     * @param v
     * @return
     */
    private Society fillSociety(View v) {
        DatabaseQueries dq = new DatabaseQueries(this);

        String societyName = registerFirstName.getText().toString();
        String societyEmail = registerEmail.getText().toString();

        //HOW DO WE DO APPROVED DATE?
        Date societyDate = new Date();
        String societyFaculty = registerLastName.getText().toString();

        String password = registerPassword.getText().toString();
        String confirmPassword = registerConfirmPassword.getText().toString();
        int userType = 0;
        if (registerStudentType.isSelected()) {
            userType = 1;
        } else if (registerSocietyType.isSelected()) {
            userType = 2;
        }

        Society s = new Society();
        s.setSocietyName(societyName);
        s.setUserEmail(societyEmail);
        s.setApprovalDate(societyDate);
        s.setPassword(password);
        s.setSocietyFaculty(societyFaculty);

        return s;
    }


}


