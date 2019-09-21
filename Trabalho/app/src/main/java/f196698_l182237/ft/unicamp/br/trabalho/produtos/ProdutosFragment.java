package f196698_l182237.ft.unicamp.br.trabalho.produtos;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
    private FragmentManager fragmentManager;


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

        mAdapter.setMyOnItemClickListener(new MyFirstAdapter.MyOnItemClickListener() {
            @Override
            public void MyOnItemClick(String nome, String desc, String preco) {
//                Fragment cadastraProdutoFragment = fragmentManager.findFragmentByTag("cadastraProduto");
//                if (cadastraProdutoFragment == null) {
//                    cadastraProdutoFragment = new CadastraProdutoFragment();
//                }
//                Toast.makeText(getActivity(), nome + desc + preco, Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

}
