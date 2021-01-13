package com.uas.rumahmakan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.backup.SharedPreferencesBackupHelper;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.uas.rumahmakan.model.RumahMakan;

public class FormRumahMakan extends AppCompatActivity {

    Button btnSimpan;
    TextInputLayout til_nama, til_alamat, til_kontak;
    Spinner spnMenu;
    final String[] tipeLis = {RumahMakan.AYAM_TALILWANG, RumahMakan.BUBUR_AYAM, RumahMakan.BAKSO, RumahMakan.NASI_PUYUNG};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_rumah_makan);
        inisialisasiView();

    }

    private void inisialisasiView() {
        btnSimpan = findViewById(R.id.btn_simpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FormRumahMakan.this.simpan();
            }
        });
        til_nama = findViewById(R.id.til_nama);
        til_alamat = findViewById(R.id.til_alamat);
        til_kontak = findViewById(R.id.til_kontak);
        spnMenu = findViewById(R.id.spn_menu);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                tipeLis
        );
        spnMenu.setAdapter(adapter);
        spnMenu.setSelection(0);
    }

    private void simpan() {
        if (isDataValid()) {
            RumahMakan tr = new RumahMakan();
            tr.setNamaMakanan(til_nama.getEditText().getText().toString());
            tr.setAlamat(til_alamat.getEditText().getText().toString());
            tr.setKontak(til_kontak.getEditText().getText().toString());
            tr.setMenu(spnMenu.getSelectedItem().toString());
            SharedPreferences(this,tr);
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
        if (til_nama.getEditText().getText().toString().isEmpty()
                || til_alamat.getEditText().getText().toString().isEmpty()
                || til_kontak.getEditText().getText().toString().isEmpty()
                || spnMenu.getSelectedItem().toString().isEmpty()
        ) {
            Toast.makeText(this, "Data tidak bileh ada yang kosong", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}