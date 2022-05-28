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

public class HotDealStoreItemsAdapter extends RecyclerView.Adapter<HotDealStoreItemsAdapter.DataViewHolder> {

    private List<StoreItems> storeItems;
    private Context context;

    public HotDealStoreItemsAdapter(Context context, List<StoreItems> storeItems) {
        this.storeItems = storeItems;
        this.context = context;
    }

    @NonNull
    @Override
    public HotDealStoreItemsAdapter.DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemViews;
        itemViews = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_hot_deal_store_item, parent, false);
        return new HotDealStoreItemsAdapter.DataViewHolder(itemViews);

    }

    @Override
    public void onBindViewHolder(@NonNull HotDealStoreItemsAdapter.DataViewHolder holder, int position) {
        String name = storeItems.get(position).getStoreName();
        String img = storeItems.get(position).getStoreImg();
        double rate = storeItems.get(position).getStoreRate();
        int reviews = storeItems.get(position).getStoreReviews();
        Double distance = storeItems.get(position).getStoreDistance();

        holder.storeName.setText(name);

        int drawableId = context.getResources().getIdentifier(img, "drawable", context.getPackageName());
        holder.storeImg.setImageResource(drawableId);

        holder.storeRate.setText(String.valueOf(rate));
        holder.storeReviews.setText("(" + String.valueOf(reviews) + "+)");
        holder.storeDistance.setText(String.valueOf(distance) + "km");

        holder.cardViewHotFoodItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), StoreDetailActivity.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return storeItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {
        private TextView storeName;
        private ImageView storeImg;
        private TextView storeRate;
        private TextView storeReviews;
        private TextView storeDistance;
        private CardView cardViewHotFoodItem;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            storeName = (TextView) itemView.findViewById(R.id.store_name_h);
            storeImg = (ImageView) itemView.findViewById(R.id.store_img_h);
            storeRate = (TextView) itemView.findViewById(R.id.store_rate_h);
            storeReviews = (TextView) itemView.findViewById(R.id.store_reviews_h);
            storeDistance = (TextView) itemView.findViewById(R.id.store_distance_h);
            cardViewHotFoodItem = (CardView) itemView.findViewById(R.id.cardViewHotFoodItem);
        }
    }


}
