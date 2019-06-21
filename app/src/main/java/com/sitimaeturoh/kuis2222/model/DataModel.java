package com.sitimaeturoh.kuis2222.model;

    import com.google.gson.annotations.SerializedName;
    @SuppressWarnings("unused")
    public class DataModel {
        @SerializedName("kategori")
        private String mkategori;
        @SerializedName("id")
        private String mId;
        @SerializedName("kodeminimarket")
        private String mkodeminimarket;
        @SerializedName("namaminimarket")
        private String mnamaminimarket;
        public String getkategori() {
            return mkategori;
        }
        public void setkategori(String kategori) {
            mkategori = kategori;
        }
        public String getId() {
            return mId;
        }
        public void setId(String id) {
            mId = id;
        }
        public String getkodeminimarket() {
            return mkodeminimarket;
        }
        public void setkodeminimarket(String kodeminimarket) {
            mkodeminimarket = kodeminimarket;
        }
        public String getnamaminimarket() {
            return mnamaminimarket;
        }
        public void setnamaminimarket(String namaminimarket) {
            mnamaminimarket = namaminimarket;
        }
    }

