package com.example.prm_assignment_foodanddrink;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {

    Database database;
    ListView listViewFood;
    Button btnOrderFood;
    ArrayList<Food> arrayFood;
    FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        listViewFood = (ListView) findViewById(R.id.listViewFood);
        btnOrderFood = (Button) findViewById(R.id.buttonOrderFood);
        btnOrderFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        arrayFood = new ArrayList<>();
        foodAdapter = new FoodAdapter(this, R.layout.food_layout, arrayFood, this);
        listViewFood.setAdapter(foodAdapter);
        listViewFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listViewFood = (ListView) parent;
                Food food = (Food) listViewFood.getItemAtPosition(position);
                String item = food.getFoodName() + " has been selected!";
                Toast.makeText(FoodActivity.this, item, Toast.LENGTH_SHORT).show();
                FoodAdapter adapter = (FoodAdapter) parent.getAdapter();
                final Intent data = new Intent();
                data.putExtra("FOOD_NAME", food.getFoodName());
                adapter.getFoodActivity().setResult(1, data);
            }
        });

//Create db
        database = new Database(this, "Foodee.sqlite", null, 1);

//Create table Food
        database.QueryData("Create table if not exists ListFood(id Integer Primary Key Autoincrement, " + "FoodName nvarchar(200), " + "FoodPrice Integer)");

//Insert data
//        database.QueryData("Insert into ListFood values(null, 'Banh canh ca loc', '30000đ')");
//        database.QueryData("Insert into ListFood values(null, 'Bun bo Hue', '35000đ')");
//        database.QueryData("Insert into ListFood values(null, 'Bun rieu cua', '30000đ')");
//        database.QueryData("Insert into ListFood values(null, 'Mi quang Da Nang', '45000đ')");
//        database.QueryData("Insert into ListFood values(null, 'Bun ca ro dong Hai Phong', '40000đ')");
//        database.QueryData("Insert into ListFood values(null, 'Banh xeo Quang Nam', '28000đ')");
//        database.QueryData("Insert into ListFood values(null, 'Banh uot Quang Tri', '30000đ')");
//        database.QueryData("Insert into ListFood values(null, 'Hu tieu Sai Gon', '25000đ')");
//        database.QueryData("DELETE FROM ListFood WHERE FoodName IN ('Banh canh ca loc', 'Bun bo Hue', 'Bun rieu cua', 'Mi quang Da Nang', 'Bun ca ro dong Hai Phong', 'Banh xeo Quang Nam', 'Banh uot Quang Tri', 'Hu tieu Sai Gon')");
        GetDataFood();

    }

    private void GetDataFood() {
        Cursor dataFood = database.GetData("Select * from ListFood");
        arrayFood.clear();

        while (dataFood.moveToNext()) {
            String name = dataFood.getString(1);
            int id = dataFood.getInt(0);
            String price = dataFood.getString(2);
            arrayFood.add(new Food(id, name, price));
        }
        foodAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
//        return super.onCreateOptionsMenu(menu);
        return true;
    }
}
