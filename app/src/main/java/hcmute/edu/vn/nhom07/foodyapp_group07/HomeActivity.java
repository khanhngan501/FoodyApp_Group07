package hcmute.edu.vn.nhom07.foodyapp_group07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    ListView listViewFoodList;
    private RecyclerView recyclerViewStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        List<StoreItems> stores = new ArrayList<>();
        stores.add(new StoreItems("K-Food Chicken", "@drawable/img_chicken", 4.5, 500, "106 Tô Vĩnh Diện, Linh Trung, Thủ Đức, TP.Hồ Chí Minh"));
        stores.add(new StoreItems("Bobabop - Hoàng Diệu 2", "@drawable/img_bobapop", 4.9, 999, "152 Hoàng Diệu 2, Linh Trung, Thủ Đức, TP.Hồ Chí Minh"));
        stores.add(new StoreItems("Cơm tấm Phúc Lộc Thọ", "@drawable/img_rice", 4.4, 999, "31 - 33 Lê Văn Việt, Thủ Đức, TP.Hồ Chí Minh"));

        recyclerViewStore = (RecyclerView) findViewById(R.id.recyclerViewStore);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewStore.setLayoutManager(layoutManager);
        recyclerViewStore.setHasFixedSize(true);
        recyclerViewStore.setAdapter(new StoreItemsAdapter(this, stores));

    }
}