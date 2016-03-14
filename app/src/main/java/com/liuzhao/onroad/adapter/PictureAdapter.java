package com.liuzhao.onroad.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.liuzhao.onroad.R;
import com.liuzhao.onroad.entity.JokeBean;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * Created by liuzhao on 2016/3/11.
 */
public class PictureAdapter extends BaseListAdapter<JokeBean> {
    private ImageOptions imageOptions;

    public PictureAdapter(Context context, List<JokeBean> values) {
        super(context, values);
        imageOptions = new ImageOptions.Builder()
                // 加载中或错误图片的ScaleType
                //.setPlaceholderScaleType(ImageView.ScaleType.MATRIX)
                // 默认自动适应大小
                // .setSize(...)
                .setSize(200, 200)
                .setIgnoreGif(true)
                .setImageScaleType(ImageView.ScaleType.MATRIX).build();
    }

    @Override
    protected View getItemView(View convertView, int position) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.adapter_picture, null);
        }
        ImageView iv_gif = ViewHolder.get(convertView, R.id.iv_gif);

        x.image().bind(iv_gif, mValues.get(position).getUrl(), imageOptions);
        return convertView;
    }
}
