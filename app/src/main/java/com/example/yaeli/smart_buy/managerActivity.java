package com.example.yaeli.smart_buy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class managerActivity extends AppCompatActivity implements View.OnClickListener {

    TextView msg;
    Button products;
    Button recipes;
    Button users;
    String email;
    String userName;
    DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        msg=(TextView) findViewById(R.id.msg);
        products=(Button) findViewById(R.id.products);
        recipes=(Button) findViewById(R.id.recipe);
        //msg.setText("Hello manager "+getIntent().getExtras().getString("userName"));

        products.setOnClickListener(this);
        recipes.setOnClickListener(this);
        msg.setOnClickListener(this);


        email=getIntent().getExtras().get("Email").toString();
        mDatabase= FirebaseDatabase.getInstance().getReference();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
<<<<<<< HEAD
                for(DataSnapshot d:dataSnapshot.child("users").getChildren()){

                    if(d.child("Email").getValue().toString().equals(email)){
                        userName=d.child("userName").getValue().toString();
                        msg.setText("Hello Manager "+userName);
=======
                for(DataSnapshot d:dataSnapshot.child("admin").getChildren()){

                    if(d.child("Email").getValue().toString().equals(email)){
                        msg.setText("Hello Manager "+d.getKey());
                        userName=d.getKey();
>>>>>>> ecd261c4e308c2f460db46a6c464c06ced5b33fd
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case(R.id.products):
                Intent intent=new Intent("com.example.yaeli.smart_buy.inStockProductsActivity");
                startActivity(intent);
                break;

            case(R.id.recipe):
                Intent intent1=new Intent("com.example.yaeli.smart_buy.addRecipeActivity");
                startActivity(intent1);
                break;

            case(R.id.msg):
                Intent intent2=new Intent("com.example.yaeli.smart_buy.myAccount");
<<<<<<< HEAD
                intent2.putExtra("Email",email);
=======
                intent2.putExtra("userName",userName);
>>>>>>> ecd261c4e308c2f460db46a6c464c06ced5b33fd
                startActivity(intent2);



        }


    }
}
