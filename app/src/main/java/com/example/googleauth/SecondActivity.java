package com.example.googleauth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SecondActivity extends AppCompatActivity {
    Button signOutBtn;
    TextView name, email;
    private FirebaseAuth mAuth =  FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        signOutBtn = findViewById(R.id.signOutBtn);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);

        FirebaseUser user =  FirebaseAuth.getInstance().getCurrentUser();
        if (mAuth.getCurrentUser() != null) {
            String personName = user.getDisplayName();
            String personEmail = user.getEmail();
            name.setText(personName);
            email.setText(personEmail);
        }

        signOutBtn.setOnClickListener(view -> signOut());
    }

    void signOut() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(SecondActivity.this, MainActivity.class));
    }
}