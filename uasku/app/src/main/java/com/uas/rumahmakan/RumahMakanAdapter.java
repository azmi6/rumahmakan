package com.uas.rumahmakan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.uas.rumahmakan.model.RumahMakan;

import java.util.List;

public class RumahMakanAdapter extends ArrayAdapter<RumahMakan> {
    Context context;

    public RumahMakanAdapter(@NonNull Context context, @NonNull List<RumahMakan> objects) {
        super(context, R.layout.row_rumahkan_makan, objects);
        this.context = context;
    }

    class ViewHolder {
        TextView txNamaMakanan;
        TextView txAlamat;
        TextView txMenu;
        TextView txKontak;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        RumahMakan tr = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_rumahkan_makan, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txNamaMakanan = convertView.findViewById(R.id.row_nama);
            viewHolder.txAlamat = convertView.findViewById(R.id.row_alamat);
            viewHolder.txMenu = convertView.findViewById(R.id.row_menu);
            viewHolder.txKontak = convertView.findViewById(R.id.row_kontak);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txNamaMakanan.setText(tr.getNamaMakanan());
        viewHolder.txAlamat.setText(tr.getAlamat());
        viewHolder.txKontak.setText(tr.getKontak());
        if (tr.getMenu().equals(RumahMakan.AYAM_TALILWANG)) {
            viewHolder.txMenu.setText("AYAM_TALIWANG");
        } else if (tr.getMenu().equals(RumahMakan.BAKSO)) {
            viewHolder.txMenu.setText("SAMSUNG");
        } else if (tr.getMenu().equals(RumahMakan.BUBUR_AYAM)) {
            viewHolder.txMenu.setText("VIVO");
        } else if (tr.getMenu().equals(RumahMakan.NASI_PUYUNG)) {
            viewHolder.txMenu.setText("OPPO");
        }else {
            viewHolder.txMenu.setText("UMUM");
        }
        return convertView;
    }
}

