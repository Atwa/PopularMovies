

package ahmed.atwa.popularmovies.ui.main.home

import ahmed.atwa.popularmovies.data.api.Movie
import android.databinding.ObservableField

/**
 * Created by Ahmed Atwa on 10/19/18.
 */

class MovieItemViewModel(var movie: Movie, var mListener: MovieItemViewModelListener) {

    var imageUrl: ObservableField<String> = ObservableField(movie.poster_path)

    fun onItemClick() {
        mListener.onItemClick(movie)
    }


    interface MovieItemViewModelListener {
        fun onItemClick(movie: Movie)
    }
}