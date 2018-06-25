package com.example.persis.weightreporter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WeightActivity extends AppCompatActivity {

    TextView tvName;
    EditText etWeight;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        tvName = (TextView)findViewById(R.id.tvName);
        etWeight = (EditText) findViewById(R.id.etWeight);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);

        Intent i = getIntent();
        final String un=i.getStringExtra("un");
        tvName.setText("Welcome "+un);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wt = etWeight.getText().toString();

                if(wt.length()==0)
                {
                    etWeight.setError("Weight is empty");
                    etWeight.requestFocus();
                    return;
                }

                Intent i = new Intent(WeightActivity.this, FinalActivity.class);
                i.putExtra("wt",wt);
                i.putExtra("un",un);
                startActivity(i);


            }
        });
    }
}
