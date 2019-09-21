package f196698_l182237.ft.unicamp.br.trabalho.produtos;

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

public class MyFirstAdapter extends RecyclerView.Adapter {

    private ArrayList<Produto> produtos;

    public MyFirstAdapter(ArrayList produtos) { this.produtos = produtos;}


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_layout, parent, false);
        return new MyFirstViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Produto produto = produtos.get(position);
        ((MyFirstViewHolder)holder).onBind(produto);
    }

    @Override
    public int getItemCount() {
        return this.produtos.size();
    }

    class MyFirstViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView txtNomeProd;
        private TextView txtDescProd;
        private TextView txtPrecoProd;
        private int position;

        public void setPosition(int position) { this.position = position; }

        public MyFirstViewHolder(final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageProd);
            txtNomeProd= itemView.findViewById(R.id.textNomeProd);
            txtDescProd = itemView.findViewById(R.id.textDescProd);
            txtPrecoProd = itemView.findViewById(R.id.textPrecoUnitProd);
        }

        public void onBind(Produto produto) {
            imageView.setImageResource(produto.getFoto());
            txtNomeProd.setText(produto.getNome());
            txtDescProd.setText(produto.getDescricao());
            txtPrecoProd.setText("R$" + String.valueOf(produto.getPreco()));
        }

    }
}
