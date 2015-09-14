package com.tom.bmi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);



    }

    public void bmi(View v){
        EditText edWeight = (EditText) findViewById(R.id.weight2);
        EditText edHeight = (EditText) findViewById(R.id.height2);
        String w = edWeight.getText().toString();
        String h = edHeight.getText().toString();
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight/(height*height);
        Toast.makeText(this, "您的BMI值為"+bmi, Toast.LENGTH_LONG).show();
//        alert1(bmi);
//        alert2(bmi);
        Intent intent = new Intent(this, ResultActivity.class);
        Bundle b = new Bundle();
        b.putFloat("BMI", bmi);
        intent.putExtras(b);

//        intent.putExtra("BMI", bmi);
        startActivity(intent);

    }

    private void alert2(float bmi) {
        new AlertDialog.Builder(this)
                .setTitle("BMI")
                .setMessage("您的BMI" + bmi)
                .setPositiveButton("OK", null)
                .show();
    }

    private void alert1(float bmi) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("BMI");
        builder.setMessage("您的BMI為"+bmi);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
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
