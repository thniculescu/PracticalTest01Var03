package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button but_add;
    Button but_sub;
    Button activity2;
    EditText nr1, nr2;
    TextView rez;

    boolean check_text_ok() {
        return nr1.getText().toString().matches("[0-9]+") &&
                nr2.getText().toString().matches("[0-9]+");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but_add = (Button) findViewById(R.id.add);
        but_sub = (Button) findViewById(R.id.sub);
        nr1 = (EditText) findViewById(R.id.text_input1);
        nr2 = (EditText) findViewById(R.id.text_input2);
        rez = (TextView) findViewById(R.id.rezultat);
        activity2 = (Button) findViewById(R.id.second_activity);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("nr1")) {
                nr1.setText(savedInstanceState.getString("nr1"));
            } else {
                nr1.setText("");
            }
            if (savedInstanceState.containsKey("nr2")) {
                nr2.setText(savedInstanceState.getString("nr2"));
            } else {
                nr2.setText("");
            }
        } else {
            nr1.setText(String.valueOf(0));
            nr2.setText(String.valueOf(0));
        }

        but_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check_text_ok()) {
                    int a = Integer.parseInt(nr1.getText().toString());
                    int b = Integer.parseInt(nr2.getText().toString());
                    String toshow = a + " + " + b + " = " + (a + b);
                    rez.setText(toshow);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "NOT NUMBERS",
                            Toast.LENGTH_LONG)
                            .show();
                }
            }
        });

        but_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check_text_ok()) {
                    int a = Integer.parseInt(nr1.getText().toString());
                    int b = Integer.parseInt(nr2.getText().toString());
                    String toshow = a + " - " + b + " = " + (a - b);
                    rez.setText(toshow);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "NOT NUMBERS",
                            Toast.LENGTH_LONG)
                            .show();
                }
            }
        });

        activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01SecondaryActivity.class);
                int a = Integer.parseInt(nr1.getText().toString());
                int b = Integer.parseInt(nr2.getText().toString());
                String toshow = rez.getText().toString();
                intent.putExtra("trop", toshow);
                startActivityForResult(intent, '2');
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("nr1", nr1.getText().toString());
        savedInstanceState.putString("nr2", nr2.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("nr1")) {
            nr1.setText(savedInstanceState.getString("nr1"));
        } else {
            nr1.setText("");
        }
        if (savedInstanceState.containsKey("nr2")) {
            nr2.setText(savedInstanceState.getString("nr2"));
        } else {
            nr2.setText("");
        }
        Toast.makeText(getApplicationContext(),
                "AM AJUNS IN RESTORE",
                Toast.LENGTH_LONG)
                .show();
    }
}