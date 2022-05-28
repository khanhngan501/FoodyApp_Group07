package hcmute.edu.vn.nhom07.foodyapp_group07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerViewStore;
    private RecyclerView recyclerView_Vertical;
    private LinearLayout cart_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setRecyclerViewStore();

        setRecyclerView_Vertical();
        cart_btn = (LinearLayout) findViewById(R.id.cart_btn);
        cart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new  Intent(HomeActivity.this, CartDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setRecyclerViewStore(){
        List<StoreItems> hotDealStores = new ArrayList<>();

        hotDealStores.add(new StoreItems("K-Food Chicken", "@drawable/img_chicken", 4.5, 500, "106 Tô Vĩnh Diện, Linh Trung, Thủ Đức, TP.Hồ Chí Minh", 1.9, true));
        hotDealStores.add(new StoreItems("Bobabop - Hoàng Diệu 2", "@drawable/img_bobapop", 4.9, 999, "152 Hoàng Diệu 2, Linh Trung, Thủ Đức, TP.Hồ Chí Minh", 1.5, true));
        hotDealStores.add(new StoreItems("Cơm tấm Phúc Lộc Thọ", "@drawable/img_rice", 4.4, 999, "31 - 33 Lê Văn Việt, Thủ Đức, TP.Hồ Chí Minh", 2.9, true));
        hotDealStores.add(new StoreItems("Cơm tấm Phúc Lộc Thọ", "@drawable/img_rice", 4.4, 999, "31 - 33 Lê Văn Việt, Thủ Đức, TP.Hồ Chí Minh", 2.9, true));

        recyclerViewStore = (RecyclerView) findViewById(R.id.recyclerViewStore);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewStore.setLayoutManager(layoutManager);
        recyclerViewStore.setHasFixedSize(true);
        recyclerViewStore.setAdapter(new HotDealStoreItemsAdapter(this, hotDealStores));
    }

    private void setRecyclerView_Vertical(){
        List<StoreItems> popularStores = new ArrayList<>();

        popularStores.add(new StoreItems("K-Food Chicken", "@drawable/img_chicken", 4.5, 500, "106 Tô Vĩnh Diện, Linh Trung, Thủ Đức, TP.Hồ Chí Minh", 1.9, true));
        popularStores.add(new StoreItems("Bobabop - Hoàng Diệu 2", "@drawable/img_bobapop", 4.9, 999, "152 Hoàng Diệu 2, Linh Trung, Thủ Đức, TP.Hồ Chí Minh", 1.5, true));
        popularStores.add(new StoreItems("Cơm tấm Phúc Lộc Thọ", "@drawable/img_rice", 4.4, 999, "31 - 33 Lê Văn Việt, Thủ Đức, TP.Hồ Chí Minh", 2.9, true));
        popularStores.add(new StoreItems("K-Food Chicken", "@drawable/img_chicken", 4.5, 500, "106 Tô Vĩnh Diện, Linh Trung, Thủ Đức, TP.Hồ Chí Minh", 1.9, true));

        recyclerView_Vertical = (RecyclerView) findViewById(R.id.recyclerViewStore_Vertical);
        LinearLayoutManager layoutManagerVertical = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView_Vertical.setLayoutManager(layoutManagerVertical);
        recyclerView_Vertical.setHasFixedSize(true);
        recyclerView_Vertical.setAdapter(new PopularStoreItemsAdapter(this, popularStores));
    }
}