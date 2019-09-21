package f196698_l182237.ft.unicamp.br.trabalho.alunos;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import f196698_l182237.ft.unicamp.br.trabalho.R;

public class MyFirstAdapter extends RecyclerView.Adapter {

    private ArrayList<Aluno> alunos;
    private MyOnItemClickListener myOnItemClickListener;
    // novo
    private MyOnItemLongClickListener myOnItemLongClickListener;

    public interface MyOnItemClickListener {
        void myOnItemClick(String nome);
    }

    // novo
    public interface MyOnItemLongClickListener {
        void myOnItemLongClick(int position);
    }

    public MyFirstAdapter(ArrayList alunos) {
        this.alunos = alunos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_layout, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myOnItemClickListener != null) {
                    TextView txt = view.findViewById(R.id.txtNome);
                    myOnItemClickListener.myOnItemClick(txt.getText().toString());
                }
            }
        });

        // novo - final
        final MyFirstViewHolder holder = new MyFirstViewHolder(view);

        // novo
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (myOnItemLongClickListener != null) {
                    myOnItemLongClickListener.myOnItemLongClick(holder.position);
                    return true;
                }
                return false;
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Aluno aluno = alunos.get(position);
        ((MyFirstViewHolder)holder).onBind(aluno);
        // novo
        ((MyFirstViewHolder) holder).setPosition(position);
//        ((MyFirstViewHolder)holder).onBind(alunos.get(position));
    }

    @Override
    public int getItemCount() {
        return alunos.size();
    }

    public void setMyOnItemClickListener(MyOnItemClickListener myOnItemClickListener) {
        this.myOnItemClickListener = myOnItemClickListener;
    }

    // novo
    public void setMyOnItemLongClickListener(MyOnItemLongClickListener myOnItemLongClickListener) {
        this.myOnItemLongClickListener = myOnItemLongClickListener;
    }

    class MyFirstViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView txtNome;
        private TextView txtDesc;
        private int position;

        // novo
        public void setPosition(int position) {
            this.position = position;
        }

        public MyFirstViewHolder(final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagem1);
            txtNome = itemView.findViewById(R.id.txtNome);
            txtDesc = itemView.findViewById(R.id.txtDesc);
        }

        public void onBind(Aluno aluno) {
            txtNome.setText(aluno.getNome());
            imageView.setImageResource(aluno.getFoto());
            txtDesc.setText(Html.fromHtml(aluno.getDescricao()));
        }

    }
}
