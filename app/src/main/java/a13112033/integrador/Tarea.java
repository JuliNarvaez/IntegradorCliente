package a13112033.integrador;

import android.os.AsyncTask;

import Comunicacion.Comunicacion;

/**
 * Created by Usuario on 09/03/2017.
 */

public class Tarea extends AsyncTask<Object, Integer, Object>{

    private Comunicacion com;

    Tarea () {
        com = Comunicacion.getInstance();
    }

    @Override
    protected Object doInBackground(Object... objects) {
        com.getInstance().enviar(objects[0]);
        return null;
    }
}
