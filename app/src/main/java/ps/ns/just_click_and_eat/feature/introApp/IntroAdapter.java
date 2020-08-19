package ps.ns.just_click_and_eat.feature.introApp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.dataBase.IntroModel;

public class IntroAdapter extends PagerAdapter {

    private List<IntroModel> list;

    public IntroAdapter(List<IntroModel> list) {
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

        IntroModel model = list.get(position);
        ImageView imageViewIntro = view.findViewById(R.id.iv_intro);
        TextView titleIntro = view.findViewById(R.id.tv_title_into);
        TextView descriptionIntro = view.findViewById(R.id.tv_description_intro);

        imageViewIntro.setImageResource(model.getImageIntro());
        titleIntro.setText(model.getTitleIntro());
        descriptionIntro.setText(model.getDescriptionIntro());

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
