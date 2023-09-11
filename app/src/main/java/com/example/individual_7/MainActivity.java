package com.example.individual_7;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import com.example.individual_7.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements IviewPresenter {
    private ActivityMainBinding binding;
    private Presentador presentador;
    private Drawable imageWeak;
    private Drawable imageMedium;
    private Drawable imageStrong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presentador = new Presentador( this);
        binding.textViewTitle.setText("¿Qué tan segura es tu contraseña?");
        imageWeak = getResources().getDrawable(R.drawable.weak);
        imageMedium = getResources().getDrawable(R.drawable.medium);
        imageStrong = getResources().getDrawable(R.drawable.strong);


        binding.editTextPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presentador.evalPassword(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    public void showWeak() {
        binding.textViewStrength.setBackgroundColor(Color.RED);
        binding.textViewStrength.setText("Débil");
        binding.imageViewStrength.setImageDrawable(imageWeak);
        binding.buttonEnter.setOnClickListener(v -> {
            Toast.makeText(this, "Su contraseña es insegura", Toast.LENGTH_SHORT).show();
        });
    }


    public void showMedium() {
        binding.textViewStrength.setBackgroundColor(Color.YELLOW);
        binding.textViewStrength.setText("Medio");
        binding.imageViewStrength.setImageDrawable(imageMedium);
        binding.buttonEnter.setOnClickListener(v -> {
            Toast.makeText(this, "Su contraseña es medianamente segura", Toast.LENGTH_SHORT).show();
        });
    }


    public void showStrong() {
        binding.textViewStrength.setBackgroundColor(Color.GREEN);
        binding.textViewStrength.setText("Fuerte");
        binding.imageViewStrength.setImageDrawable(imageStrong);
        binding.buttonEnter.setOnClickListener(v -> {
            Toast.makeText(this, "Su contraseña es segura", Toast.LENGTH_SHORT).show();
        });
    }


    public void showError() {
        binding.textViewStrength.setBackgroundColor(Color.RED);
        binding.textViewStrength.setText("Error");
    }
}