package facci.pm.parragapazmino.yorlyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class lista extends AppCompatActivity {

    ListView listaSeries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        listaSeries = findViewById(R.id.listaSeries);

        //List<Series> serie = Series.listAll(Series.class);
        List<Series> seriesList = Series.listAll(Series.class);
        List<String> ListaTextoSeries = new ArrayList<>();

        for (Series Serie: seriesList){
            Log.e("Series", Serie.getNombre()+" "+Serie.getCategoria()+" "+Serie.getProtagonistas()+" "+Serie.getInicial()+" "+Serie.getTemporadas());
            ListaTextoSeries.add(Serie.getNombre()+" "+Serie.getCategoria()+" "+Serie.getProtagonistas()+" "+Serie.getInicial()+" "+Serie.getTemporadas());
        }
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, ListaTextoSeries);
        listaSeries.setAdapter(itemsAdapter);
    }
}
