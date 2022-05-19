package hcmute.edu.vn.nhom07.foodyapp_group07;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    TextView edtPersonName,edtPass, edtConfirm, edtPhone;
    Button btnCreateAcc;
    String ten, mk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Tiến hành ánh xạ
        edtPersonName = (EditText)findViewById(R.id.editTextPersonName);
        edtPass = (EditText)findViewById(R.id.editTextMk);
        btnCreateAcc = (Button)findViewById(R.id.buttonCreateAcc);

        //Phát sinh sự kiện OnClick
        btnCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ten = edtPersonName.getText().toString().trim();
                mk = edtPass.getText().toString().trim();


//
            }
        });
    }
}