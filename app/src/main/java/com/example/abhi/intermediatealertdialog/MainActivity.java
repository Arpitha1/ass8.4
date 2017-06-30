package com.example.abhi.intermediatealertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.abhi.intermediatealertdialog.adapter.CustomListAdapter;
import com.example.abhi.intermediatealertdialog.model.Details;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    ListView list;
    CustomListAdapter adapter;
    List<Details> details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        details = new ArrayList<Details>();

        addData();

        list = (ListView) findViewById(R.id.listView);
        adapter = new CustomListAdapter(this, details);
        list.setAdapter(adapter);

    }

    private void addData() {
        // TODO Auto-generated method stub
        Details d1 = new Details("Arpitha", "+91-9448907664", "25/05/1997");
        Details d2 = new Details("Abhijith", "+91-993602342", "05/10/1992");
        details.add(d1);
        details.add(d2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub

        if(item.getItemId() == R.id.add){
            LayoutInflater inflater = LayoutInflater.from(this);

            View dialogView = inflater.inflate(R.layout.dialog, null);

            final AlertDialog alert =  new AlertDialog.Builder(this).create();

            final EditText name = (EditText) dialogView.findViewById(R.id.name);
            final EditText ph = (EditText) dialogView.findViewById(R.id.ph);
            final EditText dob = (EditText) dialogView.findViewById(R.id.dob);

            Button save = (Button) dialogView.findViewById(R.id.save);
            Button cancel = (Button) dialogView.findViewById(R.id.cancel);

            save.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {

                    String strName = name.getText().toString();
                    String strPh = ph.getText().toString();
                    String strDOB = dob.getText().toString();

                    Details d = new Details(strName, strPh, strDOB);
                    details.add(d);
                    adapter.notifyDataSetChanged();
                    alert.dismiss();
                }
            });

            cancel.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {

                    alert.cancel();
                }
            });

            alert.setTitle("Enter the Details");

            alert.setView(dialogView);

            alert.show();
        }

        return super.onOptionsItemSelected(item);
    }

}
