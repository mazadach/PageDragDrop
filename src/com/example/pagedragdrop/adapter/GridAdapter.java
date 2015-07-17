package com.example.pagedragdrop.adapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.pagedragdrop.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {

	private Context context;
	private JSONArray jsonArray;

	public GridAdapter() {

	}

	public GridAdapter(Context context, JSONArray jsonArray) {
		this.context = context;
		this.jsonArray = jsonArray;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			LayoutInflater mInflater = LayoutInflater.from(context);
			convertView = mInflater.inflate(R.layout.grid_item, null);
			holder.textView = (TextView) convertView.findViewById(R.id.grid_item_text);
			holder.imageview = (ImageView) convertView.findViewById(R.id.grid_item_image);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		JSONObject obj;
		try {
			obj = jsonArray.getJSONObject(position);
			holder.imageview.setImageResource(Integer.parseInt(obj.getString("grid_img")));
			holder.textView.setText(obj.getString("grid_text"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return convertView;
	}

	@Override
	public int getCount() {
		return jsonArray.length();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	private class ViewHolder {
		ImageView imageview;
		TextView textView;
	}

}
