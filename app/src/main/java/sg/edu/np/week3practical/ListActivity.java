package sg.edu.np.week3practical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private final static String TAG = "Main Activity";
    private TextView message;

    static ArrayList<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);



        for (int i = 0; i < 20; i++)
        {
            User user = new User();
            Random rand = new Random();
            String text = String.valueOf(rand.nextInt());
            user.setName("Name" + text);
            user.setDescription("Description" + text);
            userList.add(user);
        }

        RecyclerView rv = findViewById(R.id.rv);
        UserAdapter adapter = new UserAdapter(this, userList);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);

//        ImageView img1 = findViewById(R.id.imageView2);
//        img1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.v(TAG, "Image Pressed!");
//                userPressed();
//
//            }



        //});
    }

    //Generating random number
    private void randomNumber()
    {
        Random ran = new Random();
        int ranNum= ran.nextInt();


        Intent intent = new Intent(ListActivity.this, MainActivity.class);
        intent.putExtra("Number", ranNum);
        startActivity(intent);
    }



    private void userPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("MADness");
        builder.setTitle("Profile");
        builder.setCancelable(false);
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                randomNumber();

            }
        });

        //To show the alert dialog
        AlertDialog alert = builder.create();
        alert.show();

    }

    private void viewOutput (){


    }
}