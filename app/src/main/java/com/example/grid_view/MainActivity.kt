package com.example.grid_view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.grid_view.ui.theme.Grid_ViewTheme

class MainActivity : AppCompatActivity() {

    var modalList = ArrayList<Modal>()

    var names = arrayOf(
        "seven",
        "eight",
        "x",
        "eleven",
        "twelve",
        "thirteen",
        "thirteenpro",
        "fourteen",
        "fifteen"
    )
    var images = intArrayOf (
        R.drawable.seven,
        R.drawable.eight,
        R.drawable.x,
        R.drawable.eleven,
        R.drawable.twelve,
        R.drawable.thirteen,
        R.drawable.thirteenpro,
        R.drawable.fourteen,
        R.drawable.fifteen,
        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acticvity_main)

        for(i in names.indices){
            modalList.add(Modal(names[i], images[i]))
        }

        var  customAdapter = CustomAdapter(modalList, this)

        var gridView = findViewById<GridView>(R.id.gridView)
        gridView.adapter=customAdapter
    }

    class CustomAdapter( var itemModel: ArrayList<Modal>, var context: Context ) : BaseAdapter()
    {
        var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        override fun getCount(): Int {
            return itemModel.size
        }

        override fun getItem(p0: Int): Any {
            return itemModel[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
            var view = view;
            if(view == null){
                view = layoutInflater.inflate(R.layout.row_items, viewGroup, false)
            }

            var tvImageName = view?.findViewById<TextView>(R.id.imageName)
            var imageView = view?.findViewById<ImageView>(R.id.imageView)

            tvImageName?.text = itemModel[position].name
            imageView?.setImageResource(itemModel[position].image!!)

            return view!!
        }
    }
}
