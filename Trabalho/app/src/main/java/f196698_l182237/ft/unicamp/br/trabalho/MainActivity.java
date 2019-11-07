package f196698_l182237.ft.unicamp.br.trabalho;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;

import f196698_l182237.ft.unicamp.br.trabalho.interfaces.OnCadastroRequest;
import f196698_l182237.ft.unicamp.br.trabalho.login.SignInActivity;
import f196698_l182237.ft.unicamp.br.trabalho.pedidos.PedidosFragment;
import f196698_l182237.ft.unicamp.br.trabalho.cadastroProduto.CadastraProdutoFragment;
import f196698_l182237.ft.unicamp.br.trabalho.produtos.ProdutosFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fragmentManager;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            InicioFragment f1 = new InicioFragment();
            fragmentTransaction.add(R.id.frame, f1, "f1_tag");
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Fragment inicioFragment = fragmentManager.findFragmentByTag("inicio");
            if (inicioFragment == null) {
                inicioFragment = new InicioFragment();
            }
            replaceFragment(inicioFragment, "inicio");
        } else if (id == R.id.nav_produtos) {
            Fragment produtosFragment = fragmentManager.findFragmentByTag("produtos");
            if (produtosFragment == null) {
                produtosFragment = new ProdutosFragment();
                ((ProdutosFragment) produtosFragment).setOnCadastroRequest(new OnCadastroRequest() {
                    @Override
                    public void onRequest(int position) {
                        CadastraProdutoFragment cadastraProdFragment = (CadastraProdutoFragment) fragmentManager.findFragmentByTag("cadastroProd");
                        if (cadastraProdFragment == null) {
                            cadastraProdFragment = new CadastraProdutoFragment();
                        }
                        cadastraProdFragment.setIndice(position);
                        replaceFragment(cadastraProdFragment, "cadastroProd");
                    }
                });
            }
            replaceFragment(produtosFragment, "produtos");
        } else if (id == R.id.nav_pedidos) {
            Fragment pedidosFragment = fragmentManager.findFragmentByTag("pedidos");
            if (pedidosFragment == null) {
                pedidosFragment = new PedidosFragment();
            }
            replaceFragment(pedidosFragment, "pedidos");
        } else if (id == R.id.nav_local) {
            Fragment localFragment = fragmentManager.findFragmentByTag("local");
            if (localFragment == null) {
                localFragment = new LocalFragment();
            }
            replaceFragment(localFragment, "local");
        } else if (id == R.id.nav_logout) {
//            startActivity(new Intent(this, SignInActivity.class));
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();

        if (mFirebaseUser == null) {
            // Not signed in, launch the Sign In activity
            startActivity(new Intent(this, SignInActivity.class));
        } else {
            // Adicionar o codigo apos logado aqui.
        }

    }

    public void replaceFragment(Fragment fragment, String tag){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
