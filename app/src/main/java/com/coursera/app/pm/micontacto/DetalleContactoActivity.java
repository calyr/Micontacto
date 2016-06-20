package com.coursera.app.pm.micontacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.*;

public class DetalleContactoActivity extends AppCompatActivity {

    private TextView name;
    private TextView email;
    private TextView phone;
    private TextView description;
    private TextView birthdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        this.name = (TextView) findViewById(R.id.showFormName);
        this.email = (TextView) findViewById(R.id.showFormEmail);
        this.phone = (TextView) findViewById(R.id.showFormPhone);
        this.description = (TextView) findViewById(R.id.showFormDescription);
        this.birthdate = (TextView) findViewById(R.id.showFormBirthdate);

        Bundle parametros = getIntent().getExtras();

        this.name.setText( parametros.get("formName").toString());
        this.email.setText( parametros.get("formEmail").toString());
        this.phone.setText( parametros.get("formPhone").toString());
        this.description.setText( parametros.get("formDescription").toString());
        this.birthdate.setText( parametros.get("formBirthdate").toString());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalle_contacto, menu);
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

    public void editForm(View view) {

        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("formName", this.name.getText() );
        intent.putExtra("formBirthDate", this.birthdate.getText() );
        intent.putExtra("formEmail", this.email.getText() );
        intent.putExtra("formPhone", this.phone.getText() );
        intent.putExtra("formDescription", this.description.getText());
        startActivityForResult(intent, 1);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){

            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("formName", this.name.getText() );
            intent.putExtra("formBirthDate", this.birthdate.getText() );
            intent.putExtra("formEmail", this.email.getText() );
            intent.putExtra("formPhone", this.phone.getText() );
            intent.putExtra("formDescription", this.description.getText());
            startActivityForResult(intent,1);
            finish();

        }
        return super.onKeyDown(keyCode, event);
    }
}
