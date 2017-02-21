package yaro.quickomdb.service;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import yaro.quickomdb.model.Movie;

/**
 * Created by yann on 21/02/17.
 */

public interface OmdbService {

    class OmdbSearchResponse {
        @SerializedName("Search")
        public List<Movie> search;

        public int totalResults;

        @SerializedName("Response")
        public boolean response;

        @Override
        public String toString() {
            return "OmdbSearchResponse{" +
                    "search=" + search +
                    ", totalResults=" + totalResults +
                    ", response=" + response +
                    '}';
        }
    }

    @GET("?type=movie&r=json&page=1")
    Call<OmdbSearchResponse> searchMovies(@Query("s") String search);

    @GET("?type=movie&plot=long&r=json&tomatoes=true")
    Call<Movie> findMovieById(@Query("i") String imdbId);
}

