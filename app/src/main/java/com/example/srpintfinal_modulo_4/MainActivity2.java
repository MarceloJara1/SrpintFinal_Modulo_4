package com.example.srpintfinal_modulo_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.srpintfinal_modulo_4.databinding.ActivityMain2Binding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;
    private final String githubUrl = "https://github.com/MarceloJara1";
    private final String phoneNumber = "56973442601";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button contactNow = binding.buttonContactar;

        binding.github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirURL(githubUrl);
            }
        });

        binding.iconButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirURL(githubUrl);
            }
        });

        binding.contactar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(MainActivity2.this);
                builder.setTitle("Alerta")
                        .setMessage("Es probable que si no tienes WhatsApp instalado no funcione este servicio.")
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                               dialog.dismiss();
                            }
                        })
                        .setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                abrirURL(getWhatsAppURL(phoneNumber));
                            }
                        })
                        .show();;
            }
        });

        binding.iconButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(MainActivity2.this);
                builder.setTitle("Alerta")
                        .setMessage("Es probable que si no tienes WhatsApp instalado no funcione este servicio.")
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                abrirURL(getWhatsAppURL(phoneNumber));
                            }
                        })
                        .show();;
            }
        });



        contactNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirFragmento();
                binding.buttonContactar.setVisibility(View.GONE);
            }
        });
    }
    private void abrirURL(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
    private String getWhatsAppURL(String phoneNumber) {
        return "https://api.whatsapp.com/send?phone=" + phoneNumber;
    }

    private void abrirFragmento() {
        BlankFragment fragment = new BlankFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}