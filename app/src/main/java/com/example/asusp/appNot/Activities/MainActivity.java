package com.example.asusp.appNot.Activities;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asusp.appNot.R;
import com.example.asusp.appNot.fragments.MainFragment;
import com.example.asusp.appNot.fragments.PendientesFragment;
import com.example.asusp.appNot.fragments.SupermercadoFragment;
import com.example.asusp.appNot.fragments.VacacionesFragment;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ponemos el action bar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout =(DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigationView);

        //  capturo el id del botton flotante
        fab = (FloatingActionButton) findViewById(R.id.fab);

        //Navegacion por los menus | click = cierra menu y muestra la pantalla
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);

                drawerLayout.closeDrawers();

                //selecciono los menus
                switch (item.getItemId()){
                    case R.id.principal:
                        //llamo al metodo
                        setFragment(0);
                        Toast.makeText(getApplicationContext(),"PRINCIPAL",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.supermercado:
                        setFragment(1);
                        Toast.makeText(getApplicationContext(),"SUPERMERCADO",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.pendientes:
                        setFragment(2);
                        Toast.makeText(getApplicationContext(),"PENDIENTES",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.vacaciones:
                        setFragment(3);
                        Toast.makeText(getApplicationContext(),"VACACIONES",Toast.LENGTH_LONG).show();
                        break;
                }
                return false;
            }
        });



        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        //Sincronizacion de estado
        actionBarDrawerToggle.syncState();

        // llammos la vista principal
        setFragment(0);

    }

    //verifico el Fragment y paso la vista
    public void setFragment(int frag){

        // inicio la transaccion
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (frag){
            case 0:
                // creo el Fragment paso el contenedor y confirmo
                MainFragment fragment = new MainFragment();
                transaction.replace(R.id.fragment_content,fragment);
                transaction.commit();
                break;
            case 1:
                SupermercadoFragment fragmentSupermercado = new SupermercadoFragment();
                transaction.replace(R.id.fragment_content,fragmentSupermercado);
                transaction.commit();
                break;
            case 2:
                PendientesFragment fragmentPendientes = new PendientesFragment();
                transaction.replace(R.id.fragment_content,fragmentPendientes);
                transaction.commit();
                break;
            case 3:
                VacacionesFragment fragmentVacaciones = new VacacionesFragment();
                transaction.replace(R.id.fragment_content,fragmentVacaciones);
                transaction.commit();
                break;
        }


       fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Toast.makeText(getApplicationContext(),"ESTE ES UN MENU XD",Toast.LENGTH_LONG).show();

            }
        });

    }


}

