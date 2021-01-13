package com.uas.rumahmakan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.uas.rumahmakan.model.RumahMakan;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton btnTamabah;
    ImageButton btnedit;
    ListView lvdaftar;
    TextView txnodata, txusername;
    RumahMakanAdapter adapter;
    List<RumahMakan> DaftarMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();
        loadDataView();
        setupListview();
    }

    private void inisialisasiView() {
        btnTamabah = findViewById(R.id.btntambah);
        btnTamabah.setOnClickListener(view -> simpan);
        btnedit = findViewById(R.id.btn_change_username);
        btnedit.setOnClickListener(view -> ());
        lvdaftar = findViewById(R.id.lv_list);
        txnodata = findViewById(R.id.tx_nodata);
        txusername = findViewById(R.id.tx_user_name);

    }

    private void setupListview() {
        adapter = new RumahMakanAdapter(this, DaftarMakanan);
        lvdaftar.setAdapter(adapter);

    }

    private void loadDataView() {
        DaftarMakanan = SharedPreferences.(this);
        if (DaftarMakanan.size() > 0) {
            txnodata.setVisibility(View.GONE);
        } else {
            txnodata.setVisibility(View.VISIBLE);
        }

    }

    private void refreshListView() {
        adapter.clear();
        loadDataView();
        adapter.addAll(DaftarMakanan);
    }

    private void bukaFormRumahMakan() {
        Intent intent = new Intent(this, FormRumahMakan.class);
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