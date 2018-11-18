package example.com.androidlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainLibraryActivity extends AppCompatActivity {

    private TextView tv_joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_library);

        tv_joke = (TextView) findViewById(R.id.tv_joke);

        String joke = getIntent().getExtras().getString("joke");
        tv_joke.setText(joke);
    }
}
