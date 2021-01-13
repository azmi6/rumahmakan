package com.example.rumahmakan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rumahmakan.model.Makanan;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton btntambah;
    ImageButton btnedit;
    ListView lvdaftar;
    TextView txnodata, txusername;
    DafatarMakananAdapter adapter;
    List<Makanan> daftarMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();
        loadDataTransaksi();
        setupListview();
    }

    private void inisialisasiView() {
        btntambah = findViewById(R.id.btnTambah);
        btntambah.setOnClickListener(view -> bukaFormTambahMenu());
        btnedit = findViewById(R.id.btn_change_username);
        btnedit.setOnClickListener(view -> changeUserName());
        lvdaftar = findViewById(R.id.lv_list);
        txnodata = findViewById(R.id.tx_nodata);
        txusername = findViewById(R.id.tx_user_name);
        txusername.setText(SharedPerefereUtility.getUserName(this));
        txusername = findViewById(R.id.tx_user_name);
    }

    private void setupListview() {
        adapter = new DafatarMakananAdapter(this, daftarMakanan);
        lvdaftar.setAdapter(adapter);

    }

    private void loadDataTransaksi() {
        daftarMakanan = SharedPerefereUtility.getAllLis(this);
        if (daftarMakanan.size() > 0) {
            txnodata.setVisibility(View.GONE);
        } else {
            txnodata.setVisibility(View.VISIBLE);
        }

    }

    private void refreshListView() {
        adapter.clear();
        loadDataTransaksi();
        adapter.addAll(daftarMakanan);
    }

    private void bukaFormTambahMenu() {
        Intent intent = new Intent(this,FormRumahMakan .class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshListView();
    }

    private void changeUserName() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ganti nama");

        final EditText input = new EditText(this);
        builder.setView(input);

    }

}
