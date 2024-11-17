package com.example.infopariwisataisleventurer;

import android.os.Bundle;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TouristPlaceAdapter adapter;
    private List<TouristPlace> touristPlaces;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        SearchView searchView = findViewById(R.id.searchView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Data Sampel
        touristPlaces = new ArrayList<>();
        touristPlaces.add(new TouristPlace(
                "Pulau Bali",
                "Pulau Bali, Provinsi Bali, Indonesia",
                "Surga tropis yang menawarkan pantai berpasir putih, pura yang megah, dan kehidupan malam yang berwarna. Pulau Bali juga dikenal sebagai destinasi budaya dengan berbagai festival tradisional dan tarian khas yang memikat. Jangan lewatkan keindahan matahari terbenam di Pantai Kuta atau pengalaman spiritual di Pura Uluwatu.",
                R.drawable.bali
        ));
        touristPlaces.add(new TouristPlace(
                "Pulau Komodo",
                "Pulau Komodo, Kabupaten Manggarai Barat, Nusa Tenggara Timur, Indonesia",
                "Pulau ini adalah rumah bagi satwa langka, Komodo, yang merupakan kadal terbesar di dunia. Selain itu, Pulau Komodo menawarkan pemandangan alam yang menakjubkan, mulai dari perbukitan savana hingga laut biru jernih yang kaya akan kehidupan bawah laut, menjadikannya destinasi favorit bagi penyelam dan pecinta alam.",
                R.drawable.pulaukomodo
        ));
        touristPlaces.add(new TouristPlace(
                "Pulau Nusa Penida",
                "Nusa Penida, Kabupaten Klungkung, Provinsi Bali, Indonesia",
                "Destinasi yang populer bagi para penyelam dan fotografer, Nusa Penida menawarkan tebing-tebing dramatis, pantai-pantai tersembunyi, dan pemandangan bawah laut yang spektakuler. Jangan lewatkan Angel’s Billabong, Crystal Bay, dan Pantai Kelingking yang terkenal dengan bentuk tebingnya yang menyerupai dinosaurus.",
                R.drawable.nusapenida
        ));
        touristPlaces.add(new TouristPlace(
                "Pulau Pahawang",
                "Pulau Pahawang, Kabupaten Pesawaran, Lampung, Indonesia",
                "Pulau ini adalah destinasi sempurna bagi Anda yang mencari ketenangan dan keindahan bawah laut. Dengan air laut yang jernih dan terumbu karang yang memukau, Pulau Pahawang sering disebut sebagai \"surga tersembunyi\" di Lampung. Aktivitas snorkeling dan diving di sekitar pulau ini tidak boleh dilewatkan.",
                R.drawable.pahawang
        ));
        touristPlaces.add(new TouristPlace(
                "Pulau Maratua",
                "Pulau Maratua, Kabupaten Berau, Kalimantan Timur, Indonesia",
                "Pulau Maratua dikenal dengan pasir putihnya yang lembut dan air laut yang begitu jernih. Pulau ini adalah salah satu surga tropis yang tersembunyi di Indonesia. Dikelilingi oleh atol karang, Maratua adalah tempat yang sempurna untuk relaksasi sambil menikmati pemandangan matahari terbenam yang luar biasa.",
                R.drawable.maratua
        ));
        touristPlaces.add(new TouristPlace(
                "Pulau Weh",
                "Pulau Weh, Sabang, Provinsi Aceh, Indonesia",
                "Pulau Weh adalah pintu gerbang ke titik nol kilometer Indonesia dan surga tersembunyi yang menyuguhkan keindahan bawah laut yang tiada tara. Nikmati pengalaman snorkeling atau diving di Iboih, atau hanya bersantai di Pantai Gapang dengan suasana yang damai dan menyegarkan.",
                R.drawable.weh
        ));
        touristPlaces.add(new TouristPlace(
                "Pulau Lombok",
                "Pulau Lombok, Provinsi Nusa Tenggara Barat, Indonesia",
                "Dikenal sebagai \"saudara kembar\" Bali, Pulau Lombok menawarkan suasana yang lebih tenang dengan pesona alam yang tak kalah indah. Dari pantai-pantai eksotis seperti Pantai Tanjung Aan hingga Gunung Rinjani yang megah, Lombok adalah destinasi yang cocok untuk petualang dan pencari ketenangan.",
                R.drawable.lombok
        ));
        touristPlaces.add(new TouristPlace(
                "Pulau Mojo",
                "Pulau Mojo, Kabupaten Sumbawa, Nusa Tenggara Barat, Indonesia",
                "Pulau Mojo adalah destinasi yang menawarkan keindahan alam yang alami dan jauh dari keramaian. Dengan hamparan laut biru yang menenangkan, pantai pasir putih, dan suasana yang asri, Pulau Mojo menjadi tempat sempurna untuk melarikan diri dari hiruk-pikuk kota.",
                R.drawable.mojo
        ));

        // Set Adapter untuk RecyclerView
        adapter = new TouristPlaceAdapter(touristPlaces, this);
        recyclerView.setAdapter(adapter);

        // Set Listener untuk SearchView
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterList(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return false;
            }
        });
    }

    // Fungsi untuk memfilter daftar tempat wisata berdasarkan query pencarian
    private void filterList(String text) {
        List<TouristPlace> filteredList = new ArrayList<>();
        for (TouristPlace place : touristPlaces) {
            if (place.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(place);
            }
        }
        adapter.updateList(filteredList);
    }
}
