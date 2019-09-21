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

/**
 * A simple {@link Fragment} subclass.
 */
public class ProdutosFragment extends Fragment {

    private View view;
    private RecyclerView mRecyclerView;
    private MyFirstAdapter mAdapter;

    public ProdutosFragment() {
        // Required empty public constructor
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

        mAdapter = new MyFirstAdapter(new ArrayList(Arrays.asList(Produtos.produtos)));
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

}
