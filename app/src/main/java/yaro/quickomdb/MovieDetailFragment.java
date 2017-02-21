package yaro.quickomdb;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import yaro.quickomdb.dummy.DummyContent;
import yaro.quickomdb.model.Movie;

public class MovieDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";
    private Movie mItem;

    public MovieDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            String id = getArguments().getString(ARG_ITEM_ID);
            mItem = DummyContent.ITEM_MAP.get(id);

            Activity activity = this.getActivity();
            Toolbar appBarLayout = (Toolbar) activity.findViewById(R.id.toolbar);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getTitle());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.movie_detail, container, false);

        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.titleTextView)).setText(mItem.getTitle());
            ((TextView) rootView.findViewById(R.id.plotTextView)).setText("not done yet");

            Glide.with(rootView.getContext())
                .load(mItem.getPoster())
                .centerCrop()
                .crossFade()
                .into(((ImageView) rootView.findViewById(R.id.posterImageView)));
        }

        return rootView;
    }
}
