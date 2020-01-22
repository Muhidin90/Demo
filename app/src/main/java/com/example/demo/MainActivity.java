package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        btnSignUp.setOnClickListener(new View.onclickListner(){
public void onclick(View v) {
    string email = emailId.getText().toString();
    string pwd = password.getText().toString();
    if (email.isEmpty()) {
         emailId.setError("Please anter email id ");
         emailId.requestFocus();
}
    else if (pwd.isEmpty()){
        password.setError("Please enter your password");
        password.requestFocus();

 else if (email.isEmpty() && pwd.isEmpty()){
            Toast.makeText(MainActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
}
else if (!email.isEmpty() && pwd.isEmpyty())){
    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd) .addOnCompleteListener(MainActivity.this, new on)
@override
    public void oncomplete(@NonNull Task<AuthResult> task) {
        if (!task.isSuccessfell()){
            Toast.makeText(MainActivity.this, " signUp unsuccessfyl please try again ", Toast.LENGTH_SHORT).show();
            else {
               startActivity(new intent ( packageContext: MainActivity.this,HomeActivity.class));
            }
            }
        }