package f196698_l182237.ft.unicamp.br.trabalho.produtos;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

import f196698_l182237.ft.unicamp.br.trabalho.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CadastraProdutoFragment extends Fragment {

    View view;
    ImageView imageView;
    TextView txtNomeProd;
    TextView txtDescProd;
    TextView txtPrecoTotal;
    CheckBox checkPersona;
    EditText editPersona;
    EditText editNomeCompra;
    EditText editCpfCompra;
    Button buttonConfirma;
    RadioGroup radioGroupTam;
    Spinner spinnerQtde;
    private int indice;
    private ArrayList<Produto> produtos;


    public CadastraProdutoFragment() {
        this.indice = 0;
        this.produtos = new ArrayList<>(Arrays.asList(Produtos.produtos));
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_cadastra_produto, container, false);
        }

        imageView = view.findViewById(R.id.imageFotoCadastro);
        txtNomeProd = view.findViewById(R.id.textNomeCadasProd);
        txtDescProd = view.findViewById(R.id.textDescProduto);
        txtPrecoTotal = view.findViewById(R.id.textPrecoTotal);
        editPersona = view.findViewById(R.id.editPersonaliza);
        editNomeCompra = view.findViewById(R.id.editNomeComprador);
        editCpfCompra = view.findViewById(R.id.editCpfComprador);
        checkPersona = view.findViewById(R.id.checkPersonaliza);
        buttonConfirma = view.findViewById(R.id.buttonConfirma);
        radioGroupTam = view.findViewById(R.id.radioGTamanho);
        spinnerQtde = view.findViewById(R.id.spinnerQtde);

        checkPersona.setOnClickListener(checkBoxListener);
        buttonConfirma.setOnClickListener(verificaCampos);

        displayProdCad();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        displayProdCad();
    }

    public void displayProdCad() {
        Produto produto = Produtos.produtos[indice];
        imageView.setImageResource(produto.getFoto());
        txtNomeProd.setText(produto.getNome());
        txtDescProd.setText(produto.getDescricao());
        txtPrecoTotal.setText("R$ " + String.valueOf(produto.getPreco()));
    }

    public View.OnClickListener checkBoxListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (editPersona.getVisibility() == View.INVISIBLE) {
                editPersona.setVisibility(view.VISIBLE);
            } else {
                editPersona.setVisibility(view.INVISIBLE);
                editPersona.setText("");
            }
        }
    };

    public View.OnClickListener verificaCampos = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int selectedRadioItem = radioGroupTam.getCheckedRadioButtonId();

            if (selectedRadioItem <= 0) {
                Toast.makeText(getActivity(), "É preciso escolher um tamanho", Toast.LENGTH_SHORT).show();
            } else if (editPersona.getText().length() == 0 && editPersona.getVisibility() == View.VISIBLE) {
                Toast.makeText(getActivity(), "É preciso preencher o campo de personalização", Toast.LENGTH_SHORT).show();
            } else if (editNomeCompra.getText().length() == 0) {
                Toast.makeText(getActivity(), "Campo Nome obrigatório", Toast.LENGTH_SHORT).show();
            } else if (editCpfCompra.getText().length() == 0) {
                Toast.makeText(getActivity(), "Campo CPF obrigatório", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "Pedido Confirmado", Toast.LENGTH_SHORT).show();
            }
        }
    };

}
