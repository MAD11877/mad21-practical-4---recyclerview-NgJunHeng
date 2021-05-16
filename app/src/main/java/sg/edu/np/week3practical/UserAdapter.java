package sg.edu.np.week3practical;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    ArrayList<User> userList;
    Context context;

    public UserAdapter(Context cc, ArrayList<User> List) {
        context = cc;
        userList = List;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.userview,parent,false);

        View item = null;
        if(viewType == 0)
        {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.username7,parent,false);
        }
        else
        {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.userview,parent,false);
        }
        return new UserViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User u = userList.get(position);
        holder.name.setText(u.getName() );
        holder.description.setText(u.getDescription());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Profile");
                builder.setMessage(u.name);
                builder.setCancelable(false);
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context, MainActivity.class);
                        Bundle extras = new Bundle();
                        extras.putInt("id",position);
                        extras.putString("Name", u.getName());
                        extras.putString("Des", u.getDescription());
                        intent.putExtras(extras);
                        context.startActivity(intent);
                    }
                });

                //To show the alert dialog
                AlertDialog alert = builder.create();
                alert.show();

            }
        });



    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    @Override
    public int getItemViewType(int position) {
        String name = userList.get(position).getName();
        int id = Integer.parseInt(name.substring(name.length() - 1));
        if(id == 7)
        {
            return 0;
        }
        return 1;
    }

}
