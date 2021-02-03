package facci.pm.parragapazmino.yorlyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText nombre, categoria, protagonistas, inicial, temporadas;
    Button guardar, modificar, eliminar, consultar, siglista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.nombre);
        categoria = findViewById(R.id.categoria);
        protagonistas = findViewById(R.id.protagonistas);
        inicial = findViewById(R.id.inicial);
        temporadas = findViewById(R.id.temporadas);

        guardar = findViewById(R.id.guardar);
        modificar = findViewById(R.id.modificar);
        eliminar = findViewById(R.id.eliminar);
        consultar = findViewById(R.id.consultar);
        siglista = findViewById(R.id.siglista);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Series series = new Series(nombre.getText().toString(),categoria.getText().toString(),protagonistas.getText().toString(),inicial.getText().toString(),temporadas.getText().toString());

                Toast.makeText(v.getContext(), "Se Guardo", Toast.LENGTH_SHORT).show();
                series.save();
            }

        });
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Series> registros = Series.find(Series.class,"nombre = ?",nombre.getText().toString() );
                //Book book = (Book) Book.find(Book.class, titulo.getText().toString(), edicion.getText().toString());
                Series registro = registros.get(0);
                registro.delete();
                Toast.makeText(v.getContext(), "Se Elimino", Toast.LENGTH_SHORT).show();
            }
        });
        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Series> registros = Series.find(Series.class,"nombre = ?",nombre.getText().toString());
                Series registro = registros.get(0);
                categoria.setText(registro.getCategoria());
                inicial.setText(registro.getInicial());
                protagonistas.setText(registro.getProtagonistas());
                temporadas.setText(registro.getTemporadas());
            }
        });
        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Series> registros = Series.find(Series.class,"nombre = ?",nombre.getText().toString() );
                Series registro = registros.get(0);
                registro.nombre=nombre.getText().toString();
                registro.categoria=categoria.getText().toString();
                registro.protagonistas=protagonistas.getText().toString();
                registro.inicial=inicial.getText().toString();
                registro.temporadas=temporadas.getText().toString();
                registro.save();
            }
        });
        siglista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,lista.class);
                startActivity(intent);
            }
        });
    }
}
