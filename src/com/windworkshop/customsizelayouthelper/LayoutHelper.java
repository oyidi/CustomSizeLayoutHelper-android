package com.windworkshop.customsizelayouthelper;

import android.view.View;
import android.widget.RelativeLayout;

public class LayoutHelper {
	float screenWidth, screenHeight, maxFactorX, maxFactorY, perX, perY;
	public LayoutHelper(float screenWidth, float screenHright, float maxFactorX, float maxFactorY) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHright;
		this.maxFactorX = maxFactorX;
		this.maxFactorY = maxFactorY;
		perX = screenWidth / maxFactorX;
		perY = screenHright / maxFactorY;
	}
	
	public void resizeView(View view, float x, float y, float width, float height) {
		resizeView(view, x, y, width, height, CustomScaleType.Normal);
	}
	public void resizeView(View view, float width, float height) {
		int perWidth = (int)(width * perX);
		int perHeight = (int)(height * perY);
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(perWidth, perHeight);
		view.setLayoutParams(layoutParams);
	}
	public void resizeView(View view, float x, float y, float width, float height, CustomScaleType type) {
		
		int perWidth = (int)(width * perX);
		int perHeight = (int)(height * perY);
		if(type == CustomScaleType.Center) {
			if(perWidth > perHeight) {
				perWidth = perHeight;
			} else {
				perHeight = perWidth;
			}
		}
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(perWidth, perHeight);
		layoutParams.leftMargin = (int) (x * perX);
		layoutParams.topMargin = (int) (y * perY);
		view.setLayoutParams(layoutParams);
	}
	public enum LayoutSide {
		Normal, Center
	}
	public enum CustomScaleType {
		Normal, Center
	}
	/**
	 * �򲼾��в���ؼ�
	 * @param layout Ҫ����Ĳ���
	 * @param view Ҫ����Ŀؼ�
	 * @param width ����ؼ��Ŀ�ȣ��Ѵ������
	 * @param height ����ؼ��ĸ߶ȣ��Ѵ������
	 * @param left �����X��λ��
	 * @param top �����Y��λ��
	 */
	public void insertLayout(RelativeLayout layout, View view, float x, float y, float width, float height) {
		int perWidth = (int)(width * perX);
		int perHeight = (int)(height * perY);
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int)(perWidth), (int)(perHeight));
		layoutParams.leftMargin = (int) (x * perX);
		layoutParams.topMargin = (int) (y * perY);
		layout.addView(view, layoutParams);
	}
	public float getPerX() {
		return perX;
	}
	public float getPerY() {
		return perY;
	}
}

