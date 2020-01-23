package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.ui.login.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
 EditText emailId, password;
 Button btnSignUp;
 TextView tvSignIn;
 FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        btnSignUp = findViewById(R.id.button2);
        tvSignIn =  findViewById(R.id.textView);
        btnSignUp.setOnClickListener(new View.onclickListner() {
            public void onclick(View v) {
                string email = emailId.getText().toString();
                //this is test comment
                string pwd = password.getText().toString();
                if (email.isEmpty()) {
                    emailId.setError("Please anter email id ");
                    emailId.requestFocus();
                } else if (pwd.isEmpty()) {
                    password.setError("Please enter your password");
                    password.requestFocus();
                } else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                } else if ((!email.isEmpty() && pwd.isEmpyty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Signup unsuccesssful, please try Again ", Toast.LENGTH_SHORT).show();

                            } else {
                                startActivity(new Intent(packageContext:
                                MainActivity.this, HomeActivity.class));
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(MainActivity.this, "Errror occured!", Toast.LENGTH_SHORT).show();

                }
            }


        });
        tvSignIn.setOnContextClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v) {
                intent i  = new Intent (createPackageContext:MainActivity.this, LoginActivity.class);
                startActivities(i);
            }
        });


    }
}



