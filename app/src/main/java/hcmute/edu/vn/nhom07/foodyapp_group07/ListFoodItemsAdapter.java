package hcmute.edu.vn.nhom07.foodyapp_group07;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListFoodItemsAdapter extends RecyclerView.Adapter<ListFoodItemsAdapter.DataViewHolder> {

    private List<FoodItems> foodItems;
    private Context context;

    public static final int TYPE1 = 1;
    public static final int TYPE2 = 0;

    public ListFoodItemsAdapter(Context context, List<FoodItems> foodItems) {
        this.foodItems = foodItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ListFoodItemsAdapter.DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemViews;
        itemViews = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list_deal_food_item, parent, false);


//        switch (viewType) {
//            case 1:
//                itemViews = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list_deal_food_item, parent, false);
//                break;
//            case 2:
//                itemViews = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list_food_item, parent, false);
//                break;
//            default:
//                itemViews = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list_food_item, parent, false);
//                break;
//        }

        return new ListFoodItemsAdapter.DataViewHolder(itemViews);
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

        holder.cardViewFoodItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailDishActivity.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (foodItems.get(position).getIsDeal()) return 1;
        else return 2;
    }


    public static class DataViewHolder extends RecyclerView.ViewHolder {
        private TextView foodName;
        private ImageView foodImg;
        private TextView foodSalePercent;
        private TextView foodNormalPrice;
        private TextView foodSalePrice;
        private CardView cardViewFoodItem;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName = (TextView) itemView.findViewById(R.id.food_name);
            foodImg = (ImageView) itemView.findViewById(R.id.food_img);
            foodSalePercent = (TextView) itemView.findViewById(R.id.food_sale_percent);
            foodNormalPrice = (TextView) itemView.findViewById(R.id.food_normal_price);
            foodSalePrice = (TextView) itemView.findViewById(R.id.food_sale_price);
            cardViewFoodItem = (CardView) itemView.findViewById(R.id.cardViewFoodItem);
        }
    }

}
