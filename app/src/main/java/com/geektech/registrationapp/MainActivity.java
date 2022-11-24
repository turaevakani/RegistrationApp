package com.geektech.registrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private EditText editTextEmail;
    private EditText editTextPassword;
    private MaterialButton btnEnter;
    private TextView textLogo;
    private TextView regis;
    private TextView help;
    private LinearLayout enter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.edit_text_email);
        editTextPassword = findViewById(R.id.edit_text_password);
        btnEnter = findViewById(R.id.btn_enter);
        textLogo = findViewById(R.id.text_logo);
        regis = findViewById(R.id.regis);
        help = findViewById(R.id.help);
        enter = findViewById(R.id.enter);

        Toast toastTrue = Toast.makeText(getApplicationContext(),
                "Вы успешно зарегистрировались!", Toast.LENGTH_SHORT);

        Toast toastFalse = Toast.makeText(getApplicationContext(),
                "Ошибка!", Toast.LENGTH_SHORT);

        editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String edit_text_email = editTextEmail.getText().toString().trim();
                String edit_text_password = editTextPassword.getText().toString().trim();

                if(editTextEmail.length()>0 || editTextPassword.length()>0) {
                    btnEnter.setBackgroundColor(getResources().getColor(R.color.orange));

                    btnEnter.setOnClickListener(view -> {
                        if (edit_text_email.equals("admin") || edit_text_password.equals("admin")) {
                            toastTrue.show();
                            textLogo.animate().alpha(0);
                            regis.animate().alpha(0);
                            help.animate().alpha(0);
                            enter.animate().alpha(0);

                        } else {
                            toastFalse.show();
                        }
                    });
                }else{
                    btnEnter.setBackgroundColor(getResources().getColor(R.color.grey));
                }


            }
        });
                getWindow().setFlags(
                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,  //action bar
                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                );
    }
}