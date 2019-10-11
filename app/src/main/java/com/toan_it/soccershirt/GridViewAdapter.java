package com.toan_it.soccershirt;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GridViewAdapter extends BaseAdapter implements Filterable {

    //
        ArrayList<Shirt> orig;
    //
    ArrayList<Shirt> listData;
    int myLayout;
    LayoutInflater layoutInflater;
    Context context;

    public GridViewAdapter(Context aContext, int layout, ArrayList<Shirt> shirtArrayList) {
        this.context = aContext;
        this.myLayout = layout;
        this.listData = shirtArrayList;
        layoutInflater = LayoutInflater.from(aContext);
    }


    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                final FilterResults oReturn = new FilterResults();
                final ArrayList<Shirt> results = new ArrayList<Shirt>();
                if (orig == null)
                    orig = listData;
                if (constraint != null) {
                    if (orig != null && orig.size() > 0) {
                        for (final Shirt g : orig) {
                            if (g.getTenhinh().toLowerCase()
                                    .contains(constraint.toString()))
                                results.add(g);
                        }
                    }
                    oReturn.values = results;
                }
                return oReturn;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint,
                                          FilterResults results) {
                listData = (ArrayList<Shirt>) results.values;
                notifyDataSetChanged();
            }
        };

    }

    static class ViewHolder {
        ImageView hinh;
        TextView tenhinh;
        TextView nhanhieu;
        TextView gia;
        Button themvaogio;

    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.gridview_shirt, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.hinh = convertView.findViewById(R.id.hinh);
            viewHolder.tenhinh = convertView.findViewById(R.id.tenhinh);
            viewHolder.nhanhieu = convertView.findViewById(R.id.nhanhieu);
            viewHolder.gia = convertView.findViewById(R.id.gia);
            viewHolder.themvaogio = convertView.findViewById(R.id.themvaogio);

            convertView.setTag(viewHolder);


        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

        Shirt shirt = this.listData.get(position);
        viewHolder.tenhinh.setText(shirt.getTenhinh());
        viewHolder.nhanhieu.setText(shirt.getNhanhieu());
        viewHolder.gia.setText(shirt.getGia());

        int imageId = this.getMipmapResIdByName(shirt.getHinh());
        viewHolder.hinh.setImageResource(imageId);

        return convertView;
    }

    // Tìm ID của Image ứng với tên của ảnh (Trong thư mục mipmap).
    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();

        // Trả về 0 nếu không tìm thấy.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomGridView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }



}
