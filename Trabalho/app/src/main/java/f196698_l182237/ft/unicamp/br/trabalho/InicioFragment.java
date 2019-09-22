package f196698_l182237.ft.unicamp.br.trabalho;


import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment {

    View view;
//    ImageView imageView;

    public InicioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_inicio, container, false);
        }

//        imageView = view.findViewById(R.id.imageLogoLoja);

//        imageView.setImageResource(R.drawable.logo_loja);

        return view;
    }


}
