package com.paum.ksiazkakucharska;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startRecipesActivity(View view){
        Intent intent = new Intent(this, RecipesActivity.class);
        startActivity(intent);
    }

    public void startSearchActivity(View view){
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    public void startAddRecipeActivity(View view){
        Intent intent = new Intent (this, AddRecipeActivity.class);
        startActivity(intent);
    }

    public void startListsActivity(View view){
        Intent intent = new Intent(this, ListsActivity.class);
        startActivity(intent);
    }
}
