package hcmute.edu.vn.nhom07.foodyapp_group07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailDishActivity extends AppCompatActivity {

    private Button addCartBtn;
    private TextView textViewDishName, textViewSalePrice, textViewPrice, textViewMessage;
    private Button btnTru, btnCong, btnGiaTri, btnOrderNow;
    private ImageView imageViewDish;
    private FoodItems object;
    int numberOrder = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_dish);

//        addCartBtn = (Button) findViewById(R.id.btnAddToCart);
//        textViewDishName = (TextView) findViewById(R.id.textViewDishName);
//        textViewSalePrice = (TextView) findViewById(R.id.textViewSalePrice);
//        textViewPrice = (TextView) findViewById(R.id.textViewPrice);
//        textViewMessage = (TextView) findViewById(R.id.textViewMessage);
//
//        btnTru = (Button) findViewById(R.id.btnTru);
//        btnCong = (Button) findViewById(R.id.btnCong);
//        btnGiaTri = (Button) findViewById(R.id.btnGiaTri);
//        btnOrderNow = (Button) findViewById(R.id.btnOrderNow);
//
//        btnCong.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                numberOrder = numberOrder+1;
//                btnGiaTri.setText(String.valueOf(numberOrder));
//            }
//        });
//
//        btnTru.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(numberOrder > 1){
//                    numberOrder =  numberOrder-1;
//                }
//                btnGiaTri.setText(String.valueOf(numberOrder));
//            }
//        });
        
    }

}