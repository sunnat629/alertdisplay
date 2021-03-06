package com.dreamogrammers.sunnat.alertdisplay;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.dreamogrammers.sunnat.alertdisplay.R.id.buttonCircularProgress;


public class ToastSnackbarActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonSimpleToast, buttonSimpleSnackbar, buttonActionCallback, buttonCustomSnackbar;
    private CoordinatorLayout coordinatorLayout;
    FloatingActionButton floatingactionbutton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_snackbar);
        initializationForLayout();

        buttonSimpleToast.setOnClickListener(this);
        buttonSimpleSnackbar.setOnClickListener(this);
        buttonActionCallback.setOnClickListener(this);
        buttonCustomSnackbar.setOnClickListener(this);
        floatingactionbutton.setOnClickListener(this);
    }

    private void initializationForLayout() {


        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        buttonSimpleToast = (Button) findViewById(R.id.buttonSimpleToast);
        buttonSimpleSnackbar = (Button) findViewById(R.id.buttonSimpleSnackbar);
        buttonCustomSnackbar = (Button) findViewById(R.id.buttonCustomSnackbar);
        buttonActionCallback = (Button) findViewById(R.id.buttonActionCallback);
        // This is the Floating Action Button
        floatingactionbutton = (FloatingActionButton) findViewById(R.id.floatingactionbutton);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.floatingactionbutton:
                Snackbar.make(coordinatorLayout, "Alert !!!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            case R.id.buttonSimpleToast:
                Toast.makeText(getApplicationContext(), "I am a flying Toast.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonSimpleSnackbar:
                Snackbar SimpleSnackbar = Snackbar
                        .make(coordinatorLayout, "I am better than Toast. you have to use support:design libs to use me.", Snackbar.LENGTH_LONG);
                SimpleSnackbar.show();
                break;
            case R.id.buttonActionCallback:

                Snackbar ActionCallback = Snackbar
                        .make(coordinatorLayout, "Please don't go without click me. :(", Snackbar.LENGTH_LONG)
                        // This will make a button to open more option
                        .setAction("Click", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                // Another Snackbar for the Action Button
                                Snackbar subSnackbar = Snackbar.make(coordinatorLayout, "Hello, how are you? :)", Snackbar.LENGTH_SHORT);
                                subSnackbar.show();
                            }
                        });

                ActionCallback.show();
                break;
            case R.id.buttonCustomSnackbar:
                Snackbar CustomSnackbar = Snackbar
                        .make(coordinatorLayout, "I am very colorful.", Snackbar.LENGTH_LONG)
                        // This will make a button to open more option
                        .setAction("Click", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                // Another Snackbar for the Action Button
                                Snackbar subSnackbar = Snackbar.make(coordinatorLayout, "I am very simple.", Snackbar.LENGTH_SHORT);
                                subSnackbar.show();
                            }
                        });

                // Changing action button text color
                CustomSnackbar.setActionTextColor(Color.RED);

                // Changing message text color
                View subView = CustomSnackbar.getView();

                // THis is a builtin custom layout for your snackbar
                TextView textView = (TextView) subView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                CustomSnackbar.show();
                break;
            case buttonCircularProgress:
                Intent goToCircularProgressButton = new Intent(this, CircularProgressButton.class);
                startActivity(goToCircularProgressButton);
                break;

        }
    }
}
