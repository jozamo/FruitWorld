package com.jozamo74.seccion_02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import static com.jozamo74.seccion_02.R.id.textView;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> names;

    public MyAdapter(Context context, int layout, List<String> names){
        this.context = context;
        this.layout = layout;
        this.names = names;

    }

    @Override
    public int getCount() {
        return this.names.size();
    }

    @Override
    public Object getItem(int position) {
        return this.names.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //View Holder Pattern
        ViewHolder holder;

        if (convertView == null){
            //Inflamos la vista con nuestro layout personalizado
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout, null);

            holder = new ViewHolder();
            //Referenciamos elemento a modificar y rellenamos
            holder.nameTextView = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }



        //Nos traemos el valor actual dependiendo de la posición
        String currentName = names.get(position);

        //currentName = (String) getItem(position); los mismo q lo de arriba
        //Referencia al elemento a modificar y lo rellenamo
        holder.nameTextView.setText(currentName);
//        TextView textView = (TextView) view.findViewById(R.id.textView);
//        textView.setText(currentName);

        //devolvemos la vista inflada y modificada con nuestros datos
        return convertView;

    }

    static class ViewHolder {
        private TextView nameTextView;

    }
}
