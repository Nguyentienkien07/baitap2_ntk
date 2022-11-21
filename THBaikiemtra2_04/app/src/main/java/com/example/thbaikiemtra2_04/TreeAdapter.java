package com.example.thbaikiemtra2_04;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class TreeAdapter extends FirebaseRecyclerAdapter<TreeModel,TreeAdapter.myViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public TreeAdapter(@NonNull FirebaseRecyclerOptions<TreeModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") int position, @NonNull TreeModel model) {
        holder.name.setText(model.getName());
        holder.name2.setText(model.getName2());
        holder.dactinh.setText(model.getDactinh());
        holder.maula.setText(model.getMaula());
        Glide.with(holder.image.getContext())
                .load(model.getImage())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.image);



        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.name.getContext());
                builder.setTitle("Remove");
                builder.setMessage("Deleted Data can't be recovered!");
                // xoa
                builder.setPositiveButton("Delete ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("cayxanh")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.name.getContext(),"Removed was not done",Toast.LENGTH_SHORT).show();

                    }
                });
                builder.show();
            }
        });
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cay,parent,false);

        return new myViewHolder(view) ;
    }

    class  myViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView name,name2,dactinh,maula;
        ImageView remove;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            image = (CircleImageView)itemView.findViewById(R.id.img1);
            name =(TextView)itemView.findViewById(R.id.nametext);
            name2 =(TextView)itemView.findViewById(R.id.name2);
            dactinh =(TextView)itemView.findViewById(R.id.dactinh);
            maula =(TextView)itemView.findViewById(R.id.maula);
            remove=itemView.findViewById(R.id.imgdelete);
        }
    }
}

