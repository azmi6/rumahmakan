package com.example.rumahmakan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.rumahmakan.model.Makanan;
import com.google.android.material.textfield.TextInputLayout;

public class FormRumahMakan extends AppCompatActivity {

    Button btnSimpan;
    TextInputLayout tilNM, tilKt, tilAl, tilNo;
    Spinner spnJn;
    final String[] tipeLis = {Makanan.AYAM_GEPREK, Makanan.BEBEK_BAKAR, Makanan.NASI_BUBUT, Makanan.NASI_UDUK, Makanan.PECEL_UDANG};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_rumah_makan);
        inisialisasiView();
    }

    private void inisialisasiView() {
        btnSimpan = findViewById(R.id.btn_simpan);
        btnSimpan.setOnClickListener(view -> simpan());
        tilNM = findViewById(R.id.til_nm);
        tilAl = findViewById(R.id.til_al);
        tilKt = findViewById(R.id.til_kt);
        tilNo = findViewById(R.id.til_no);
        spnJn = findViewById(R.id.spn_jm);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                tipeLis
        );
        spnJn.setAdapter(adapter);
        spnJn.setSelection(0);
    }

    private void simpan() {
        if (isDataValid()) {
            Makanan tr = new Makanan();
            tr.setNamaMakanan(tilNM.getEditText().getText().toString());
            tr.setAlamat(tilAl.getEditText().getText().toString());
            tr.setJenisMakanan(tilKt.getEditText().getText().toString());
            tr.setNo(tilNo.getEditText().getText().toString());
            tr.setKontak(spnJn.getSelectedItem().toString());
            SharedPerefereUtility.addLis(this, tr);
            Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();

            // Kembali ke layar sebelumnya setelah 500 ms (0.5 detik)
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 500);

        }
    }

    private boolean isDataValid() {
        if (tilNM.getEditText().getText().toString().isEmpty()
                || tilAl.getEditText().getText().toString().isEmpty()
                || tilKt.getEditText().getText().toString().isEmpty()
                || tilNo.getEditText().getText().toString().isEmpty()
                || spnJn.getSelectedItem().toString().isEmpty()
        ) {
            Toast.makeText(this, "Data tidak bileh ada yang kosong", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}