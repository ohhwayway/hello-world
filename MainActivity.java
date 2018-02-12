package com.example.cs16jkd.atry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Button clickedbutton;//button
    private DatabaseReference mDatabase;//add data to database
    private EditText mNameField;//for text box
    private EditText mdescriptionfield;
    private EditText mvaluefield;
    private EditText mqualityfield;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickedbutton= (Button) findViewById(R.id.button1);//button

        mDatabase = FirebaseDatabase.getInstance().getReference().child("User_1");// database
        mNameField = (EditText) findViewById(R.id.name_field);//text box
        mdescriptionfield = (EditText) findViewById((R.id.description_field));
        mvaluefield = (EditText) findViewById(R.id.value_field);
        mqualityfield = (EditText) findViewById(R.id.quality_field);

        clickedbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //1 - create child on root object
                //2- assign value to the chold object
                String name = mNameField.getText().toString().trim();//changes text box into name(string)
                String description = mdescriptionfield.getText().toString().trim();
                String value = mqualityfield.getText().toString().trim();
                String quality = mqualityfield.getText().toString().trim();

                mDatabase.child("Name").setValue(name);//uses value of name
                mDatabase.child("Description").setValue(description);
                mDatabase.child("Value").setValue(value);
                mDatabase.child("Quality").setValue(quality);

            }
        });





    }
}
