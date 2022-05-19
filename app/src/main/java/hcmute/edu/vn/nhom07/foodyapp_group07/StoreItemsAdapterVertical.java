package hcmute.edu.vn.nhom07.foodyapp_group07;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StoreItemsAdapterVertical extends RecyclerView.Adapter<StoreItemsAdapterVertical.DataViewHolder>{

    private List<StoreItems> storeItems;
    private Context context;

    public StoreItemsAdapterVertical(Context context, List<StoreItems> storeItems) {
        this.storeItems = storeItems;
        this.context = context;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemViews;
        itemViews = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_food_items_vertical, parent, false);
        return new DataViewHolder(itemViews);
    }


    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        String name = storeItems.get(position).getStoreName();
        String img = storeItems.get(position).getStoreImg();
        double rate = storeItems.get(position).getStoreRate();
        int reviews = storeItems.get(position).getStoreReviews();
        String address = storeItems.get(position).getStoreAddress();
        Double distance = storeItems.get(position).getStoreDistance();

        holder.storeName.setText(name);

        int drawableId = context.getResources().getIdentifier(img, "drawable", context.getPackageName());
        holder.storeImg.setImageResource(drawableId);

        holder.storeRate.setText(String.valueOf(rate));
        holder.storeReviews.setText("(" + String.valueOf(reviews) + "+)");
        holder.storeAddress.setText(address);
        holder.storeDistance.setText(String.valueOf(distance) + "km");
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
        private TextView storeAddress;
        private TextView storeDistance;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            storeName = (TextView) itemView.findViewById(R.id.store_name);
            storeImg = (ImageView) itemView.findViewById(R.id.store_img);
            storeRate = (TextView) itemView.findViewById(R.id.store_rate);
            storeReviews = (TextView) itemView.findViewById(R.id.store_reviews);
            storeAddress = (TextView) itemView.findViewById(R.id.store_address);
            storeDistance = (TextView) itemView.findViewById(R.id.store_distance);
        }
    }
}
