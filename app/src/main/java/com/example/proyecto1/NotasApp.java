package com.example.proyecto1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import java.util.ArrayList;
import java.util.List;

import yuku.ambilwarna.AmbilWarnaDialog;


public class NotasApp extends AppCompatActivity {

    private List<String> item;
    private GridView gridView;
    private MyAdapter myAdapter;
    private int Elementos;
    int nDefaultColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_app);

        //Icono en la barra
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        //color
        nDefaultColor = ContextCompat.getColor(NotasApp.this, R.color.black);

        gridView = (GridView) findViewById(R.id.gridView);
        item = new ArrayList<String>();
        Elementos = R.layout.grid_item;

        /*gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(NotasApp.this, "Mitsuha", Toast.LENGTH_LONG).show();
            }
        });*/
        //imagen

        myAdapter = new MyAdapter(this, (Elementos), item);
        gridView.setAdapter(myAdapter);
        registerForContextMenu(gridView);
          }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bar_menu, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected( MenuItem item) {

        switch (item.getItemId()){
            case R.id.add_imagen:

                this.item.add("");
                this.myAdapter.agregarImagen();
                return true;

            case R.id.add_notas:
                this.item.add("");
                this.myAdapter.agregarNota();
                return true;


            case R.id.salida:
                finish();


            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(this.item.get(info.position));
        inflater.inflate(R.menu.context_menu,menu);
    }





    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.Cambiar_color:
                cambioColor();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }

    public void cambioColor(){
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, nDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
            }
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                nDefaultColor = color;
                //note.setBackgroundColor(mDefaultColor);
            }
        });
        colorPicker.show();

    }


}
