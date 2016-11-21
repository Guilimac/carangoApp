package br.com.fiap.carango;

import android.graphics.drawable.Drawable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;

import br.com.fiap.carango.models.Carro;

public class DetalheActivity extends AppCompatActivity {


    private ImageView imagem;
    private TextView desc;
    private CollapsingToolbarLayout collapsingToolbar;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        imagem = (ImageView)findViewById(R.id.imagem);
        desc = (TextView)findViewById(R.id.desc);
        if(getIntent() != null) {
            Carro carro = (Carro)getIntent().getParcelableExtra("carro");
            Picasso.with(this)
                    .load(carro.getFoto())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(imagem);
            collapsingToolbar.setTitle(carro.getNome());
            desc.setText(carro.getDescricao());
        }
    }
}
