package com.cyberfox21.cryptoapp.presentation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.cyberfox21.cryptoapp.databinding.ActivityMainBinding;

/**
 * @author t.shkolnik
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
