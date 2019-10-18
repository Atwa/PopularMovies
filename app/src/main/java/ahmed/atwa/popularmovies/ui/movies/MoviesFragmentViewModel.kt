package ahmed.atwa.popularmovies.ui.movies

import ahmed.atwa.popularmovies.data.model.Movie
import ahmed.atwa.popularmovies.data.repository.MovieRepository
import ahmed.atwa.popularmovies.ui.base.BaseViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Ahmed Atwa on 10/19/18.
 */

class MoviesFragmentViewModel @Inject constructor(val movieRepository: MovieRepository) : BaseViewModel(movieRepository) {

    var movieListLiveData = MutableLiveData<List<Movie>>()

    init {
        isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            fetchMoviesLocal()
            isLoading.postValue(false)
            fetchMoviesRemote()
        }
    }

    private fun storeMoviesLocal(results: List<Movie>) {
        if (results.isNotEmpty())
            movieListLiveData.postValue(movieRepository.syncFavWithDb(results))
    }

    private suspend fun fetchMoviesRemote() = storeMoviesLocal(movieRepository.fetchMoviesApiCall())

    private fun fetchMoviesLocal() = movieListLiveData.postValue(movieRepository.fetchMoviesLocal())


}