package com.example.pagedragdrop;


import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.pagedragdrop.adapter.GridAdapter;

import android.content.Context;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends BaseActivity {
	
	
	private Views views = new Views();
	private Context context;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		views.viewsInit();
	}


	class Views implements ViewsInterface{
		private GridView gridView;
		private GridAdapter gridAdapter;
		private JSONArray jsonArray;
		
		private String[] textStr = new String[]{
				"A","B","C","D","E"
		};

		@Override
		public void viewsInit() {
			findViews();
			setViews();
			setActions();
		}

		@Override
		public void findViews() {
			gridView = (GridView) findViewById(R.id.gridView1);
			gridAdapter = new GridAdapter();
			jsonArray = new JSONArray();
		}

		@Override
		public void setViews() {
			try {
				for (int i = 0; i < textStr.length; i++) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("grid_text", textStr[i]);
					jsonObject.put("grid_img",R.drawable.ic_btn);
					jsonArray.put(jsonObject);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			gridAdapter = new GridAdapter(context, jsonArray);
			gridView.setAdapter(gridAdapter);
			
		}

		@Override
		public void setActions() {
			
		}
		
	}
}
