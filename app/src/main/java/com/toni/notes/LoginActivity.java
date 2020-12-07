package com.toni.notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.toni.notes.notes.NotesActivity;
import com.toni.notes.utils.Constants;

public class LoginActivity extends BaseActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText etUserName = findViewById(R.id.etUserName);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btLogin = findViewById(R.id.btLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUserName.getText().toString();
                String password = etPassword.getText().toString();

                if (username.equals("toni") && password.equals("1234"))
                {
                    prefs.setPrefs(Constants.USER_LOGGED, true);
                    Intent intent = new Intent(LoginActivity.this, NotesActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "credenciales inválidas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
