package f196698_l182237.ft.unicamp.br.trabalho.cadastroProduto;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import f196698_l182237.ft.unicamp.br.trabalho.R;
import f196698_l182237.ft.unicamp.br.trabalho.comprador.Comprador;
import f196698_l182237.ft.unicamp.br.trabalho.interfaces.OnPedidosRequest;
import f196698_l182237.ft.unicamp.br.trabalho.pedidos.Pedido;
import f196698_l182237.ft.unicamp.br.trabalho.produtos.Produto;
import f196698_l182237.ft.unicamp.br.trabalho.produtos.Produtos;


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
    ArrayList<Pedido> pedidos;
    RecyclerView mRecyclerView;

    private DatabaseReference mFirebaseDatabaseReference;
    private FirebaseAuth mFirebaseAuth;
    private GoogleSignInAccount account;

    private OnPedidosRequest onPedidosRequest;

    public CadastraProdutoFragment() {
        this.indice = 0;
        this.produtos = new ArrayList<>(Arrays.asList(Produtos.produtos));
        this.pedidos = new ArrayList<>();
    }

    public void setOnPedidosRequest(OnPedidosRequest onPedidosRequest) {
        this.onPedidosRequest = onPedidosRequest;
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

        mFirebaseAuth = FirebaseAuth.getInstance();
        account = GoogleSignIn.getLastSignedInAccount(getContext());

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
        spinnerQtde.setOnItemSelectedListener(updateSpinner);

        displayProdCad();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        displayProdCad();
        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
    }

    public void displayProdCad() {
        Produto produto = Produtos.produtos[indice];
        imageView.setImageResource(produto.getFoto());
        txtNomeProd.setText(produto.getNome());
        txtDescProd.setText(produto.getDescricao());

        NumberFormat reais = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        txtPrecoTotal.setText(String.valueOf(reais.format(produto.getPreco())));
    }

    public View.OnClickListener checkBoxListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (editPersona.getVisibility() == View.INVISIBLE && checkPersona.isChecked()) {
                editPersona.setVisibility(view.VISIBLE);
            } else {
                editPersona.setVisibility(view.INVISIBLE);
                editPersona.setText("");
            }
        }
    };

    public AdapterView.OnItemSelectedListener updateSpinner = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            Produto produto = Produtos.produtos[indice];
            Double valorTotal = produto.getPreco() * (spinnerQtde.getSelectedItemPosition() + 1);
            if (!valorTotal.isNaN()) {
                NumberFormat reais = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                txtPrecoTotal.setText(reais.format(valorTotal));
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
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
            } else if (editCpfCompra.getText().length() != 0 && editCpfCompra.getText().length() < 11) {
                Toast.makeText(getActivity(), "CPF inválido, são necessários 11 digitos", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "Pedido Confirmado", Toast.LENGTH_SHORT).show();

                Produto produto = Produtos.produtos[indice];

                int quantidade = spinnerQtde.getSelectedItemPosition() + 1;

                boolean personalizacao = checkPersona.isChecked();
                String personalizacaoFrase = editPersona.getText().toString();

                int selectedTamanho = radioGroupTam.getCheckedRadioButtonId();
                RadioButton radioTam = radioGroupTam.findViewById(selectedTamanho);
                String tamanho = radioTam.getText().toString();

                Comprador comprador = new Comprador(editNomeCompra.getText().toString(), editCpfCompra.getText().toString());

                Pedido pedido = new Pedido(account.getEmail(), produto, quantidade, produto.getPreco() * quantidade, personalizacao, personalizacaoFrase, tamanho, comprador);

                mFirebaseDatabaseReference.child("pedidos").child(account.getEmail().replace(".", "_")).push().setValue(pedido);

                ((InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(editCpfCompra.getWindowToken(), 0);

                if(onPedidosRequest != null) {
                    onPedidosRequest.onRequest();
                }
            }
        }
    };


    @Override
    public void onPause() {
        super.onPause();
        editNomeCompra.setText("");
        editCpfCompra.setText("");
        editPersona.setText("");
        spinnerQtde.setSelection(0);
        radioGroupTam.clearCheck();
        checkPersona.setChecked(false);
        editPersona.setVisibility(view.INVISIBLE);
    }
}
