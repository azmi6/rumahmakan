package com.uas.rumahmakan.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

public class RumahMakan {

    public static final String BUBUR_AYAM = "BUBUR_AYAM";
    public static final String AYAM_TALILWANG = "AYAM_TALILWANG";
    public static final String BAKSO = "BAKSO ";
    public static final String NASI_PUYUNG = "NASI_PUYUNG";

    private String id;
    private String namaMakanan;
    private String alamat;
    private String menu;
    private String kontak;

    public RumahMakan() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaMakanan(){ return namaMakanan;}

    public void setNamaMakanan(String namaMakanan) {this.namaMakanan = namaMakanan;}

    public String getAlamat(){ return alamat;}

    public void setAlamat(String alamat) {this.alamat = alamat;}

    public String getMenu(){ return menu;}

    public void setMenu(String menu) {this.menu = menu;}

    public String getKontak(){ return kontak;}

    public void setKontak(String menu) {this.kontak = kontak;}

    public static RumahMakan fromJSONObject(JSONObject obj) {
        RumahMakan tr = new RumahMakan();
        try {
            tr.setId(obj.getString("id"));
            tr.setNamaMakanan(obj.getString("namaMakanan"));
            tr.setAlamat(obj.getString("alamat"));
            tr.setMenu(obj.getString("menu"));
            tr.setKontak(obj.getString("kontak"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tr;
    }

    public JSONObject toJSONObject() {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("id", this.id);
            jsonObj.put("namaMakanan", this.namaMakanan);
            jsonObj.put("alamat", this.alamat);
            jsonObj.put("menu", this.menu);
            jsonObj.put("kontak", this.kontak);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObj;
    }

}
