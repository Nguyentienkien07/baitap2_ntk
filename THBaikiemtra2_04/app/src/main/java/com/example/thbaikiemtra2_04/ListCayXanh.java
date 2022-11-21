package com.example.thbaikiemtra2_04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class ListCayXanh extends AppCompatActivity {

    RecyclerView recyclerView;
    TreeAdapter treeAdapter;

    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cay_xanh);



        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<TreeModel> options =
                new FirebaseRecyclerOptions.Builder<TreeModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("cayxanh"),TreeModel.class)
                        .build();

        treeAdapter = new TreeAdapter(options);
        recyclerView.setAdapter(treeAdapter);

        floatingActionButton=(FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(),AddRecyclerView1.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        treeAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        treeAdapter.startListening();
    }
}