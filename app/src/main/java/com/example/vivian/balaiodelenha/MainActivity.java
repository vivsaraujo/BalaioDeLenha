package com.example.vivian.balaiodelenha;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tx_consumo_total;
    private TextView tx_couvert;
    private TextView tx_dividir_pessoas;
    private TextView tx_taxa_servico;
    private TextView tx_total;
    private TextView tx_valor_pessoa;

    private EditText edt_consumo_total;
    private EditText edt_couvert;
    private EditText edt_dividir_pessoas;
    private EditText edt_taxa_servico;
    private EditText edt_total;
    private EditText edt_valor_pessoa;

    private Button bt_calcular;

    double consumoTotal;
    double couvertArtistico;
    Integer numPessoas;
    double taxaServico;
    double contaTotal;
    double valorPorPessoas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tx_consumo_total = (TextView) findViewById(R.id.tx_consumo_total);
        tx_couvert = (TextView) findViewById(R.id.tx_couvert);
        tx_dividir_pessoas = (TextView) findViewById(R.id.tx_dividir_pessoas);
        tx_taxa_servico = (TextView) findViewById(R.id.tx_taxa_servico);
        tx_total = (TextView) findViewById(R.id.tx_total);
        tx_valor_pessoa = (TextView) findViewById(R.id.tx_valor_pessoa);

        edt_consumo_total = (EditText) findViewById(R.id.edt_consumo_total);
        edt_couvert = (EditText) findViewById(R.id.edt_couvert);
        edt_dividir_pessoas = (EditText) findViewById(R.id.edt_dividir_pessoas);
        edt_taxa_servico = (EditText) findViewById(R.id.edt_taxa_servico);
        edt_total = (EditText) findViewById(R.id.edt_total);
        edt_valor_pessoa = (EditText) findViewById(R.id.edt_valor_pessoa);

        bt_calcular = (Button) findViewById(R.id.bt_calcular);

        tx_consumo_total.setText("Consumo Total R$:  ");
        tx_couvert.setText("Couvert Artístico R$:  ");
        tx_dividir_pessoas.setText("Dividir Conta Por:  ");
        tx_taxa_servico.setText("Taxa de Serviço(10%)R$  ");
        tx_total.setText("Conta Total R$:  ");
        tx_valor_pessoa.setText("Valor Por Pessoa R$:  ");

        bt_calcular.setText("Calcular Conta Final");

        bt_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                valorTaxaDeServico();
                valorContaTotal();
                valorPorPessoa();
            }
        });

    }

    public void valorTaxaDeServico(){

        consumoTotal = Double.parseDouble(edt_consumo_total.getText().toString());
        couvertArtistico = Double.parseDouble(edt_couvert.getText().toString());

        taxaServico = 0.1*(consumoTotal + couvertArtistico);

        edt_taxa_servico.setText(String.format("%.2f",taxaServico));
        edt_taxa_servico.setEnabled(false);
        edt_taxa_servico.setTextColor(Color.RED);

    }

    public void valorContaTotal(){

        consumoTotal = Double.parseDouble(edt_consumo_total.getText().toString());
        couvertArtistico = Double.parseDouble(edt_couvert.getText().toString());

        taxaServico = 0.1*(consumoTotal + couvertArtistico);
        contaTotal = (consumoTotal + couvertArtistico + taxaServico);

        edt_total.setText(String.format("%.2f",contaTotal));
        edt_total.setEnabled(false);
        edt_total.setTextColor(Color.RED);

    }

    public void valorPorPessoa(){

        consumoTotal = Double.parseDouble(edt_consumo_total.getText().toString());
        couvertArtistico = Double.parseDouble(edt_couvert.getText().toString());
        numPessoas = Integer.parseInt(edt_dividir_pessoas.getText().toString());

        taxaServico = 0.1*(consumoTotal + couvertArtistico);
        contaTotal = (consumoTotal + couvertArtistico + taxaServico);
        valorPorPessoas = contaTotal/numPessoas;

        edt_valor_pessoa.setText(String.format("%.2f",valorPorPessoas));
        edt_valor_pessoa.setEnabled(false);
        edt_valor_pessoa.setTextColor(Color.RED);
    }
}
