package hcmute.edu.vn.nhom07.foodyapp_group07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class StoreDetailActivity extends AppCompatActivity {

    RecyclerView recyclerViewFoodHotDeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_detail);

        List<FoodItems> foods = new ArrayList<>();

        foods.add(new FoodItems("Hamburger Bò", "@drawable/img_hamburger", 30, "45.000", "39.000"));
        foods.add(new FoodItems("Hamburger Bò", "@drawable/img_hamburger", 30, "45.000", "39.000"));
        foods.add(new FoodItems("Hamburger Bò", "@drawable/img_hamburger", 30, "45.000", "39.000"));

        recyclerViewFoodHotDeal = (RecyclerView) findViewById(R.id.recyclerViewHotDealFood);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewFoodHotDeal.setLayoutManager(layoutManager);
        recyclerViewFoodHotDeal.setHasFixedSize(true);
        recyclerViewFoodHotDeal.setAdapter(new FoodHotDealItemsAdapter(this, foods));

    }
}