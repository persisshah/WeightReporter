package com.example.persis.weightreporter;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.System.exit;

public class MainActivity extends AppCompatActivity {
    EditText etUsername, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername= (EditText)findViewById(R.id.etUsername);
        etPassword= (EditText)findViewById(R.id.etPassword);
        btnLogin= (Button)findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String un = etUsername.getText().toString();
                String pw = etPassword.getText().toString();

                if(un.length() == 0)
                {
                   etUsername.setError("username is empty");
                    etUsername.requestFocus();
                    return;

                }

                if(pw.length() == 0)
                {
                    etPassword.setError("Password is empty");
                    etPassword.requestFocus();
                    return;
                }

                if( (un.equals("Persis")) && (pw.equals("Dogo")) )
                {
                    Intent i = new Intent(MainActivity.this, WeightActivity.class);
                    i.putExtra("un",un);
                    i.putExtra("pw",pw);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                    etPassword.setText("");
                    etPassword.requestFocus();

                }


            }
        });
    }
    @Override
    public  void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to close the application");
        builder.setCancelable(false);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alert = builder.create();
        alert.setTitle("Exit");
        alert.show();
    }
}
