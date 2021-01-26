package marynych.rsue.menuproject

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    companion object{
        val COLOR_RED = 1
        val COLOR_BLUE = 2
        val COLOR_GREEN = 3
        val SIZE_22 = 4
        val SIZE_28 = 5
        val SIZE_32 = 6
    }
    lateinit var mTextColor: TextView
    lateinit var mSizeColor : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextColor = findViewById(R.id.tvColor)
        mSizeColor = findViewById(R.id.tvSize)

        registerForContextMenu(mTextColor)
        registerForContextMenu(mSizeColor)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
       when(v!!.id){
           R.id.tvColor ->{
               menu!!.add(0, COLOR_BLUE, 0, "Color Blue")
               menu.add(0, COLOR_GREEN,0,"Color Green")
               menu.add(0, COLOR_RED, 0, "Color Red")
           }
           R.id.tvSize ->{
               menu!!.add(0, SIZE_22, 0, "Size 22")
               menu.add(0, SIZE_28, 0, "Size 28")
               menu.add(0, SIZE_32, 0, "Size 32")
           }
       }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            COLOR_BLUE -> {
                mTextColor.setTextColor(Color.BLUE)
                mTextColor.setText("Color = Blue")
                return true
            }
            COLOR_RED -> {
                mTextColor.setTextColor(Color.RED)
                mTextColor.setText("Color = Red")
                return true
            }
            COLOR_GREEN -> {
                mTextColor.setTextColor(Color.GREEN)
                mTextColor.setText("Color = Green")
                return true
            }
            SIZE_22 -> {
                mSizeColor.setTextSize(22f)
                mSizeColor.setText("Size = 22")
                return true
            }
            SIZE_28 -> {
                mSizeColor.setTextSize(28f)
                mSizeColor.setText("Size = 28")
                return true
            }
            SIZE_32 -> {
                mSizeColor.setTextSize(32f)
                mSizeColor.setText("Size = 32")
                return true
            }
            else -> return super.onContextItemSelected(item)
        }
    }
    fun add(){}
}