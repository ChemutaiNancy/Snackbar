package com.chemutai.snackbar;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CoordinatorLayout rootLayout;//coordinator layout removes the overlaping of fab and snackbar and enables the swipe of the snackbar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootLayout = findViewById(R.id.myLayout);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(rootLayout,"Simple Snackbar Example", Snackbar.LENGTH_LONG).show();

                /*Toast.makeText(MainActivity.this, "Floating Action Button has been Clicked!", Toast.LENGTH_SHORT).show();*/
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Basic Components");
        toolbar.inflateMenu(R.menu.menu_main);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()){

                    case R.id.simple_snackbar:
                        showSimpleSnackbar();
                        break;

                    case R.id.snackbar_action_callback:
                        showSnackbarWithActionCallBack();
                        break;

                    case R.id.custom_snackbar:
                        showSnackbarWithColoredText();
                        break;
                }

                return false;
            }
        });
    }




    private void showSimpleSnackbar() {

        Snackbar.make(rootLayout,"Simple Snackbar Example", Snackbar.LENGTH_LONG).show();

    }

    private void showSnackbarWithActionCallBack() {

        Snackbar snackbar = Snackbar.make(rootLayout, "File Deleted Successfully", Snackbar.LENGTH_LONG);
        snackbar.setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(rootLayout, "File Recovered Successfully", Snackbar.LENGTH_SHORT).show();
            }
        });

        snackbar.show();

    }

    private void showSnackbarWithColoredText() {

        final Snackbar snackbar = Snackbar.make(rootLayout, "Error Deleting File", Snackbar.LENGTH_LONG).setActionTextColor(Color.RED)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                      Snackbar.make(rootLayout, "Try reloading again", Snackbar.LENGTH_LONG).setActionTextColor(Color.RED).show();
                    }
                });
                snackbar.show();//still working on red background in snackbar
    }

}
