package com.example.engineer.test02;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private Button calcBtn;

    private ArrayList<String> history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcBtn = (Button) findViewById(R.id.calc_btn);

        history = new ArrayList<>();


        //View.OnClickListener btnCalcLsn = ;

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcResult();
            }
        });

    }


    public void calcResult()
    {
        EditText input_a = (EditText) findViewById(R.id.input_a);
        EditText input_b = (EditText) findViewById(R.id.input_b);
        TextView result_a_b;
        result_a_b = (TextView) findViewById(R.id.result_a_b);

        String a = input_a.getText().toString();
        String b = input_b.getText().toString();

        Integer result = Integer.parseInt(a) + Integer.parseInt(b);

        result_a_b.setText(result.toString());

        history.add(a+"+"+b+"="+result.toString());
        outHistory();
    }

    public void outHistory()
    {
        TextView history_text = (TextView) findViewById(R.id.history_text);

        String hist="";

        for (int i=history.size()-1; i>=0;i--)
        {
            hist+=history.get(i)+"\n";
        }

        history_text.setText(hist);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
