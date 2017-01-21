package com.windworkshop.customsizelayouthelper.sample;
import com.windworkshop.customsizelayouthelper.LayoutHelper;
import com.windworkshop.customsizelayouthelper.LayoutHelper.LayoutSide;
import com.windworkshop.customsizelayouthelper.LayoutHelper.CustomScaleType;
import com.windworkshop.customsizelayouthelper.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	LayoutHelper layouthelper;
	Button button1, button2, button3;
	TextView textView1;
	ImageView imageView1, imageView2, imageView3;
	RelativeLayout mainLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		layouthelper = new LayoutHelper(metrics.widthPixels, metrics.heightPixels, 1000, 1000);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		
		textView1 = (TextView) findViewById(R.id.textView1);
		
		imageView1 = (ImageView) findViewById(R.id.imageView1);
		imageView2 = (ImageView) findViewById(R.id.imageView2);
		
		int buton1Width = 200;
		layouthelper.resizeView(button1, 500 - buton1Width / 2, 0, buton1Width, 100);
		
		layouthelper.resizeView(button2, 700, 200, 150, 100);
		layouthelper.resizeView(button3, 700, 300, 150, 100);
		layouthelper.resizeView(textView1, 0, 700, 300, 100);
		
		layouthelper.resizeView(imageView1, 100, 400, 100, 100, CustomScaleType.Center);
		layouthelper.resizeView(imageView2, 100, 500, 100, 100);
		
		mainLayout = (RelativeLayout) findViewById(R.id.main_layout);
		imageView3 = new ImageView(getApplicationContext());
		imageView3.setImageResource(R.drawable.ic_launcher);
		imageView3.setBackgroundColor(Color.parseColor("#0000ff"));
		layouthelper.insertLayout(mainLayout, imageView3, 100, 600, 100, 100);
	}
}
