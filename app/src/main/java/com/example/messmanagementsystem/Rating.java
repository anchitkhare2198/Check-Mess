package com.example.messmanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Rating extends AppCompatActivity {

    RatingBar ratingBar;
    EditText et;
    Button submit;
    DatabaseReference DatabaseRating;
    FirebaseAuth firebaseAuth;
    String s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseRating = firebaseDatabase.getReference(firebaseAuth.getUid()+"Rating");

        ratingBar = (RatingBar) findViewById(R.id.ratingbar);
        et = (EditText) findViewById(R.id.review);
        submit = (Button) findViewById(R.id.btnreviesubmit);

        ratingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating = "Rating is : " + ratingBar.getRating();
                Toast.makeText(getApplicationContext(),rating,Toast.LENGTH_SHORT).show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                s1 = et.getText().toString().trim();

                if(s1.equals(""))
                {
                    Toast.makeText(getApplicationContext(), " Field is Empty ", Toast.LENGTH_SHORT).show();
                }

                else {
                    RatingType rating = new RatingType(s1);
                    DatabaseRating.setValue(rating);
                    Toast.makeText(getApplicationContext(), "Submitted", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
