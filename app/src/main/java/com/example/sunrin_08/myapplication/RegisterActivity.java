package com.example.sunrin_08.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    EditText edtID,edtPW;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        pref = getSharedPreferences("data",MODE_PRIVATE);
        editor = pref.edit();

        edtID = findViewById(R.id.id);
        edtPW = findViewById(R.id.pw);
        btnRegister = findViewById(R.id.reg);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edtID.getText().toString();
                String pw = edtPW.getText().toString();

                editor.putString("id",id);
                editor.putString("pw",pw);
                editor.apply();

                Toast.makeText(RegisterActivity.this, "회원가입에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        String id = pref.getString("id","");
        String pw = pref.getString("pw","");

        if(!id.isEmpty())
            edtID.setText(id);
        if (!pw.isEmpty())
            edtPW.setText(pw);
    }
}
