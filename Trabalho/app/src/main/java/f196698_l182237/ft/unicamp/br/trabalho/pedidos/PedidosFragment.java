package f196698_l182237.ft.unicamp.br.trabalho.pedidos;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import f196698_l182237.ft.unicamp.br.trabalho.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PedidosFragment extends Fragment {

    private View view;
    private RecyclerView mRecyclerView;

    public PedidosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_pedidos, container, false);
        }

        mRecyclerView = view.findViewById(R.id.recyclerViewPedido);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager((getActivity())));

        return view;
    }

}
