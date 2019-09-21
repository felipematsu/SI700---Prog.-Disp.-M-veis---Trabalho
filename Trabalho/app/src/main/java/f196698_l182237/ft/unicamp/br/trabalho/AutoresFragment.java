package f196698_l182237.ft.unicamp.br.trabalho;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AutoresFragment extends Fragment {

    String mensagem = "Conteúdo da Mensagem";
    ImageView imagem1;
    ImageView imagem2;
    TextView textViewConteudo;
    TextView textViewNome1;
    TextView textViewNome2;
    TextView textViewBiografia1;
    TextView textViewBiografia2;
    TextView textViewRa1;
    TextView textViewRa2;
    View view;


    public AutoresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_autores, container, false);
        }

        imagem1 = view.findViewById(R.id.felipeFoto);
        imagem2 = view.findViewById(R.id.luanFoto);
        textViewNome1 = view.findViewById(R.id.nome1);
        textViewNome2 = view.findViewById(R.id.nome2);
        textViewBiografia1 = view.findViewById(R.id.biografia1);
        textViewBiografia2 = view.findViewById(R.id.biografia2);
        textViewRa1 = view.findViewById(R.id.ra1);
        textViewRa2 = view.findViewById(R.id.ra2);
        textViewConteudo = view.findViewById(R.id.conteudoEmailLabel);
        textViewConteudo.setText(mensagem);

        return view;
    }

    public void onStart(){
        super.onStart();
        textViewConteudo.setText(this.mensagem);
    }

    public void setText(String mensagem) {
        this.mensagem = mensagem;
    }

}
