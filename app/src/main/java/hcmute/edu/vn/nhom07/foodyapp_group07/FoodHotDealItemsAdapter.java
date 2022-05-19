package hcmute.edu.vn.nhom07.foodyapp_group07;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodHotDealItemsAdapter extends RecyclerView.Adapter<FoodHotDealItemsAdapter.DataViewHolder>{
    private List<FoodItems> foodItems;
    private Context context;

    public FoodHotDealItemsAdapter(Context context, List<FoodItems> foodItems) {
        this.foodItems = foodItems;
        this.context = context;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemViews;
        itemViews = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_hot_deal_food_items, parent, false);
        return new FoodHotDealItemsAdapter.DataViewHolder(itemViews);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        String name = foodItems.get(position).getFoodName();
        String img = foodItems.get(position).getFoodImg();
        int salePercent = foodItems.get(position).getFoodSalePercent();
        String normalPrice = foodItems.get(position).getFoodNormalPrice();
        String salePrice = foodItems.get(position).getFoodSalePrice();

        holder.foodName.setText(name);
        int drawableId = context.getResources().getIdentifier(img, "drawable", context.getPackageName());
        holder.foodImg.setImageResource(drawableId);
        holder.foodSalePercent.setText(String.valueOf(salePercent));
        holder.foodNormalPrice.setText(normalPrice);
        holder.foodSalePrice.setText(salePrice);


    }

    @Override
    public int getItemCount() {
        return foodItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        private TextView foodName;
        private ImageView foodImg;
        private TextView foodSalePercent;
        private TextView foodNormalPrice;
        private TextView foodSalePrice;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName = (TextView) itemView.findViewById(R.id.food_name);
            foodImg = (ImageView) itemView.findViewById(R.id.food_img);
            foodSalePercent = (TextView) itemView.findViewById(R.id.food_sale_percent);
            foodNormalPrice = (TextView) itemView.findViewById(R.id.food_normal_price);
            foodSalePrice = (TextView) itemView.findViewById(R.id.food_sale_price);
        }
    }
}
