package a13112033.integrador;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Usuario on 10/03/2017.
 */

public class Resumen extends Activity {

    TextView precio;
    TextView trufa;
    TextView msjG;
    Button pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent launch = getIntent();

        String precioTrufa = launch.getStringExtra("precioTrufa");
        String tipoTrufa = launch.getStringExtra("tipoTrufa");

        setContentView(R.layout.activity_resumen);
        trufa =(TextView) findViewById(R.id.trufas_tv);
        precio=(TextView) findViewById(R.id.price_tv);
        msjG=(TextView) findViewById(R.id.mensaje_btn);

        trufa.setText(tipoTrufa);
        precio.setText(precioTrufa);
        pay=(Button) findViewById(R.id.pagar);

        pay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        msjG.setText("Gracias por su compra");
                    }
                });
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu ) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_resumen, menu);
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
