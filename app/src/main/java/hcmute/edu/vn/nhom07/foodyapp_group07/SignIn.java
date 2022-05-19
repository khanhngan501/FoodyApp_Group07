package hcmute.edu.vn.nhom07.foodyapp_group07;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignIn extends AppCompatActivity {

    TextView edtEmail,edtPassWord;
    Button btnSignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        //Tiến hành ánh xạ
        edtEmail = (EditText)findViewById(R.id.editTextEmail);
        edtPassWord = (EditText)findViewById(R.id.editTextPassword);
        btnSignIn = (Button)findViewById(R.id.buttonSignIn);

        //Phát sinh sự kiện OnClick
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String email = "lhmn@gmail.com";
//                String password = "lhmn";
//                if(edtEmail.getText().toString().equals(email) && edtPassWord.getText().toString().equals(password)){
//                    Intent intent = new Intent(SignIn.this, HomeActivity.class);
//                    startActivity(intent);
//                }
//                else{
//                    Toast.makeText(getApplicationContext(),R.string.login_error, Toast.LENGTH_LONG).show();
//                }
//                if(edtEmail.getText().length() != 0 && edtPassWord.getText().length() != 0){
//                    if(edtEmail.getText().toString().equals(email) && edtPassWord.getText().toString().equals(password)){
//
//                    }
//                }
            }
        });
    }
}