package SearchTask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.daclink.drew.sp22.cst438_project01_starter.R;
import com.daclink.drew.sp22.cst438_project01_starter.databinding.FragmentSearchBinding;

public class SearchFragment extends Fragment {
    private EditText searched;

    private Button mSearchButton;

    private String lyrics;

    private FragmentSearchBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ){

        binding = FragmentSearchBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    private void searchDisplay(){
        searched = searched.findViewById(R.id.lyricText);

        mSearchButton = mSearchButton.findViewById(R.id.search_button);
    }

    private void getInfoLyrics(){
        lyrics = searched.getText().toString();
    }

}
