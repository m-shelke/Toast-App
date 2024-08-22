package com.example.toastapp;

import android.os.Bundle;
import android.print.PrintAttributes;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnToast = findViewById(R.id.btnToast);

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //By default Toast in android studio
              //  Toast.makeText(MainActivity.this, "Hello, It's me Toast..", Toast.LENGTH_SHORT).show();

                Toast toast = new Toast(getApplicationContext());
              View view = getLayoutInflater().inflate(R.layout.custom_toast_layout,findViewById(R.id.viewGroup));
                toast.setView(view);

                TextView txtToast = view.findViewById(R.id.txtToast);
                txtToast.setText("Custom Message Display Successfully..");

                toast.setDuration(Toast.LENGTH_LONG);
                toast.setMargin(0,-10);
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,0,0);

                toast.show();
            }
        });
    }
}