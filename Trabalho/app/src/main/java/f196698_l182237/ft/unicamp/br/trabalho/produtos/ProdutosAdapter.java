package f196698_l182237.ft.unicamp.br.trabalho.produtos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import f196698_l182237.ft.unicamp.br.trabalho.R;

public class ProdutosAdapter extends RecyclerView.Adapter {

    private ArrayList<Produto> produtos;
    private MyOnItemClickListener myOnItemClickListener;

    public ProdutosAdapter(ArrayList produtos) { this.produtos = produtos;}

    public interface MyOnItemClickListener {
        void MyOnItemClick(int position);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_produtos, parent, false);
        final MyFirstViewHolder holder = new MyFirstViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myOnItemClickListener != null) {
                    myOnItemClickListener.MyOnItemClick(holder.position);
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Produto produto = produtos.get(position);
        ((MyFirstViewHolder)holder).onBind(produto);
        ((MyFirstViewHolder)holder).setPosition(position);
    }

    @Override
    public int getItemCount() {
        return this.produtos.size();
    }

    public void setMyOnItemClickListener (MyOnItemClickListener myOnItemClickListener) {
        this.myOnItemClickListener = myOnItemClickListener;
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

            NumberFormat reais = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            txtPrecoProd.setText(String.valueOf(reais.format(produto.getPreco())));
        }

    }
}
