package sg.edu.np.week3practical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "Main Activity";
    private TextView txtName;
    private TextView txtDescription;


    //User user1 = new User("Ng","HEHE",1,false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // int id = getIntent().getIntExtra("id",0);

        Log.v(TAG,"Create");

        //TextView tv1 = findViewById(R.id.txtName);
        Button button = findViewById(R.id.btnFollow);

        this.txtName = findViewById(R.id.txtName);
        this.txtDescription = findViewById(R.id.txtDescription);

        Intent receivedData = getIntent();
        User user = new User(receivedData.getStringExtra("Name"), receivedData.getStringExtra("Des"),0,false);
        this.txtName.setText(user.getName());
        this.txtDescription.setText(user.getDescription());

//        int myNum =receivedData.getIntExtra("Number" ,0);
//        tv1.setText("MAD " + myNum);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(user.isFollowed() == true)
                {
                    button.setText("Follow");
                    user.setFollowed(false);
                    Toast.makeText(getApplicationContext(),"Unfollowed",Toast.LENGTH_SHORT).show();
                    
                }
                else
                {
                    button.setText("Unfollow");
                    Toast.makeText(getApplicationContext(),"Followed",Toast.LENGTH_SHORT).show();
                    user.setFollowed(true);
                }
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TAG,"Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG,"Resume");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.v(TAG,"Pause");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.v(TAG,"Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"Destroy");
    }
}
