package hcmute.edu.vn.nhom07.foodyapp_group07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class StoreDetailActivity extends AppCompatActivity {

    RecyclerView recyclerViewFoodHotDeal;
    RecyclerView recyclerViewListFood;
    FloatingActionButton floatingButtonHome;
    private LinearLayout cart_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_detail);

        List<FoodItems> foods = new ArrayList<>();

        foods.add(new FoodItems("Hamburger Bò", "@drawable/img_hamburger_bo_216x143", 30, "45.000", "39.000", false));
        foods.add(new FoodItems("Kimbap chiên xù", "@drawable/img_kimbap_chien_216x143", 30, "45.000", "39.000", true));
        foods.add(new FoodItems("Miến trộn bò", "@drawable/img_mien_tron_bo_216x143", 30, "45.000", "39.000", true));
        foods.add(new FoodItems("Xiên chả cá Hàn Quốc", "@drawable/img_xien_cha_ca_hq_216x143", 30, "45.000", "39.000", true));

        recyclerViewFoodHotDeal = (RecyclerView) findViewById(R.id.recyclerViewHotDealFood);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewFoodHotDeal.setLayoutManager(layoutManager);
        recyclerViewFoodHotDeal.setHasFixedSize(true);
        recyclerViewFoodHotDeal.setAdapter(new FoodHotDealItemsAdapter(this, foods));

        recyclerViewListFood = (RecyclerView) findViewById(R.id.recyclerViewListFood);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewListFood.setLayoutManager(layoutManager1);
        recyclerViewListFood.setHasFixedSize(true);
        recyclerViewListFood.setAdapter(new ListFoodItemsAdapter(this, foods));

        floatingButtonHome = (FloatingActionButton) findViewById(R.id.floatingButtonHome);
        floatingButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoreDetailActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        cart_btn = (LinearLayout) findViewById(R.id.cart_btn);
        cart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new  Intent(StoreDetailActivity.this, CartDetailActivity.class);
                startActivity(intent);
            }
        });
    }
}