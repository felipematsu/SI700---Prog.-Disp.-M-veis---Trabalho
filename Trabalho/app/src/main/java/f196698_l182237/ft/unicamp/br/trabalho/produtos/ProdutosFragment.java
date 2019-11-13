package f196698_l182237.ft.unicamp.br.trabalho.produtos;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;

import f196698_l182237.ft.unicamp.br.trabalho.R;
import f196698_l182237.ft.unicamp.br.trabalho.interfaces.OnCadastroRequest;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProdutosFragment extends Fragment {

    private View view;
    private RecyclerView mRecyclerView;
    private ProdutosAdapter mAdapter;
    private OnCadastroRequest onCadastroRequest;


    public ProdutosFragment() {
        // Required empty public constructor
    }

    public void setOnCadastroRequest(OnCadastroRequest onCadastroRequest) {
        this.onCadastroRequest = onCadastroRequest;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_produtos, container, false);
        }

        mRecyclerView = view.findViewById(R.id.recyclerViewProd);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager((getActivity())));

        mAdapter = new ProdutosAdapter(new ArrayList(Arrays.asList(Produtos.produtos)));
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setMyOnItemClickListener(new ProdutosAdapter.MyOnItemClickListener() {
            @Override
            public void MyOnItemClick(int position) {
                if (onCadastroRequest != null) {
                    onCadastroRequest.onRequest(position);
                }
            }
        });

        return view;
    }

}
