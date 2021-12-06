package com.yudha29.contactperson;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Main activity class.
 *
 */
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    // On activity create
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find recycler view component & set the layout.
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Build retrofit with https://jsonplaceholder.typicode.com as base URL.
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Connect the retrofit with the json place holder service.
        JSONPlaceHolderService jsonPlaceHolderService = retrofit
                .create(JSONPlaceHolderService.class);

        // Fetch all users.
        Call<List<User>> call = jsonPlaceHolderService.getUsers();

        call.enqueue(new Callback<List<User>>() {
            // On response received
            @Override
            public void onResponse(@NonNull Call<List<User>> call, @NonNull Response<List<User>> response) {
                if (!response.isSuccessful()) {
                    // Show status code when not successful
                    Toast
                            .makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT)
                            .show();
                    return;
                }

                // Otherwise get the response's body
                List<User> users = response.body();

                // Put the data into adapter and set the recycler view's adapter
                UserAdapter userAdapter = new UserAdapter(MainActivity.this, users);
                recyclerView.setAdapter(userAdapter);
            }

            // On failure
            @Override
            public void onFailure(@NonNull Call<List<User>> call, @NonNull Throwable t) {
                // Show failure error message
                Toast
                        .makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}