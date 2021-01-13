package com.example.rumahmakan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.rumahmakan.model.Makanan;

import java.util.List;

public class DafatarMakananAdapter extends ArrayAdapter<Makanan> {
    Context context;

    public DafatarMakananAdapter(@NonNull Context context, @NonNull List<Makanan> objects) {
        super(context, R.layout.row_makanan, objects);
        this.context = context;
    }

    class ViewHolder {
        TextView txNamaMakanan;
        TextView txAlamat;
        TextView txJenisMakanan;
        TextView txKontak;
        TextView txNO;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Makanan tr = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_makanan, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txNamaMakanan = convertView.findViewById(R.id.row_nama);
            viewHolder.txAlamat = convertView.findViewById(R.id.row_al);
            viewHolder.txJenisMakanan = convertView.findViewById(R.id.row_js);
            viewHolder.txKontak = convertView.findViewById(R.id.row_kt);
            viewHolder.txNO = convertView.findViewById(R.id.row_tx_no);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txNamaMakanan.setText(tr.getJenisMakanan());
        viewHolder.txAlamat.setText(tr.getAlamat());
        viewHolder.txKontak.setText(tr.getKontak());
        viewHolder.txNO.setText(tr.getNo());
        if (tr.getJenisMakanan().equals(Makanan.AYAM_GEPREK)) {
            viewHolder.txJenisMakanan.setText("AYAM_GEPREK");
        } else if (tr.getJenisMakanan().equals(Makanan.BEBEK_BAKAR)) {
            viewHolder.txJenisMakanan.setText("BEBEK_BAKAR");
        } else if (tr.getJenisMakanan().equals(Makanan.NASI_BUBUT)) {
            viewHolder.txJenisMakanan.setText("NASI_BUBUT");
        } else if (tr.getJenisMakanan().equals(Makanan.NASI_UDUK)) {
            viewHolder.txJenisMakanan.setText("NASI_UDUK");
        } else if (tr.getJenisMakanan().equals(Makanan.PECEL_UDANG)) {
            viewHolder.txJenisMakanan.setText("PECEL_UDANG");
        }
        return convertView;
    }
}