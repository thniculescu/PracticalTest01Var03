package ro.pub.cs.systems.eim.practicaltest01var03;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PracticalTest01SecondaryActivity extends AppCompatActivity {

    TextView rez;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        rez = (TextView) findViewById(R.id.rezultatact2);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("trop")) {
            String altrez = intent.getStringExtra("trop");
            rez.setText(altrez);
        }
    }
}
