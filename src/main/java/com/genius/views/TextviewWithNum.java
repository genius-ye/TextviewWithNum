package com.genius.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;

import com.vshidai.textviewwithnum.R;

/**
 *
 * 带数字提示的textview
 *
 * Created by genius-ye on 2016/3/30.
 *
 * modify at 2017-12-19 16:21:35
 */
public class TextviewWithNum extends android.support.v7.widget.AppCompatTextView {
    private String TAG = "TextviewWithNum";
    /**
     * 文字区域
     **/
    private Rect rectNum;
    /**
     * 消息数目字符串
     **/
    private String num = "99";
    /**
     * 内容
     **/
    private String content;
    /**
     * 内容区域
     **/
    private Rect rectContent;
    /**
     * 文字与消息数目之间的间距
     **/
    private int discount = 10;
    /**
     * 画笔
     **/
    private Paint paint;
    /**
     * 圆形半径
     **/
    private int radius = 20;

    /**
     * 是否显示数目
     **/
    private boolean isShow = true;
    /**
     * 圆内文字的大小(默认是文字的大小)
     */
    private float circletextsize = 24;

    public TextviewWithNum(Context context) {
        super(context);
        init();

    }

    public TextviewWithNum(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        TypedArray typedArray = context.obtainStyledAttributes(attrs , R.styleable.TextviewWithNum);
        radius = typedArray.getInt(R.styleable.TextviewWithNum_circle_radius,20);
        circletextsize = typedArray.getFloat(R.styleable.TextviewWithNum_circle_textsize,getTextSize());
        discount = typedArray.getInt(R.styleable.TextviewWithNum_discount,10);
    }

    public TextviewWithNum(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);// 抗锯齿
        if (num.length() > 2) {
            num = "···";
        }

        content = getText().toString();
        Log.d(TAG, "content=" + content);
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        paint.setColor(getCurrentTextColor());
        Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();
        paint.setTextSize(getTextSize());
        //文字垂直居中
        int baseline = (getHeight() - fontMetrics.bottom - fontMetrics.top) / 2;
        canvas.drawText(content, 0, baseline, paint);
        if (isShow) {
            paint.setColor(Color.RED);
            //绘制圆形
            canvas.drawCircle(getWidth() - radius, radius, radius, paint);
            paint.setColor(Color.WHITE);
            paint.setTextSize(circletextsize);
            int y = (radius*2-rectNum.height())/2+rectNum.height();
            canvas.drawText(num, getWidth() - radius*2 + (radius*2-rectNum.width())/2, y, paint);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        content = getText().toString();
        paint.setTextSize(getTextSize());
        rectContent = getTextArea(content);
        paint.setTextSize(circletextsize);
        rectNum = getTextArea(num);
        if (isShow) {
            setMeasuredDimension(rectContent.width() + radius * 2 + discount, rectContent.height() + rectNum.height());
        } else {
            setMeasuredDimension(rectContent.width(), rectContent.height() + rectNum.height());
        }

    }


    /**
     * 获取文字的区域
     */
    private Rect getTextArea(String str) {
        //2. 计算文字所在矩形，可以得到宽高
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect;
    }

    /**
     * 获取数目
     *
     * @return
     */
    public String getNum() {
        return num;
    }

    /**
     * 设置数目
     *
     * @param num
     */
    public void setNum(String num) {
        if (num.length() > 2) {
            num = "···";
        }
        rectNum = getTextArea(num);
        this.num = num;
    }

    /**
     * 获取红色圆圈的半径
     *
     * @return
     */
    public int getRadius() {
        return radius;
    }

    /**
     * 设置红色圆圈的半径
     *
     * @param radius
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * 文字与消息数目之间的间距
     *
     * @return
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * 文字与消息数目之间的间距
     *
     * @param discount
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    /**
     * 是否显示数字
     *
     * @return
     */
    public boolean isShow() {
        return isShow;
    }

    /**
     * 是否显示数字
     *
     * @return
     */
    public void setShow(boolean show) {
        isShow = show;
    }

    /**
     * 设置圆内文字大小
     * @param circletextsize
     */
    public void setCircletextsize(float circletextsize) {
        this.circletextsize = circletextsize;
    }
}
