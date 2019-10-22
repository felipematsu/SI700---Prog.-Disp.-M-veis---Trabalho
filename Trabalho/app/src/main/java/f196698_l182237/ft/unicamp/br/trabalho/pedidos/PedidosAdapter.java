package f196698_l182237.ft.unicamp.br.trabalho.pedidos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import f196698_l182237.ft.unicamp.br.trabalho.R;
import f196698_l182237.ft.unicamp.br.trabalho.produtos.MyFirstAdapter;

public class PedidosAdapter extends RecyclerView.Adapter {

    private ArrayList<Pedido> pedidos;
    private MyOnButtonClickListener myOnButtonClickListener;

    public interface MyOnButtonClickListener {
        void MyOnButtonClick();
    }

    public PedidosAdapter(ArrayList pedidos) {
        this.pedidos = pedidos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_pedidos, parent, false);
        final MyPedidoViewHolder holder = new MyPedidoViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Pedido pedido = pedidos.get(position);
        ((MyPedidoViewHolder)holder).onBind(pedido);
        ((MyPedidoViewHolder)holder).setPosition(position);
    }

    @Override
    public int getItemCount() {
        return this.pedidos.size();
    }

    public void setMyOnButtonClickListener (MyOnButtonClickListener myOnButtonClickListener) {
        this.myOnButtonClickListener = myOnButtonClickListener;
    }

    class MyPedidoViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewPedido;
        private TextView txtNomePedido;
        private TextView txtQtdePedido;
        private TextView txtTamPedido;
        private TextView txtValorPedido;
        private int position;

        public void setPosition(int position) {
            this.position = position;
        }

        public MyPedidoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageViewPedido = itemView.findViewById(R.id.imagePedido);
            this.txtNomePedido = itemView.findViewById(R.id.textNomePedido);
            this.txtQtdePedido = itemView.findViewById(R.id.textQtdePedido);
            this.txtTamPedido = itemView.findViewById(R.id.textTamPedido);
            this.txtValorPedido = itemView.findViewById(R.id.textPrecoTotal);
        }

        public void onBind(Pedido pedido) {
            imageViewPedido.setImageResource(pedido.getProduto().getFoto());
            txtNomePedido.setText(pedido.getProduto().getNome());
            txtQtdePedido.setText(pedido.getQuantidade());
            txtTamPedido.setText(pedido.getTamanho());
            txtValorPedido.setText(String.valueOf(pedido.getValorTotal()));
        }

    }
}
