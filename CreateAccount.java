package com.example.practiceapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity {

    private TextInputLayout textInputPassword;
    private TextInputLayout textInputConfirmPassword;
    private TextInputLayout textInputMail;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();

        textInputPassword=findViewById(R.id.text_password);
        textInputConfirmPassword=findViewById(R.id.text_confirm_password);
        textInputMail=findViewById(R.id.text_email);



    }


    public void buttonInput(View view){

        String email = textInputMail.getEditText().getText().toString().trim();
        String password= textInputPassword.getEditText().getText().toString().trim();
        String confirmPassword=textInputConfirmPassword.getEditText().getText().toString().trim();



        if (TextUtils.isEmpty(email)){
            textInputMail.setError("Field cant be empty");
            return;
        }

        if (TextUtils.isEmpty(password)){
            textInputPassword.setError("Field cant be empty");
            return;
        }else if (password.length()<6){
            textInputPassword.setError("Enter minimum 6 character");
            return;

        }

        if (TextUtils.isEmpty(confirmPassword)){
            textInputConfirmPassword.setError("Field cant be empty");
            return;
        }else if (confirmPassword.length()<6){
            textInputConfirmPassword.setError("Enter minimum 6 character");
            return;

        }

        if (password.equals(confirmPassword)){

            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                startActivity(new Intent(CreateAccount.this,MainActivity.class));
                                Toast.makeText(CreateAccount.this,"Created successfully",Toast.LENGTH_SHORT).show();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(CreateAccount.this,"Registration Failed",Toast.LENGTH_SHORT).show();

                            }

                            // ...
                        }
                    });




        }
    }


}
