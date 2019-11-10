package f196698_l182237.ft.unicamp.br.trabalho.pedidos;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.renderscript.Sampler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

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
    private TextView labelPedidos;

    public PedidosFragment() {
        // Required empty public constructor
    }

    public static class PedidosViewHolder extends RecyclerView.ViewHolder {

        ImageView imagePedido;
        TextView txtNomePedido;
        TextView txtQtdePedido;
        TextView txtTamanho;
        TextView txtValorTotal;

        public PedidosViewHolder(View itemView) {
            super(itemView);
            imagePedido = itemView.findViewById(R.id.imagePedido);
            txtNomePedido = itemView.findViewById(R.id.textNomePedido);
            txtQtdePedido = itemView.findViewById(R.id.textQtdePedido);
            txtTamanho = itemView.findViewById(R.id.textTamPedido);
            txtValorTotal = itemView.findViewById(R.id.textPrecoTotal);
        }
    }

    private DatabaseReference mFirebaseDatabaseReference;
    private FirebaseRecyclerAdapter<Pedido, PedidosViewHolder> mFirebaseAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_pedidos, container, false);
        }

        labelPedidos = view.findViewById(R.id.labelAquiPedidos);

        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
        SnapshotParser<Pedido> parser = new SnapshotParser<Pedido>() {
            @NonNull
            @Override
            public Pedido parseSnapshot(@NonNull DataSnapshot snapshot) {
                Pedido pedido = snapshot.getValue(Pedido.class);
                return pedido;
            }
        };

        DatabaseReference messagesRef = mFirebaseDatabaseReference.child("pedidos");
        FirebaseRecyclerOptions<Pedido> options = new FirebaseRecyclerOptions.Builder<Pedido>().setQuery(messagesRef, parser).build();
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Pedido, PedidosViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull PedidosViewHolder pedidosViewHolder, int i, @NonNull Pedido pedido) {
                pedidosViewHolder.txtNomePedido.setText(pedido.getProduto().getNome());
                pedidosViewHolder.txtValorTotal.setText("R$ " + String.valueOf(pedido.getValorTotal()));
                pedidosViewHolder.txtTamanho.setText(pedido.getTamanho());
                pedidosViewHolder.imagePedido.setImageResource(pedido.getProduto().getFoto());
                pedidosViewHolder.txtQtdePedido.setText(String.valueOf(pedido.getQuantidade()));
            }

            @NonNull
            @Override
            public PedidosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new PedidosViewHolder(inflater.inflate(R.layout.adapter_pedidos, parent, false));
            }
        };

        mRecyclerView = view.findViewById(R.id.recyclerViewPedido);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager((getActivity())));
        mRecyclerView.setAdapter(mFirebaseAdapter);

        mFirebaseAdapter.

        return view;
    }

    @Override
    public void onPause() {
        mFirebaseAdapter.stopListening();
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mFirebaseAdapter.startListening();
    }
}
