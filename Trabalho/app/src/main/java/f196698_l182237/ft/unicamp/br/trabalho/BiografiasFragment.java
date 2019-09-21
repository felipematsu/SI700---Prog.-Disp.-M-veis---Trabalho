package f196698_l182237.ft.unicamp.br.trabalho;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import f196698_l182237.ft.unicamp.br.trabalho.alunos.Aluno;
import f196698_l182237.ft.unicamp.br.trabalho.alunos.Alunos;


/**
 * A simple {@link Fragment} subclass.
 */
public class BiografiasFragment extends Fragment {

    private int indice;
    private View view;
    private ImageView imageView;
    private TextView txtNome;
    private TextView txtDesc;
    private Button botaoAnt;
    private Button botaoProx;
    private ArrayList<Aluno> alunos;

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public void setAlunos(ArrayList alunos) {
        this.alunos = alunos;
    }

    public BiografiasFragment() {
        this.indice = 0;
        this.alunos = new ArrayList<>(Arrays.asList(Alunos.alunos));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_biografias, container, false);
        }

        imageView = view.findViewById(R.id.imagemBiografia);
        txtNome = view.findViewById(R.id.nomeBiografia);
        txtDesc = view.findViewById(R.id.descBiografia);
        botaoAnt = view.findViewById(R.id.botaoAntes);
        botaoProx = view.findViewById(R.id.botaoDepois);

        botaoAnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anterior();
            }
        });

        botaoProx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proximo();
            }
        });

        displayAluno();

        return view;
    }

    public void displayAluno() {
        Aluno aluno = Alunos.alunos[indice];
        imageView.setImageResource(aluno.getFoto());
        txtNome.setText(aluno.getNome());
        txtDesc.setText(Html.fromHtml(aluno.getDescricao()));
    }

    @Override
    public void onStart() {
        super.onStart();
        displayAluno();
    }

    public void proximo() {
        this.indice = (this.indice + 1) % Alunos.alunos.length;
        this.displayAluno();
    }

    public void anterior() {
        this.indice = (this.indice - 1) % Alunos.alunos.length;
        if (this.indice < 0) {
            this.indice = Alunos.alunos.length - 1;
        }
        this.displayAluno();
    }
}
