package mx.edu.tesoem.karr.gsontxt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtnombre, txtedad, txtcorreo,txtcurp;
    TextView lbljson;

    private final String nomarch="DatosKevinNash.txt";
    private ArrayList<String> TextoCompleto = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnombre = findViewById(R.id.Txtnombre);
        txtedad = findViewById(R.id.Txtedad);
        txtcorreo = findViewById(R.id.Txtcorreo);
        txtcurp = findViewById(R.id.Txtcurp);
        lbljson= findViewById(R.id.Lbljson);
    }
    public void convertirjson(View v){
        Datos datosobj = new Datos(txtnombre.getText().toString(),Integer.parseInt(txtedad.getText().toString()),txtcorreo.getText().toString(),txtcurp.getText().toString());
        Gson gson= new Gson();
        String cjson=gson.toJson(datosobj);
        lbljson.setText(cjson);
        Datos datosobj1 = gson.fromJson(cjson,Datos.class);
        Log.i(" Informacion JSON ---> " ," Nombre"+ datosobj1.getNombre()+ " ,Edad" + datosobj1.getEdad()+" ,Correo"+ datosobj1.getCorreo()+ " ,Curp" + datosobj1.getCurp());
}}
