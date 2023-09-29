package com.dewabrata.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dewabrata.myapplication.adapter.BeritaAdapter
import com.dewabrata.myapplication.adapter.OnItemBeritaClick
import com.dewabrata.myapplication.model.DataBerita

class ListBerita : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_berita)

        val berita = listOf<DataBerita>(
            DataBerita(
                "https://pluang-production-financial-content-input.s3.ap-southeast-1.amazonaws.com/production/2023/07/lk6kaj4tyleh4wucwar%3Aopenai.jpg",
                R.drawable.logojc,
                "Berita 1",
                "M Yakob pelapor sembilan personel Polda Sumut ke Divisi Propam Polri divonis hakim dengan penjara seumur hidup. Terdakwa dinilai hakim terbukti karena menjadi kurir 20 kg sabu asal Aceh.\n" +
                        "\"Menjatuhkan hukuman pidana terdakwa M Yakob selama seumur hidup,\" kata Ketua Majelis Hakim Pinta Uli Br Tarigan saat membacakan vonis di Pengadilan Negeri (PN) Medan, Selasa, (26/9/2023).\n" +
                        "\n" +
                        "Pinta juga menjelaskan hal memberatkan bahwa perbuatan terdakwa tidak mendukung program pemerintah dalam memberantas narkotika. Serta menikmati hasil menjadi kurir narkoba.\n" +
                        "\n" +
                        "Baca artikel detiksumut, \"Pelapor 9 Personel Polda Sumut Gelapkan Sabu 12 Kg Divonis Seumur Hidup\" selengkapnya https://www.detik.com/sumut/hukum-dan-kriminal/d-6952179/pelapor-9-personel-polda-sumut-gelapkan-sabu-12-kg-divonis-seumur-hidup.\n" +
                        "\n" +
                        "Download Apps Detikcom Sekarang https://apps.detik.com/detik/"
            ),

        )

        val listBerita = findViewById<RecyclerView>(R.id.recycleBerita)
        listBerita.layoutManager = LinearLayoutManager(this)
        listBerita.adapter = BeritaAdapter(berita, object : OnItemBeritaClick {
            override fun onItemClick(berita: DataBerita) {
                intent = Intent(this@ListBerita, BeritaDetail::class.java)
                intent.putExtra("gambarBerita", berita.gambarBerita)
                intent.putExtra("gambarUser", berita.gambarUser)
                intent.putExtra("judulBerita", berita.judulBerita)
                intent.putExtra("isiBerita", berita.isiBerita)
                startActivity(intent)
            }
        })






    }
}