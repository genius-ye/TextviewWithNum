# 带未读消息的textview

### 效果：

> 不显示消息数目
![效果1](https://github.com/genius-ye/TextviewWithNum/blob/master/1.jpg?raw=true)

****

> 当消息数目大于99的时候自动变成...
![效果2](https://github.com/genius-ye/TextviewWithNum/blob/master/2.jpg?raw=true)

****

> 当消息的数目小于99的时候
![效果3](https://github.com/genius-ye/TextviewWithNum/blob/master/3.jpg?raw=true)

****

> 还可以自定义消息汽包和文本之间的距离
![效果4](https://github.com/genius-ye/TextviewWithNum/blob/master/3.png?raw=true)

### 使用方法：

> 先将库导入到项目中去，然后就和正常的textview一样使用
> ```xml
>       <com.genius.views.TextviewWithNum
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="带数目的textview"/>
  ```
### 部分api：

```java
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
```