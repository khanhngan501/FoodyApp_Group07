package hcmute.edu.vn.nhom07.foodyapp_group07;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    //Declaration EditTexts
    EditText editTextPhone;
    EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextConfirm;

    //Declaration TextInputLayout
    TextInputLayout textInputLayoutPhone;
    TextInputLayout textInputLayoutEmail;
    TextInputLayout textInputLayoutPassword;
    TextInputLayout textInputLayoutConfirm;

    //Declaration Button
    Button buttonRegister;

    //Declaration SqliteHelper
    UserDatabaseHelper userDatabaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userDatabaseHelper = new UserDatabaseHelper(this);
        initTextViewLogin();
        initViews();
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    String Phone = editTextPhone.getText().toString();
                    String Email = editTextEmail.getText().toString();
                    String Password = editTextPassword.getText().toString();
                    String Confirm = editTextConfirm.getText().toString();

                    //Check in the database is there any user associated with  this email
                    if (!userDatabaseHelper.isEmailExists(Email)) {

                        //Email does not exist now add new user to database
                        userDatabaseHelper.addUser(new User(null, Phone, Email, Password));
                        Snackbar.make(buttonRegister, "User created successfully! Please Login ", Snackbar.LENGTH_LONG).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                finish();
                            }
                        }, Snackbar.LENGTH_LONG);
                    }else {

                        //Email exists with email input provided so show error user already exist
                        Snackbar.make(buttonRegister, "User already exists with same email ", Snackbar.LENGTH_LONG).show();
                    }


                }
            }
        });
    }

    //this method used to set Login TextView click event
    private void initTextViewLogin() {
        TextView textViewLogin = (TextView) findViewById(R.id.textViewLogin);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //this method is used to connect XML views to its Objects
    private void initViews() {
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextConfirm = (EditText) findViewById(R.id.editTextConfirm);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutConfirm = (TextInputLayout) findViewById(R.id.textInputLayoutConfirm);
        textInputLayoutPhone = (TextInputLayout) findViewById(R.id.textInputLayoutPhone);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);

    }

    //This method is used to validate input given by user
    public boolean validate() {
        boolean valid = false;

        //Get values from EditText fields
        String Phone = editTextPhone.getText().toString();
        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();
        String Confirm = editTextConfirm.getText().toString();

        //Handling validation for UserName field
        if (Phone.isEmpty()) {
            valid = false;
            textInputLayoutPhone.setError("Please enter valid phone number!");
        } else {
            if (Phone.length() == 10) {
                valid = true;
                textInputLayoutPhone.setError(null);
            } else {
                valid = false;
                textInputLayoutPhone.setError("Please enter valid phone number!");
            }
        }

        //Handling validation for Email field
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
            textInputLayoutEmail.setError("Please enter valid email!");
        } else {
            valid = true;
            textInputLayoutEmail.setError(null);
        }

        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid = false;
            textInputLayoutPassword.setError("Please enter valid password!");
        } else {
            if (Password.length() > 5) {
                valid = true;
                textInputLayoutPassword.setError(null);
            } else {
                valid = false;
                textInputLayoutPassword.setError("Password is to short!");
            }
        }

        //Handling validation for Confirm field
        if (Confirm.isEmpty()) {
            valid = false;
            textInputLayoutConfirm.setError("Please enter valid confirm password!");
        } else {
            if (Confirm.equals(Password)) {
                valid = true;
                textInputLayoutConfirm.setError(null);
            } else {
                valid = false;
                textInputLayoutConfirm.setError("Confirm password isn't valid!");
            }
        }


        return valid;
    }
}