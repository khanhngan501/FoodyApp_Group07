package hcmute.edu.vn.nhom07.foodyapp_group07;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MonAnTrongGioHangAdapter extends BaseAdapter {


    Context myContext;
    int myLayout;
    List<MonAnTrongGioHang> arrayMonAnTrongGioHang;

    public MonAnTrongGioHangAdapter(Context context, int layout, List<MonAnTrongGioHang> monAnTrongGioHangList){
        myContext = context;
        myLayout = layout;
        arrayMonAnTrongGioHang = monAnTrongGioHangList;
    }

    @Override
    public int getCount() {
        return arrayMonAnTrongGioHang.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(myLayout, null);

        // Ánh xạ và gán giá trị

        TextView txtSL = (TextView) view.findViewById(R.id.textViewSL);
        txtSL.setText(arrayMonAnTrongGioHang.get(i).SL + "");

        TextView txtTenMon = (TextView) view.findViewById(R.id.textViewTenMon);
        txtTenMon.setText(arrayMonAnTrongGioHang.get(i).TenMon);

        TextView txtGia = (TextView) view.findViewById(R.id.textViewGia);
        txtGia.setText(arrayMonAnTrongGioHang.get(i).Gia + "");

        return view;
    }
}
