package com.example.practiceapp;

import android.content.Intent;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textInputEmail;
    private TextInputLayout textInputUsername;
    private TextInputLayout textInputPassword;
    private TextView txtv;
    private    String strng="Create New Account";
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtv =findViewById(R.id.textView);
        txtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),strng,Toast.LENGTH_LONG).show();

                Intent it =new Intent(MainActivity.this,CreateAccount.class);
                startActivity(it);
            }
        });

        textInputEmail = findViewById(R.id.text_input_email);
        textInputUsername = findViewById(R.id.text_input_username);
        textInputPassword = findViewById(R.id.text_input_password);

        firebaseAuth = FirebaseAuth.getInstance();
    }



    public void confirmInput(View v){

        String emailInput= textInputEmail.getEditText().getText().toString().trim();
        String usernameInput= textInputUsername.getEditText().getText().toString().trim();
        String passwordInput= textInputPassword.getEditText().getText().toString().trim();


        if (TextUtils.isEmpty(emailInput)){
            textInputEmail.setError("Field cant be Empty");
            return;
        }

        if (TextUtils.isEmpty(usernameInput)){
            textInputUsername.setError("Field cant be Empty");
            return;
        }else if (usernameInput.length()>20){
            textInputUsername.setError("UserName Too Long");
            return;
        }

        if (TextUtils.isEmpty(passwordInput)){
            textInputPassword.setError("Field cant be Empty");
            return;
        }else if (passwordInput.length()<6){
            textInputPassword.setError("Enter minimum 6 character");
            return;

        }

        firebaseAuth.signInWithEmailAndPassword(emailInput, passwordInput)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            startActivity(new Intent(MainActivity.this, HomePage.class));
                            Toast.makeText(MainActivity.this,"Sing Up Successfully",Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this,"User not valid",Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });

    }



}
