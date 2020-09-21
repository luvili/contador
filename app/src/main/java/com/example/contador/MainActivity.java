package com.example.contador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int contador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador=0;
        mostrarContador();
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences  datos= (SharedPreferences) PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor miEditor= datos.edit();
        miEditor.putInt("valor",contador);
        miEditor.apply();

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences datos= (SharedPreferences) PreferenceManager.getDefaultSharedPreferences(this);
        contador=datos.getInt("valor", 0);
        mostrarContador();
    }

    /*

    @Override
    protected void onSaveInstanceState(@NonNull Bundle estado) {
        estado.putInt("valor",contador);
        super.onSaveInstanceState(estado);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        contador= savedInstanceState.getInt("valor",0);
        mostrarContador();
    }
*/


    public void Incrementa(View view) {
contador++;
mostrarContador();
    }

    public void Decrementa (View vista) {
        CheckBox negativos= (CheckBox) findViewById (R.id.permitirNegativos);
        contador--;

        if((contador<=0) && !(negativos.isChecked())) {
contador =0; }
/* else ((contador= contador) && (negativos.isChecked())) {contador};/*

 */

        mostrarContador();
    }

    public void resetea (View vista) {
        contador=0;
        mostrarContador();
    }

    public void mostrarContador ()
    {
        TextView valor = (TextView) findViewById(R.id.resultado);
        valor.setText(String.valueOf(contador));
     }


}