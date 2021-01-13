package com.example.rumahmakan.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

public class Makanan {

    public static final String NASI_UDUK = "NASI_UDUK";
    public static final String PECEL_UDANG = "PECEL_UDANG";
    public static final String NASI_BUBUT = "NASI_BUBUT";
    public static final String AYAM_GEPREK = "AYAM_GEPREK";
    public static final String BEBEK_BAKAR = "BEBEK_BAKAR";


    private String id;
    private String namaMakanan;
    private String alamat;
    private String jenisMakanan;
    private String kontak;
    private String no;

    public Makanan() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public void setNamaMakanan(String namaMakanan) {
        this.namaMakanan = namaMakanan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenisMakanan() {
        return jenisMakanan;
    }

    public void setJenisMakanan(String jenisMakanan) {
        this.jenisMakanan = jenisMakanan;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public static Makanan fromJSONObject(JSONObject obj) {
        Makanan tr = new Makanan();
        try {
            tr.setId(obj.getString("id"));
            tr.setNamaMakanan(obj.getString("nama_makanan"));
            tr.setAlamat(obj.getString("alamat"));
            tr.setJenisMakanan(obj.getString("jenis_makanan"));
            tr.setKontak(obj.getString("kontak"));
            tr.setNo(obj.getString("no"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tr;
    }

    public JSONObject toJSONObject() {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("id", this.id);
            jsonObj.put("nama_makanan", this.namaMakanan);
            jsonObj.put("alamat", this.alamat);
            jsonObj.put("jenis_makanan", this.jenisMakanan);
            jsonObj.put("kontak", this.kontak);
            jsonObj.put("no", this.no);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObj;
    }
}
