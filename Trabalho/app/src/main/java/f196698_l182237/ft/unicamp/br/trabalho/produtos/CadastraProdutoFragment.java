package f196698_l182237.ft.unicamp.br.trabalho.produtos;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import f196698_l182237.ft.unicamp.br.trabalho.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CadastraProdutoFragment extends Fragment {

    View view;
    ImageView imageView;
    TextView txtNomeProd;
    TextView txtDescProd;
    TextView txtPrecoProd;


    public CadastraProdutoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_cadastra_produto, container, false);
        }



        return view;
    }

}
