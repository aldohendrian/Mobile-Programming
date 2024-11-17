package com.example.infopariwisataisleventurer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Inisialisasi view
        ImageView imageView = findViewById(R.id.largeImage);
        TextView nameTextView = findViewById(R.id.placeName);
        TextView locationTextView = findViewById(R.id.placeLocation);
        TextView descriptionTextView = findViewById(R.id.placeDescription);

        // Ambil data dari Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String location = intent.getStringExtra("location");
        String description = intent.getStringExtra("description");
        int imageResourceId = intent.getIntExtra("imageResourceId", -1);

// Log untuk melihat data yang diterima
        Log.d(TAG, "Intent Data - Name: " + name);
        Log.d(TAG, "Intent Data - Location: " + location);
        Log.d(TAG, "Intent Data - Description: " + description);
        Log.d(TAG, "Intent Data - ImageResourceId: " + imageResourceId);

        // Validasi dan set data ke view
        if (name != null && location != null && description != null && imageResourceId != -1) {
            nameTextView.setText(name);
            locationTextView.setText(location);
            descriptionTextView.setText(description);
            imageView.setImageResource(imageResourceId);
        } else {
            Log.e(TAG, "Invalid data received");
            nameTextView.setText("Data tidak ada");
            locationTextView.setText("");
            descriptionTextView.setText("");
            imageView.setImageResource(R.drawable.logo); // Placeholder gambar
        }
    }
}
