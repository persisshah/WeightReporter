package com.example.persis.weightreporter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.System.exit;
import static java.security.AccessController.getContext;

public class FinalActivity extends AppCompatActivity {

    TextView tvInfo;
    Button btnSignOut;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        tvInfo= (TextView)findViewById(R.id.tvInfo);
        btnSignOut = (Button)findViewById(R.id.btnSignOut);

        Intent i = getIntent();
        String un = i.getStringExtra("un");
        String wt = i.getStringExtra("wt");

        tvInfo.setText(un + "\nWeight "+wt);

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);


            }
        });

    }

}
