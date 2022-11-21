package com.example.thbaikiemtra2_04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddRecyclerView1 extends AppCompatActivity {

    Button btn_add,btn_back;
    EditText name,name2,image,dactinh,maula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recycler_view1);

        btn_add=(Button) findViewById(R.id.btn_add);
        btn_back=(Button) findViewById(R.id.btn_back);

        name = findViewById(R.id.edt_name);
        name2 = findViewById(R.id.edt_name2);
        image = findViewById(R.id.edt_address_image);
        dactinh = findViewById(R.id.edt_dactinh);
        maula = findViewById(R.id.edt_maula);


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inserData();
                clearAll();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    private void inserData(){

        Map<String,Object> map = new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("name2",name2.getText().toString());
        map.put("image",image.getText().toString());
        map.put("dactinh",dactinh.getText().toString());
        map.put("maula",maula.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("cayxanh").push()
                .setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddRecyclerView1.this,"Successfully completed",Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddRecyclerView1.this,"Failure addition",Toast.LENGTH_SHORT).show();

                    }
                });
    }

    private  void clearAll(){
        name.setText("");
        name2.setText("");
        image.setText("");
        dactinh.setText("");
        maula.setText("");
    }
}