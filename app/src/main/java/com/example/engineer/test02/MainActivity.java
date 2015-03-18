package com.example.engineer.test02;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.view.menu.MenuItemWrapperICS;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
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

        View.OnClickListener btnCalcLsn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcResult();
            }
        };

        calcBtn.setOnClickListener(btnCalcLsn);

    }

    public void calcPopup(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.popup_calc, popupMenu.getMenu());

        PopupMenu.OnMenuItemClickListener clcLsn = new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick (MenuItem item) {
                if(item.getItemId() == R.id.popup_calc) {
                    calcResult();
                }
                return false;
            }
        };

        popupMenu.setOnMenuItemClickListener(clcLsn);

        popupMenu.show();
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

        if (id == R.id.action_clear) {
            history.clear();
            outHistory();
        }

        return super.onOptionsItemSelected(item);
    }
}
