package yaro.quickomdb;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import yaro.quickomdb.model.Movie;
import yaro.quickomdb.service.OmdbService;

public class MovieDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";
    private Movie mItem;
    private View rootView;

    public MovieDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            String id = getArguments().getString(ARG_ITEM_ID);
            Log.i("Detail imdbId", id);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://www.omdbapi.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            OmdbService service = retrofit.create(OmdbService.class);
            Call<Movie> moviesCall = service.findMovieById(id);
            moviesCall.enqueue(new Callback<Movie>() {
                @Override
                public void onResponse(Call<Movie> call, Response<Movie> response) {
                    Movie item = response.body();
                    Log.d("response body", response.body().toString());
                    Log.d("item", item.toString());
                    mItem = item;

                    ((TextView) rootView.findViewById(R.id.plotTextView)).setText(mItem.getPlot());
                    ((TextView) rootView.findViewById(R.id.yearTextView)).setText(Integer.toString(mItem.getYear()));
                    ((TextView) rootView.findViewById(R.id.releasedTextView)).setText(mItem.getReleased());
                    ((TextView) rootView.findViewById(R.id.runtimeTextView)).setText(mItem.getRuntime());
                    ((TextView) rootView.findViewById(R.id.directorTextView)).setText(mItem.getDirector());
                    ((TextView) rootView.findViewById(R.id.writerTextView)).setText(mItem.getWriter());
                    ((TextView) rootView.findViewById(R.id.actorsTextView)).setText(mItem.getActors());
                    ((TextView) rootView.findViewById(R.id.productionTextView)).setText(mItem.getProduction());
                    ((TextView) rootView.findViewById(R.id.awardsTextView)).setText(mItem.getAwards());
                    ((TextView) rootView.findViewById(R.id.metascoreTextView)).setText(mItem.getMetascore());
                    ((TextView) rootView.findViewById(R.id.imdbRatingTextView)).setText(Float.toString(mItem.getImdbRating()));
                    ((TextView) rootView.findViewById(R.id.tomatoTextView)).setText(String.format("Pro : %s%% - %s/10, User : %s%% - %s/10",
                            mItem.getTomatoMeter(),
                            mItem.getTomatoRating(),
                            mItem.getTomatoUserMeter(),
                            mItem.getTomatoUserRating()
                    ));
                    ((TextView) rootView.findViewById(R.id.tomatoConsensusTextView)).setText(mItem.getTomatoConsensus());
                    ((TextView) rootView.findViewById(R.id.boxOfficeTextView)).setText(mItem.getBoxOffice());
                    ((TextView) rootView.findViewById(R.id.websiteTextView)).setText(mItem.getWebsite());

                    Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_detail);
                    if(toolbar != null){
                        toolbar.setTitle(mItem.getTitle());
                    }

                    Glide.with(rootView.getContext())
                        .load(mItem.getPoster())
                        .crossFade()
                        .into(((ImageView) rootView.findViewById(R.id.posterImageView)));
                }

                @Override
                public void onFailure(Call<Movie> call, Throwable t) {
                    Log.e("service","Failure getting movie",t);
                }
            });
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.movie_detail, container, false);
        return rootView;
    }
}
