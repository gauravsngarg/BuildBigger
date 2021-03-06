package example.com.buildbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.Joker;

import example.com.androidlibrary.MainLibraryActivity;
import example.com.buildbigger.cloud.ServletPostAsyncTask;

public class MainActivity extends AppCompatActivity {

    Button btShowJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btShowJoke = (Button) findViewById(R.id.btnShowJoke);

        final Joker joker = new Joker();
        btShowJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, joker.getJoke(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainLibraryActivity.class);
                intent.putExtra("joke", joker.getJoke());
                startActivity(intent);
            }
        });


        new ServletPostAsyncTask().execute(MainActivity.this);
    }

}
