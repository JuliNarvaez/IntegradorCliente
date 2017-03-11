package a13112033.integrador;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

import Comunicacion.Comunicacion;
import Comunicacion.Mensaje;

/**
 * Created by Usuario on 10/03/2017.
 */

public class TipoTrufa extends Activity implements Observer {

    private Button tradicional, dietetico;
    private TextView saludo;
    Tarea nuevaTarea;
    Mensaje msj;
    Comunicacion com;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_trufa);
        nuevaTarea= new Tarea();
        com=Comunicacion.getInstance();
        com.addObserver(this);

        saludo = (TextView) findViewById(R.id.saludo_tv);
        tradicional=(Button) findViewById(R.id.trufa_tradi_btn);
        dietetico=(Button) findViewById(R.id.trufa_diete_btn);

        tradicional.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PedirTradicional.class);
                startActivity(intent);
            }
        });

        dietetico.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PedirDietetico.class);
                startActivity(i);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tipo_trufa, menu);
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

    @Override
    public void update(Observable observable, Object data) {

    }
}
