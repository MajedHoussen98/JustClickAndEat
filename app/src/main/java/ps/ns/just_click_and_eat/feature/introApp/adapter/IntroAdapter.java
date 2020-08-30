package ps.ns.just_click_and_eat.feature.introApp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;

import java.util.List;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.network.asp.model.IntroApp;

public class IntroAdapter extends PagerAdapter {

    private Context context;
    private List<IntroApp> list;

    public IntroAdapter(Context context, List<IntroApp> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.intro_app_item, container, false);
        container.addView(view);

        IntroApp model = list.get(position);
        ImageView imageViewIntro = view.findViewById(R.id.iv_intro);
        TextView titleIntro = view.findViewById(R.id.tv_title_into);
        TextView descriptionIntro = view.findViewById(R.id.tv_description_intro);

        Glide.with(context).load(model.getImage()).into(imageViewIntro);
        titleIntro.setText(model.getTitle());
        descriptionIntro.setText(model.getDescription());

        ViewPager viewPager = (ViewPager) container;
        viewPager.removeView(view);
        viewPager.addView(view);

        return view;

    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
