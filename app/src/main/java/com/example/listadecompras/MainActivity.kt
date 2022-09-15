package com.example.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        val list_view_item = findViewById<ListView>(R.id.list_view_item)
        val btn_salvar = findViewById<Button>(R.id.btn_salvar)
        val txt_produto = findViewById<EditText>(R.id.text_box_produto)

        list_view_item.adapter = produtosAdapter

        btn_salvar.setOnClickListener{
            val produto = txt_produto.text.toString()

            if(produto.isNotEmpty()){
                //envia item para a lista
                produtosAdapter.add(produto)
                //limpa a caixa de texto
                txt_produto.text.clear()

            }else{
                //exibe erro caso o campo esteja vazio
                txt_produto.error = "Campo vazio"
            }
        }

        list_view_item.setOnItemLongClickListener{
            adapterView: AdapterView<*>, view: View, position: Int, id: Long ->

            //busca o item clicado
            val item = produtosAdapter.getItem(position)

            //remove o item clicado na lista
            produtosAdapter.remove(item)
            true
        }

    }
}