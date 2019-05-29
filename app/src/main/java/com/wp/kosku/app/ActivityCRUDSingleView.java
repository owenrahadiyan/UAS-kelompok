package com.wp.kosku.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wp.kosku.app.model.Kos;

public class ActivityCRUDSingleView extends AppCompatActivity {

    private Button btSubmit;
    private EditText etNama;
    private EditText etNamaDosen;
    private EditText etNoHp;
    private EditText etLamaSewa;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_create);
        etNama = (EditText) findViewById(R.id.et_nama);
        etNamaDosen = (EditText) findViewById(R.id.et_alamat);
        etNoHp = (EditText) findViewById(R.id.et_nohp);
        etLamaSewa = (EditText) findViewById(R.id.et_lamasewa);
        btSubmit = (Button) findViewById(R.id.bt_submit);

        etNama.setEnabled(false);
        etNamaDosen.setEnabled(false);
        etNoHp.setEnabled(false);
        etLamaSewa.setEnabled(false);
        btSubmit.setVisibility(View.GONE);

        Kos kos = (Kos) getIntent().getSerializableExtra("data");
        if(kos!=null){
            etNama.setText(kos.getNama());
            etNamaDosen.setText(kos.getAlamat());
            etNoHp.setText(kos.getNoHp());
            etLamaSewa.setText(kos.getLamaSewa());
        }
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, ActivityCRUDSingleView.class);
    }
}
