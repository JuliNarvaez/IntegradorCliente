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

public class PedirTradicional extends Activity implements Observer{

    Button milo, oreo, arequipe, maracuya,continuar;
    Mensaje msj;
    String valor;
    String precio;
    String trufa;
    Comunicacion com;
    Tarea nuevaTarea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedir_tradicional);
        valor = null;
        nuevaTarea= new Tarea();
        com=Comunicacion.getInstance();
        com.addObserver(this);

        milo =(Button) findViewById(R.id.oreo_btn);
        oreo =(Button) findViewById(R.id.milo_btn);
        arequipe =(Button) findViewById(R.id.arequipe_btn);
        maracuya =(Button) findViewById(R.id.maracuya_btn);

        continuar=(Button) findViewById(R.id.continuar_btn);

        milo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                msj = new Mensaje("Milo", "", "");
                trufa ="Milo";
                selectorBoton(0);

                nuevaTarea = new Tarea();
                nuevaTarea.execute(msj);
            }
        });

        oreo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                msj = new Mensaje("Oreo", "", "");
                trufa ="Oreo";
                selectorBoton(1);
                nuevaTarea = new Tarea();
                nuevaTarea.execute(msj);
            }
        });

        arequipe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                msj = new Mensaje("Arequipe", "", "");
                trufa ="Arequipe";
                selectorBoton(2);
                nuevaTarea = new Tarea();
                nuevaTarea.execute(msj);
            }
        });

        maracuya.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                msj = new Mensaje("Maracuya", "", "");
                trufa ="Maracuya";
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
        switch(btnSeleccion) {
            case 0:
                milo.setBackgroundColor(Color.GRAY);
                oreo.setBackgroundColor(Color.argb(100,128,128,128));
                arequipe.setBackgroundColor(Color.argb(100,128,128,128));
                maracuya.setBackgroundColor(Color.argb(100,128,128,128));
                break;
            case 1:
                milo.setBackgroundColor(Color.argb(100,128,128,128));
                oreo.setBackgroundColor(Color.GRAY);
                arequipe.setBackgroundColor(Color.argb(100,128,128,128));
                maracuya.setBackgroundColor(Color.argb(100,128,128,128));
                break;
            case 2:
                milo.setBackgroundColor(Color.argb(100,128,128,128));
                oreo.setBackgroundColor(Color.argb(100,128,128,128));
                arequipe.setBackgroundColor(Color.GRAY);
                maracuya.setBackgroundColor(Color.argb(100,128,128,128));
                break;
            case 3:
                milo.setBackgroundColor(Color.argb(100,128,128,128));
                oreo.setBackgroundColor(Color.argb(100,128,128,128));
                arequipe.setBackgroundColor(Color.argb(100,128,128,128));
                maracuya.setBackgroundColor(Color.GRAY);
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pedir_tradicional, menu);
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

        //String[] parts = ((Comunicacion)observable).getRespuesta().split(".");
        //valor=((Comunicacion)observable).getRespuesta();
        precio=((Comunicacion)observable).getRespuesta();
        //String[] partes=valor.split(",");
        // precio=partes[1];
        // System.out.println("imprime" + " " + partes[1]);

        System.out.println("trufa"+" "+precio);


    }

}
