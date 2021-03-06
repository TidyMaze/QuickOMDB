package yaro.quickomdb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import yaro.quickomdb.model.Movie;
import yaro.quickomdb.service.OmdbService;

import java.util.ArrayList;
import java.util.List;

public class MovieListActivity extends AppCompatActivity {

    private boolean mTwoPane;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        recyclerView = (RecyclerView) findViewById(R.id.movie_list);
        ((RecyclerView) recyclerView).setAdapter(new SimpleItemRecyclerViewAdapter(new ArrayList<Movie>()));

        if (findViewById(R.id.movie_detail_container) != null) {
            mTwoPane = true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fetchMoviesAndShow(recyclerView, newText);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void fetchMoviesAndShow(@NonNull final RecyclerView recyclerView, @NonNull String search) {
        Log.i("Service", "Fetching movies from query : \"" + search + "\"");

        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        OmdbService service = retrofit.create(OmdbService.class);
        Call<OmdbService.OmdbSearchResponse> moviesCall = service.searchMovies(search);
        moviesCall.enqueue(new Callback<OmdbService.OmdbSearchResponse>() {
            @Override
            public void onResponse(Call<OmdbService.OmdbSearchResponse> call, Response<OmdbService.OmdbSearchResponse> response) {
                if(response.body().response) {
                    List<Movie> items = response.body().search;
                    Log.d("response body", response.body().toString());
                    Log.d("items", items.toString());
                    recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(items));
                } else {
                    Log.e("Service","Error on fetching movies");
                }
            }

            @Override
            public void onFailure(Call<OmdbService.OmdbSearchResponse> call, Throwable t) {
                Log.e("service","Failure getting movies",t);
            }
        });
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<Movie> mValues;

        public SimpleItemRecyclerViewAdapter(List<Movie> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mTitleView.setText(holder.mItem.getTitle());


            Glide.with(MovieListActivity.this)
                .load(holder.mItem.getPoster())
                .crossFade()
                .into(holder.mPosterView);

            holder.mView.setOnClickListener(v -> {
                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(MovieDetailFragment.ARG_ITEM_ID, holder.mItem.getImdbId());
                    MovieDetailFragment fragment = new MovieDetailFragment();
                    fragment.setArguments(arguments);
                    getSupportFragmentManager().beginTransaction()
                        .replace(R.id.movie_detail_container, fragment)
                        .commit();
                } else {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MovieDetailActivity.class);
                    intent.putExtra(MovieDetailFragment.ARG_ITEM_ID, holder.mItem.getImdbId());
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final ImageView mPosterView;
            public final TextView mTitleView;
            public Movie mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mPosterView = (ImageView) view.findViewById(R.id.posterImageView);
                mTitleView = (TextView) view.findViewById(R.id.titleTextView);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mTitleView.getText() + "'";
            }
        }
    }
}
