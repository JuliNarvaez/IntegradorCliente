package a13112033.integrador;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import Comunicacion.Mensaje;

/**
 * Created by Usuario on 10/03/2017.
 */

public class Registro extends Activity{

    TextView nombre, contra, confiContra;
    Button enviarReg;
    Tarea nuevaTarea;
    Mensaje msj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        nombre = (TextView) findViewById(R.id.Txt_Nombre);
        contra = (TextView) findViewById(R.id.Txt_Contrasena);
        confiContra = (TextView) findViewById(R.id.Txt_ConfContrasena);

        enviarReg = (Button) findViewById(R.id.bt_EnviarRegist);

        enviarReg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (contra.getText().toString().equals(confiContra.getText().toString())) {
                    msj = new Mensaje("Registro", nombre.getText().toString(), contra.getText().toString());
                    nuevaTarea = new Tarea();
                    nuevaTarea.execute(msj);
                    Intent i = new Intent(getApplicationContext(), IntegradorCliente.class);
                    startActivity(i);
                }
            }
        });
    }

}
