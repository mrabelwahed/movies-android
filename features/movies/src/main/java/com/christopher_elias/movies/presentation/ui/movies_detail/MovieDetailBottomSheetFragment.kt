package com.christopher_elias.movies.presentation.ui.movies_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import coil.transform.RoundedCornersTransformation
import com.christopher_elias.movies.databinding.BottomFragmentMovieDetailBinding
import com.christopher_elias.movies.presentation.model.MovieUi
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/*
 * Created by Christopher Elias on 26/04/2021
 * christopher.mike.96@gmail.com
 *
 * Loop Ideas
 * Lima, Peru.
 */

class MovieDetailBottomSheetFragment : BottomSheetDialogFragment() {

    private val movie: MovieUi by lazy { requireArguments().getParcelable("movie")!! }

    private var _binding: BottomFragmentMovieDetailBinding? = null
    private val binding: BottomFragmentMovieDetailBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BottomFragmentMovieDetailBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderView()
        setClickListeners()
    }

    private fun renderView() {
        with(movie) {
            binding.tvMovieName.text = title
            binding.tvMovieOverview.text = overview
            binding.tvMovieReleaseDate.text = releaseDate
            binding.ivMoviePoster.load("https://image.tmdb.org/t/p/w500/$image") {
                crossfade(durationMillis = 1500)
                transformations(RoundedCornersTransformation(12.5f))
            }
        }
    }

    private fun setClickListeners() {
        binding.btnMoviePlay.setOnClickListener { }
        binding.tvMovieInfo.setOnClickListener { }
        binding.tvMovieDownload.setOnClickListener { }
        binding.tvMovieAdvance.setOnClickListener { }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}