package facci.pm.parragapazmino.yorlyapp;


import com.orm.SugarRecord;

public class Series extends SugarRecord<Series>  {
    String nombre;
    String categoria;
    String protagonistas;
    String inicial;
    String temporadas;

    public Series() {
    }

    public Series(String nombre, String categoria, String protagonistas, String inicial, String temporadas) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.protagonistas = protagonistas;
        this.inicial = inicial;
        this.temporadas = temporadas;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getProtagonistas() {
        return protagonistas;
    }

    public void setProtagonistas(String protagonistas) {
        this.protagonistas = protagonistas;
    }

    public String getInicial() {
        return inicial;
    }

    public void setInicial(String inicial) {
        this.inicial = inicial;
    }

    public String getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(String temporadas) {
        this.temporadas = temporadas;
    }
}
