package a13112033.integrador;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Observable;
import java.util.Observer;

import Comunicacion.Comunicacion;
import Comunicacion.Mensaje;

/**
 * Created by Usuario on 10/03/2017.
 */

public class PedirDietetico extends Activity implements Observer {

    Button miloLight, oreoLight, arequipeLight, maracuyaLight, continuar;
    Mensaje msj;
    String valor;
    String precio;
    String trufa;
    Comunicacion com;
    Tarea nuevaTarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedir_dietetico);
        valor = null;
        nuevaTarea = new Tarea();
        com = Comunicacion.getInstance();
        com.addObserver(this);

        miloLight = (Button) findViewById(R.id.miloLight_btn);
        oreoLight = (Button) findViewById(R.id.oreoLight_btn);
        arequipeLight = (Button) findViewById(R.id.arequipeLight_btn);
        maracuyaLight = (Button) findViewById(R.id.maracuyaLight_btn);

        continuar = (Button) findViewById(R.id.continuar_btn);

        miloLight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                msj = new Mensaje("MiloLight", "", "");
                trufa = "Milo Light";
                selectorBoton(0);
                nuevaTarea = new Tarea();
                nuevaTarea.execute(msj);
            }
        });

        oreoLight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                msj = new Mensaje("OreoLight", "", "");
                trufa = "Oreo Light";
                selectorBoton(1);
                nuevaTarea = new Tarea();
                nuevaTarea.execute(msj);
            }
        });

        arequipeLight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                msj = new Mensaje("ArequipeLight", "", "");
                trufa = "Arequipe Light";
                selectorBoton(2);
                nuevaTarea = new Tarea();
                nuevaTarea.execute(msj);
            }
        });

        maracuyaLight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                msj = new Mensaje("MaracuyaLight", "", "");
                trufa = "Maracuya Light";
                selectorBoton(3);
                nuevaTarea = new Tarea();
                nuevaTarea.execute(msj);
            }
        });

        continuar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                Intent i = new Intent(getApplicationContext(), Resumen.class);
                i.putExtra("precio trufa", precio);
                i.putExtra("tipo trufa", trufa);
                startActivity(i);


            }
        });

    }

    private void selectorBoton(int btnSeleccion) {
        switch (btnSeleccion) {
            case 0:
                miloLight.setBackgroundColor(Color.GRAY);
                oreoLight.setBackgroundColor(Color.argb(100, 128, 128, 128));
                arequipeLight.setBackgroundColor(Color.argb(100, 128, 128, 128));
                maracuyaLight.setBackgroundColor(Color.argb(100, 128, 128, 128));
                break;
            case 1:
                miloLight.setBackgroundColor(Color.argb(100, 128, 128, 128));
                oreoLight.setBackgroundColor(Color.GRAY);
                arequipeLight.setBackgroundColor(Color.argb(100, 128, 128, 128));
                maracuyaLight.setBackgroundColor(Color.argb(100, 128, 128, 128));
                break;
            case 2:
                miloLight.setBackgroundColor(Color.argb(100, 128, 128, 128));
                oreoLight.setBackgroundColor(Color.argb(100, 128, 128, 128));
                arequipeLight.setBackgroundColor(Color.GRAY);
                maracuyaLight.setBackgroundColor(Color.argb(100, 128, 128, 128));
                break;
            case 3:
                miloLight.setBackgroundColor(Color.argb(100, 128, 128, 128));
                oreoLight.setBackgroundColor(Color.argb(100, 128, 128, 128));
                arequipeLight.setBackgroundColor(Color.argb(100, 128, 128, 128));
                maracuyaLight.setBackgroundColor(Color.GRAY);
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pedir_dietetico, menu);
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

        precio = ((Comunicacion) observable).getRespuesta();
        System.out.println("trufa" + " " + precio);


    }
}

