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
    private TextView textWelcome;
    private TextView regis;
    private TextView help;
    private LinearLayout enter;

    Toast toasTrue = Toast.makeText(getApplicationContext(),
            "Вы успешно зарегистрировались!", Toast.LENGTH_SHORT);

    Toast toastFalse = Toast.makeText(getApplicationContext(),
            "Ошибка!", Toast.LENGTH_SHORT);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.edit_text_email);
        editTextPassword = findViewById(R.id.edit_text_password);
        btnEnter = findViewById(R.id.btn_enter);
        textLogo = findViewById(R.id.text_logo);
        textWelcome = findViewById(R.id.text_welcome);
        regis = findViewById(R.id.regis);
        help = findViewById(R.id.help);
        enter = findViewById(R.id.enter);

        editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String emailInput = editTextEmail.getText().toString().trim();
                String passwordInput = editTextPassword.getText().toString().trim();

                if(editTextEmail.length()>0 || editTextPassword.length()>0) {
                    btnEnter.setBackgroundColor(getResources().getColor(R.color.orange));

                    btnEnter.setOnClickListener(new View.OnClickListener() {


                        @Override
                        public void onClick(View view) {
                            if (editTextEmail.equals("admin") || editTextPassword.equals("admin")) {
                                toasTrue.show();
                                textLogo.animate().alpha(0);
                                textWelcome.animate().alpha(0);
                                regis.animate().alpha(0);
                                help.animate().alpha(0);
                                enter.animate().alpha(0);

                            } else {
                                toasTrue.show();
                            }
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