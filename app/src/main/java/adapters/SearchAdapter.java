package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import inventslab.hacareemps_2.R;
import models.SearchDropOfModel;

/**
 * Created by haier_1 on 4/29/2017.
 */

public class SearchAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<SearchDropOfModel> listItemStorage;
    public SearchAdapter(Context context, List<SearchDropOfModel> customizedListView) {
        layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listItemStorage = customizedListView;
    }
    public int getCount() {
        return listItemStorage.size();
    }
    @Override
    public Object getItem(int position) {
        return listItemStorage.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder listViewHolder;
        if(convertView == null){
            listViewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.item_list, parent, false);
            listViewHolder.dictionaryWord = (TextView)convertView.findViewById(R.id.list_item_search);
            convertView.setTag(listViewHolder);
        }else{
            listViewHolder = (ViewHolder)convertView.getTag();
        }
        listViewHolder.dictionaryWord.setText(listItemStorage.get(position).getDropoff());
        return convertView;
    }
    static class ViewHolder{
        TextView dictionaryWord;
    }
}
