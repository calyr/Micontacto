package com.coursera.app.pm.micontacto;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText birthdate;
    private EditText email;
    private EditText description;
    private EditText phone;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.name = (EditText) findViewById(R.id.form_name);
        this.birthdate = (EditText) findViewById(R.id.form_birthdate);
        this.email = (EditText) findViewById(R.id.form_email);
        this.description = (EditText) findViewById(R.id.form_description);
        this.phone = (EditText) findViewById(R.id.form_phone);



        Intent intent = this.getIntent();
        Bundle parametros = intent.getExtras();


        if(parametros !=  null){
            this.name.setText( parametros.get("formName").toString());
            this.birthdate.setText( parametros.get("formBirthDate").toString());
            this.email.setText( parametros.get("formEmail").toString());
            this.phone.setText( parametros.get("formPhone").toString());
            this.description.setText(parametros.get("formDescription").toString());

        }




    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this,"requestCode"+requestCode,Toast.LENGTH_LONG).show();
        Toast.makeText(this,"resultCode"+resultCode,Toast.LENGTH_LONG).show();


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

    public void confirmarDatos(View view) {

        Intent intent = new Intent(this,DetalleContactoActivity.class);
        intent.putExtra("formName", this.name.getText() );
        intent.putExtra("formBirthdate", this.birthdate.getText() );
        intent.putExtra("formEmail", this.email.getText() );
        intent.putExtra("formPhone", this.phone.getText() );
        intent.putExtra("formDescription", this.description.getText());
        startActivity(intent);
        finish();
    }

    public void showDate(View view) {
        DialogFragment newFragment = new DatePickerFragment(){

            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {

                birthdate.setText(day+"/"+month+"/"+year);
                phone.requestFocus();

            }
        };

        newFragment.show(getSupportFragmentManager(), "datePicker");


    }
}
