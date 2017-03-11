package a13112033.integrador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Observable;
import java.util.Observer;

import Comunicacion.Comunicacion;
import Comunicacion.Mensaje;

public class IntegradorCliente extends AppCompatActivity implements Observer {

    Button registrar, ingresar;
    TextView nombre, contra, feedB;
    Tarea nuevaTarea;
    Mensaje msj;
    Comunicacion com;

    @Override
    protected void onResume() {
        Comunicacion.getInstance().addObserver(this);
        super.onResume();
    }

    @Override
    protected void onPause() {
        Comunicacion.getInstance().deleteObserver(this);
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integrador_cliente);

        nuevaTarea = new Tarea();
        com = Comunicacion.getInstance();
        com.addObserver(this);
        nombre = (TextView) findViewById(R.id.Txt_NombreUsuario);
        contra = (TextView) findViewById(R.id.Txt_Contra);
        feedB = (TextView) findViewById(R.id.feedBackUser);

        registrar = (Button) findViewById(R.id.bt_Registrar);
        ingresar = (Button) findViewById(R.id.bt_Ingresar);

        registrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Registro.class);
                startActivity(intent);
            }
        });

        ingresar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                msj = new Mensaje("Ingreso", nombre.getText().toString(), contra.getText().toString());
                nuevaTarea = new Tarea();
                nuevaTarea.execute(msj);
                //  validar=true;
            }
        });
    }

    @Override
    public void update(Observable observable, Object data) {
        if (((Comunicacion) observable).getIngresar()) {
            // if(validar) {
            System.out.println("Entro");
            Intent i = new Intent(getApplicationContext(), TipoTrufa.class);
            startActivity(i);
            // }

        } else {
            // linea para hacer el feedback cuando hay error de contraseña o usuario al ingresar
            // feedB.setText("El usuario o contraseña es invalido");


            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    feedB.setText("El usuario o contraseña es invalido");
                }
            });
        }
    }
}
